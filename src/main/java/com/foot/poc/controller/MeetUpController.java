package com.foot.poc.controller;


import com.foot.poc.model.MeetUp;
import com.foot.poc.service.MeetUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("meetups")
public class MeetUpController {

    @Autowired
    private MeetUpService meetUpService;


    @GetMapping
    Collection<MeetUp> findAllMeetUps() {
        return this.meetUpService.findAllMeetUps();
    }

    @GetMapping("{id}")
    MeetUp findMeetUp(@PathVariable Long id) {
        return this.meetUpService.findMeetUp(id);
    }

    @DeleteMapping("{id}")
    void deleteMeetUp(@PathVariable Long id) {
        this.meetUpService.deleteMeetUp(id);
    }


    @PostMapping()
    MeetUp createMeetUp(@RequestBody MeetUp newMeetUp) {
        return this.meetUpService.createMeetUp(newMeetUp);
    }

}
