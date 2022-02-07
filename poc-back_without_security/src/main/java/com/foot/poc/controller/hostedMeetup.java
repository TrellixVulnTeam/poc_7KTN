package com.foot.poc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foot.poc.model.MeetUp;
import com.foot.poc.service.impl.MeetUpServiceImpl;

@RestController
@RequestMapping("hostedMeetup")
public class hostedMeetup {
	@Autowired
	 private MeetUpServiceImpl meetUpService;
		@CrossOrigin
	 	@GetMapping
	    Collection<MeetUp> addGuestToMeetUp(@RequestParam Long id) {
	    	return meetUpService.getHosted(id);
	    }
}
