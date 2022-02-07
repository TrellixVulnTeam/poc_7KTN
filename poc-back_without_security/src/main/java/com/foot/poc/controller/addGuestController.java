package com.foot.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foot.poc.model.MeetUp;
import com.foot.poc.model.User;
import com.foot.poc.service.impl.MeetUpServiceImpl;

@RestController
@RequestMapping("addGuest")
public class addGuestController {
	
	@Autowired
	 private MeetUpServiceImpl meetUpService;
		@CrossOrigin
	 	@PutMapping
	    MeetUp addGuestToMeetUp(@RequestParam Long id, @RequestBody User guest) {
	    	return meetUpService.addGuest(id, guest);
	    }
}
