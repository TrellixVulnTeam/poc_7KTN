package com.foot.poc.controller;


import com.foot.poc.model.MeetUp;
import com.foot.poc.service.MeetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("meetups")
public class MeetUpController {

    @Autowired
    private MeetUpService meetUpService;

    @GetMapping
    Collection<MeetUp> findAllMeetUps() {
        return meetUpService.findAllMeetUps();
    }

    @GetMapping("{id}")
    MeetUp findMeetUp(@PathVariable Long id) {
        return meetUpService.findMeetUp(id);
    }

    @DeleteMapping("{id}")
    void deleteMeetUp(@PathVariable Long id) {
        meetUpService.deleteMeetUp(id);
    }

    @PostMapping
    MeetUp createMeetUp(@RequestParam Long id, @RequestBody MeetUp newMeetUp) {
        return meetUpService.createMeetUp(newMeetUp, id);
    }
    
   
    
    @PutMapping("{id}")
    MeetUp updateMeetUp(@PathVariable Long id, @RequestBody MeetUp meetUp) {
        return meetUpService.updateMeetUp(id, meetUp);
    }  

}