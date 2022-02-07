package com.foot.poc.service;

import com.foot.poc.model.MeetUp;
import com.foot.poc.model.User;

import java.util.Collection;


public interface MeetUpService {

    Collection<MeetUp> findAllMeetUps();

    MeetUp findMeetUp(Long id);

    void deleteMeetUp(Long id);

    MeetUp createMeetUp(MeetUp meetUp, Long id);

    MeetUp updateMeetUp(Long id, MeetUp meetUp);

	MeetUp addGuest(Long id, User guest);

	

	Collection<MeetUp> getHosted(Long id);
	
	Collection<MeetUp> getSameCity(String location);

}
