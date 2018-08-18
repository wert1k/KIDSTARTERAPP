package com.javamentor.kidstarter.controller;

import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.service.service_abstract.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

	static final Logger logger = LoggerFactory.getLogger(TagController.class);

	@Autowired
	public TagService tagService;

	@GetMapping("/tag/{id}")
	public ResponseEntity<?> getTagId(@PathVariable("id") long id) {
		Tag tag = tagService.getTagId(id);
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@GetMapping("/tags")
	public ResponseEntity<List<Tag>> listAllTags() {
		List<Tag>tag = tagService.getAllTag();
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@DeleteMapping("/tag/{id}")
	public ResponseEntity<?> deleteTag(@PathVariable("id") long id) {
		tagService.deleteTagById(id);
		return new ResponseEntity<Tag>(HttpStatus.OK);
	}

	@PostMapping("/tag")
	public ResponseEntity<?> addTag(@ModelAttribute("name") Tag currentTag) {
		tagService.addTag(currentTag);
		return new ResponseEntity<>(currentTag, HttpStatus.OK);
	}

	@PutMapping("/tag/{id}")
	public ResponseEntity<?>  editTag(@ModelAttribute("tag") Tag currentTag, @PathVariable("id") long id) {
		Tag newTag = tagService.getTagId(id);
		newTag.setName(currentTag.getName());
		tagService.updateTag(newTag);
		return new ResponseEntity<>(newTag, HttpStatus.OK);
	}
}
