package com.example.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.DataModel;
import com.example.domain.DataRecord;
import com.example.web.DataVo;
import com.garmin.fit.Decode;
import com.garmin.fit.DeveloperField;
import com.garmin.fit.DeveloperFieldDescription;
import com.garmin.fit.DeveloperFieldDescriptionListener;
import com.garmin.fit.DeviceInfoMesg;
import com.garmin.fit.DeviceInfoMesgListener;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.FileIdMesgListener;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.MonitoringMesg;
import com.garmin.fit.MonitoringMesgListener;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;
import com.garmin.fit.UserProfileMesg;
import com.garmin.fit.UserProfileMesgListener;

@Component
public class DataFileFitService {

    @Autowired
    private DataModelResource dataModelResource;

    public DataModel read(final String file) {

	final Decode decode = new Decode();
	final MesgBroadcaster broadcaster = new MesgBroadcaster();
	final DataModelListener listener = new DataModelListener();
	FileInputStream in;

	// System.out.printf("FIT Decode Example Application - Protocol %d.%d
	// Profile %.2f %s\n",
	// Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR,
	// Fit.PROFILE_VERSION / 100.0, Fit.PROFILE_TYPE);

	try {
	    in = new FileInputStream(file);
	} catch (java.io.IOException e) {
	    throw new RuntimeException("Error opening file " + file + " [1]");
	}

	try {
	    if (!decode.checkFileIntegrity((InputStream) in))
		throw new RuntimeException("FIT file integrity failed.");
	} catch (RuntimeException e) {
	    System.err.print("Exception Checking File Integrity: ");
	    System.err.println(e.getMessage());
	    System.err.println("Trying to continue...");
	} finally {
	    try {
		in.close();
	    } catch (java.io.IOException e) {
		throw new RuntimeException(e);
	    }
	}

	try {
	    in = new FileInputStream(file);
	} catch (java.io.IOException e) {
	    throw new RuntimeException("Error opening file " + file + " [2]");
	}

	broadcaster.addListener((FileIdMesgListener) listener);
	broadcaster.addListener((UserProfileMesgListener) listener);
	broadcaster.addListener((DeviceInfoMesgListener) listener);
	broadcaster.addListener((MonitoringMesgListener) listener);
	broadcaster.addListener((RecordMesgListener) listener);

	decode.addListener((DeveloperFieldDescriptionListener) listener);

	try {
	    decode.read(in, broadcaster, broadcaster);
	} catch (FitRuntimeException e) {
	    // If a file with 0 data size in it's header has been encountered,
	    // attempt to keep processing the file
	    if (decode.getInvalidFileDataSize()) {
		decode.nextFile();
		decode.read(in, broadcaster, broadcaster);
	    } else {
		System.err.print("Exception decoding file: ");
		System.err.println(e.getMessage());

		try {
		    in.close();
		} catch (java.io.IOException f) {
		    throw new RuntimeException(f);
		}

		return null;
	    }
	}

	try {
	    in.close();
	} catch (java.io.IOException e) {
	    throw new RuntimeException(e);
	}

	return listener.getDataModel();
    }

