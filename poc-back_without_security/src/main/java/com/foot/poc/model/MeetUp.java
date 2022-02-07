package com.foot.poc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class MeetUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Long hostId;

    @ManyToMany
    private Set<User> guests;
    private String firstTeam;
    private String secondTeam;
    private String location;
    public MeetUp() {
        this.guests = new HashSet<>();
    }

    public void addGuest(User guest) {
        this.guests.add(guest);
    }

}
