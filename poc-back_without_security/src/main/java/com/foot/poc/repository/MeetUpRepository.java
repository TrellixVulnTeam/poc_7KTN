package com.foot.poc.repository;

import com.foot.poc.model.MeetUp;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetUpRepository extends JpaRepository<MeetUp, Long> {

	Collection<MeetUp> findByHostId(Long id);
	
	Collection<MeetUp> findByLocation(String location);
}
