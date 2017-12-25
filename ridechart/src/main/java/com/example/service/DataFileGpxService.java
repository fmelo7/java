package com.example.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.DataGpx;
import com.example.domain.Trk;
import com.example.web.DataVo;

@Component
public class DataFileGpxService {

	@Autowired
	private DataGpxResource dataGpxResource;

	public DataGpx read(String fileuploaded) {

		try {

			String xmlGpx = new String(Files.readAllBytes(Paths.get(fileuploaded)));
			System.out.println(xmlGpx);
			JSONObject jo = XML.toJSONObject(xmlGpx);
			System.out.println(jo.toString());
			JSONArray trkpts = jo.getJSONObject("gpx").getJSONObject("trk").getJSONObject("trkseg").getJSONArray("trkpt");
			System.out.println(trkpts.toString());

			// Trackpoint[] trackpoints =
			// GpxReader.readTrack(Paths.get(fileuploaded).toFile());
			// List<Serializable> list = Arrays.asList(trackpoints,
			// Trackpoint.class);
			// List<Object> list = Arrays.asList(trkpts, JSONObject.class);

			DataGpx dataGpx = new DataGpx();
			dataGpx.setFilename(fileuploaded);

			dataGpx.setTrkpts(new ArrayList<Trk>());

			for (Object o : trkpts) {
				// for (Trackpoint o : trackpoints) {

				JSONObject pts = (JSONObject) o;
				System.out.println(pts);

				Trk trk = new Trk();
				dataGpx.getTrkpts().add(trk);

				if (pts.get("time") != null)
					trk.setTimestamp(pts.get("time").toString());

				if (pts.get("ele") != null)
					trk.setAltitude(pts.get("ele").toString());

				if (pts.get("lat") != null)
					trk.setPositionLat(pts.get("lat").toString());

				if (pts.get("lon") != null)
					trk.setPositionLong(pts.get("lon").toString());

				try {
					if (pts.get("extensions") != null) {
						JSONObject trackPointExtension = pts.getJSONObject("extensions").getJSONObject("gpxtpx:TrackPointExtension");
						if (trackPointExtension != null) {
							Object hr = trackPointExtension.get("gpxtpx:hr");
							if (hr != null)
								trk.setPositionLong(hr.toString());
						}
					}
				} catch (Exception e) {
				}

				//
				// trk.setAltitude(String.valueOf(o.getEle()));
				//
				// trk.setPositionLat(String.valueOf(o.getLat()));
				//
				// trk.setPositionLong(String.valueOf(o.getLon()));
				//
				// trk.setTimestamp(String.valueOf(o.getTime()));

			}

			return dataGpx;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void save(DataGpx data) {

		DataGpx exist = dataGpxResource.findByFilename(data.getFilename());

		if (exist != null) {
			dataGpxResource.delete(exist);
		}

		dataGpxResource.save(data);
	}

	public List<DataVo> transform(DataGpx dataGpx, String dataX, String dataY) {
		final List<DataVo> result = new ArrayList<>();
		dataGpx.getTrkpts().forEach(o -> {
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

	public List<DataVo> groupBy(List<DataVo> data) {
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
