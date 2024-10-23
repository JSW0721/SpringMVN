package com.estsoft.springmvc.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //양방향 연과관계 -> oneTomany(x)성능에 악영향.
    @OneToMany(mappedBy = "team")//연관관계의 주인 명시.
    private List<Member> members = new ArrayList<>();
}