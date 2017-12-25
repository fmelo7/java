package com.example.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Application;
import com.example.domain.DataGpx;
import com.example.domain.DataModel;
import com.example.service.DataFileFitService;
import com.example.service.DataFileGpxService;
import com.example.service.DataFileType;
import com.example.service.DataGpxResource;
import com.example.service.DataModelResource;

@Controller
@RequestMapping("/datamodel")
public class DataModelController {

	@Autowired
	private DataModelResource dataModelResource;

	@Autowired
	private DataGpxResource dataGpxResource;

	@Autowired
	private DataFileFitService dataFileFitService;

	@Autowired
	private DataFileGpxService dataFileGpxService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		String name = file.getOriginalFilename();

		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
			return "redirect:#/";
		}

		try {

			if (file.isEmpty()) {
				throw new Exception(" because the file was empty");
			}

			if (FilenameUtils.getExtension(name) == null) {
				throw new Exception(" because file has no type");
			}

			String fileuploaded = Application.ROOT + "/" + name;
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileuploaded)));
			FileCopyUtils.copy(file.getInputStream(), stream);
			stream.close();
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + name + "!");

			if (DataFileType.FIT.toString().equals(FilenameUtils.getExtension(name).toUpperCase())) {

				DataModel data = dataFileFitService.read(fileuploaded);
				data.setFilename(name);
				dataFileFitService.save(data);

			} else if (DataFileType.GPX.toString().equals(FilenameUtils.getExtension(name).toUpperCase())) {

				DataGpx data = dataFileGpxService.read(fileuploaded);
				data.setFilename(name);
				dataFileGpxService.save(data);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "You failed to upload" + name + " => " + e.getMessage());
			e.printStackTrace();
		}

		return "redirect:#!/";
	}

	@ResponseBody
	@RequestMapping(value = "/list", produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> list() {
		// return ResponseEntity.ok(dataModelResource.findAll(new
		// Sort(Sort.Direction.DESC, "filename")));
		return ResponseEntity.ok(dataGpxResource.findAll(new Sort(Sort.Direction.DESC, "filename")));
	}

	@ResponseBody
	@RequestMapping("/read")
	public ResponseEntity<?> read(@RequestParam(name = "id") Long id) {

		DataModel dataModel = dataModelResource.findOne(id);

		if (dataModel != null) {
			List<DataVo> data1 = dataFileFitService.transform(dataModel, "distance", "altitude");
			List<DataVo> data2 = dataFileFitService.transform(dataModel, "distance", "speed");

			data1.forEach(o -> o.setX(String.valueOf(Math.round(Float.valueOf(o.getX()) / 1000))));
			data1.forEach(o -> o.setY(String.valueOf(Math.round(Float.valueOf(o.getY())))));

			data2.forEach(o -> o.setX(String.valueOf(Math.round(Float.valueOf(o.getX()) / 1000))));
			data2.forEach(o -> o.setY(String.valueOf(Math.round(Float.valueOf(o.getY()) * 3.6))));

			data1 = dataFileFitService.groupBy(data1);
			data2 = dataFileFitService.groupBy(data2);

			ResponseDataVo responseData = new ResponseDataVo(data1, data2);

			return ResponseEntity.ok(responseData);

		}

		DataGpx dataGpx = dataGpxResource.findOne(id);
		if (dataGpx != null) {
			List<DataVo> data1 = dataFileGpxService.transform(dataGpx, "distance", "altitude");
			List<DataVo> data2 = dataFileGpxService.transform(dataGpx, "distance", "speed");

			//data1.forEach(o -> System.out.println("X : " + o.getX() + " Y : " + o.getY()));

			//data1.forEach(o -> o.setX(String.valueOf(Math.round(Float.valueOf(o.getX()) / 1000))));
			//data1.forEach(o -> o.setY(String.valueOf(Math.round(Float.valueOf(o.getY())))));

			//data2.forEach(o -> o.setX(String.valueOf(Math.round(Float.valueOf(o.getX()) / 1000))));
			//data2.forEach(o -> o.setY(String.valueOf(Math.round(Float.valueOf(o.getY()) * 3.6))));

			//data1 = dataFileFitService.groupBy(data1);
			//data2 = dataFileFitService.groupBy(data2);

			ResponseDataVo responseData = new ResponseDataVo(data1, data2);

			return ResponseEntity.ok(responseData);
		}
		// TODO resposta de atividade não encontrada
		return ResponseEntity.ok(null);
	}

	@ResponseBody
	@RequestMapping("/create")
	public ResponseEntity<?> create() {

		DataModel dataModel = new DataModel();

		dataModelResource.save(dataModel);

		return ResponseEntity.ok(dataModelResource.findAll());
	}

	@ResponseBody
	@RequestMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam(name = "id") Long id) {

		DataModel model = dataModelResource.findOne(id);

		dataModelResource.delete(model);

		return ResponseEntity.ok(dataModelResource.findAll());
	}

}
