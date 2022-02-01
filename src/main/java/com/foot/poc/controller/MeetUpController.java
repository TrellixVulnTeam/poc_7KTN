package com.foot.poc.controller;


import com.foot.poc.model.MeetUp;
import com.foot.poc.service.MeetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class MeetUpController {

    @Autowired
    private MeetUpService meetUpService;


    @GetMapping("meetups")
    Collection<MeetUp> findAllMeetUps() {
        return this.meetUpService.findAllMeetUps();
    }

    @GetMapping("meetups/{id}")
    MeetUp findMeetUp(@PathVariable Long id) {
        return this.meetUpService.findMeetUp(id);
    }

    @DeleteMapping("meetups/{id}")
    void deleteMeetUp(@PathVariable Long id) {
        this.meetUpService.deleteMeetUp(id);
    }

    /*
    @PostMapping("meetups")
    MeetUp createMeetUp(@RequestBody MeetUp newMeetUp){
        return this.meetUpService.createMeetUp(newMeetUp);
    }
    */

}