    public static class DataModelListener implements FileIdMesgListener, UserProfileMesgListener,
	    DeviceInfoMesgListener, MonitoringMesgListener, RecordMesgListener, DeveloperFieldDescriptionListener {

	private DataModel dataModel = new DataModel();

	public DataModel getDataModel() {
	    return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
	    this.dataModel = dataModel;
	}

	@Override
	public void onMesg(final FileIdMesg mesg) {
	    if (mesg.getType() != null)
		dataModel.getDataFileId().setType(mesg.getType().getValue());
	    if (mesg.getManufacturer() != null)
		dataModel.getDataFileId().setManufacture(mesg.getManufacturer());
	    if (mesg.getTimeCreated() != null)
		dataModel.getDataFileId().setTimeCreated(mesg.getTimeCreated().getTimestamp());
	    if (mesg.getProduct() != null)
		dataModel.getDataFileId().setProduct(mesg.getProduct());
	    if (mesg.getSerialNumber() != null)
		dataModel.getDataFileId().setSerialNumber(mesg.getSerialNumber());
	    if (mesg.getNumber() != null)
		dataModel.getDataFileId().setNumber(mesg.getNumber());
	}

	@Override
	public void onMesg(final UserProfileMesg mesg) {
	    if (mesg.getFriendlyName() != null)
		dataModel.getDataUserProfile().setFriendlyName(mesg.getFriendlyName());
	    if (mesg.getGender() != null)
		dataModel.getDataUserProfile().setGender(mesg.getGender().toString());
	    if (mesg.getAge() != null)
		dataModel.getDataUserProfile().setAge(mesg.getAge());
	    if (mesg.getWeight() != null)
		dataModel.getDataUserProfile().setWeight(mesg.getWeight());
	}

	@Override
	public void onMesg(final DeviceInfoMesg mesg) {
	    if (mesg.getTimestamp() != null)
		dataModel.getDataDeviceInfo().setTimestamp(mesg.getTimestamp().getTimestamp());
	    if (mesg.getBatteryStatus() != null)
		dataModel.getDataDeviceInfo().setBatteryStatus(mesg.getBatteryStatus().toString());
	}

	@Override
	public void onMesg(final MonitoringMesg mesg) {
	    if (mesg.getTimestamp() != null)
		dataModel.getDataMonitoring().setTimestamp(mesg.getTimestamp().getTimestamp());
	    if (mesg.getActivityType() != null)
		dataModel.getDataMonitoring().setActivityType(mesg.getActivityType().toString());
	    // Depending on the ActivityType, there may be Steps, Strokes, or
	    // Cycles present in the file
	    if (mesg.getSteps() != null)
		dataModel.getDataMonitoring().setSteps(mesg.getSteps());
	    if (mesg.getStrokes() != null)
		dataModel.getDataMonitoring().setStrokes(mesg.getStrokes());
	    if (mesg.getCycles() != null)
		dataModel.getDataMonitoring().setCycles(mesg.getCycles());
	    // TODO printDeveloperData(mesg);
	}

	@Override
	public void onMesg(final RecordMesg mesg) {
	    DataRecord record = new DataRecord();
	    if (mesg.getHeartRate() != null)
		record.setHeartRate(mesg.getHeartRate());
	    if (mesg.getCadence() != null)
		record.setCadence(mesg.getCadence());
	    if (mesg.getDistance() != null)
		record.setDistance(mesg.getDistance());
	    if (mesg.getSpeed() != null)
		record.setSpeed(mesg.getSpeed());
	    if (mesg.getAltitude() != null)
		record.setAltitude(mesg.getAltitude());
	    if (mesg.getPositionLat() != null)
		record.setPositionLat(mesg.getPositionLat());
	    if (mesg.getPositionLong() != null)
		record.setPositionLong(mesg.getPositionLong());
	    if (mesg.getTimestamp() != null)
		record.setTimestamp(mesg.getTimestamp().getTimestamp());
	    if (mesg.getPower() != null)
		record.setPower(mesg.getPower());
	    if (mesg.getGrade() != null)
		record.setGrade(mesg.getGrade());
	    if (mesg.getCalories() != null)
		record.setCalories(mesg.getCalories());
	    dataModel.getDataRecords().add(record);
	    printDeveloperData(mesg, record);
	}

	private void printDeveloperData(final Mesg mesg, final DataRecord record) {
	    for (DeveloperField field : mesg.getDeveloperFields()) {
		if (field.getNumValues() < 1) {
		    continue;
		}
		if (field.isDefined()) {
		    System.out.print("   " + field.getName());
		    if (field.getUnits() != null) {
			System.out.print(" [" + field.getUnits() + "]");
		    }
		    System.out.print(": ");
		}
		System.out.print(field.getValue(0));
		for (int i = 1; i < field.getNumValues(); i++) {
		    System.out.print("," + field.getValue(i));
		}
	    }
	}

	@Override
	public void onDescription(final DeveloperFieldDescription desc) {
	    // if (desc.getApplicationId() != null)
	    dataModel.getDataDeveloperFieldDescription().setApplicationId(desc.getApplicationId());
	    // if (desc.getApplicationVersion() != null)
	    dataModel.getDataDeveloperFieldDescription().setApplicationVersion(desc.getApplicationVersion());
	    // if (desc.getFieldDefinitionNumber() != null)
	    dataModel.getDataDeveloperFieldDescription().setFieldDefinitionNumber(desc.getFieldDefinitionNumber());
	}
    }

    public void save(final DataModel data) {

	DataModel exist = dataModelResource.findByFilename(data.getFilename());

	if (exist != null) {
	    dataModelResource.delete(exist);
	}

	dataModelResource.save(data);
    }

    public List<DataVo> transform(final DataModel dataModel, final String dataX, final String dataY) {
	final List<DataVo> result = new ArrayList<>();
	dataModel.getDataRecords().forEach(o -> {
	    final DataVo vo = new DataVo();
	    Arrays.asList(o.getClass().getDeclaredMethods()).forEach(m -> {
		try {
		    if (m.getName().toLowerCase().contains("get" + dataX))
			vo.setX(String.valueOf(m.invoke(o)));
		    if (m.getName().toLowerCase().contains("get" + dataY))
			vo.setY(String.valueOf(m.invoke(o)));
		} catch (Exception e) {
		    System.out.println("Erro no reflection: " + e);
		}
	    });
	    result.add(vo);
	});
	return result;
    }

    public List<DataVo> groupBy(final List<DataVo> data) {
	final List<DataVo> result = new ArrayList<>();
	final Map<String, DataVo> res = new HashMap<>();
	data.forEach(o -> {
	    if (!res.containsKey(o.getX())) {
		res.put(o.getX(), o);
		result.add(o);
	    } else {
		DataVo tmp = res.get(o.getX());
		float tmpval = Float.valueOf(tmp.getY());
		float val = Float.valueOf(o.getY());
		tmp.setY(String.valueOf(Integer.valueOf(Math.round((tmpval + val) / 2))));
		// tmp.setY(String.valueOf(Integer.valueOf(Math.round(tmpval +
		// val))));
		// tmp.setY(String.valueOf(Integer.valueOf(Math.round(Math.max(tmpval,
		// val)))));
		// tmp.setY(String.valueOf(Integer.valueOf(Math.round(Math.min(tmpval,
		// val)))));
	    }
	});
	return result;
    }
}
