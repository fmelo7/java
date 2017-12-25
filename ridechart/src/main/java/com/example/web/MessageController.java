package com.example.web;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Message;
import com.example.service.MessageResource;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageResource messageResource;

	@ResponseBody
	@RequestMapping("/create")
	public ResponseEntity<?> create() {

		messageResource.save(new Message("my message"));

		List<Message> records = messageResource.findAll();

		return ResponseEntity.ok(records);
	}

	@ResponseBody
	@RequestMapping("/delete")
	public ResponseEntity<?> delete() {

		Message message = messageResource.findAll().stream().findAny().get();

		messageResource.delete(message);

		return ResponseEntity.ok(messageResource.findAll());
	}

	@ResponseBody
	@RequestMapping("/modify")
	public ResponseEntity<?> modify() {

		Message message = messageResource.findAll().stream().findAny().get();
		message.setName("message modify");
		message.setModify(Calendar.getInstance());

		messageResource.save(message);

		return ResponseEntity.ok(messageResource.findAll());
	}

	@ResponseBody
	@RequestMapping("/retrieve")
	public ResponseEntity<?> retrieve(@PathVariable Long id) {

		Message message = messageResource.findOne(id);

		return ResponseEntity.ok(message);
	}
}
