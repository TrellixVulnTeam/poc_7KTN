package com.foot.poc.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class MeetUp extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @OneToOne
    private User host;
    @OneToMany
    private Set<User> guests;
    private String firstTeam;
    private String secondTeam;


    public MeetUp() {
        this.guests = new HashSet<>();
    }
}
