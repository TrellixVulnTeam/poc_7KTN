package com.foot.poc.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MeetUp {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User host;

    @OneToMany
    private Set<User> guests;

    private String firstTeam;
    private String secondTeam;


    public MeetUp() {
        this.guests = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
