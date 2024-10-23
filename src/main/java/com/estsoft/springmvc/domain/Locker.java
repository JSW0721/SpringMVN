package com.estsoft.springmvc.domain;

import jakarta.persistence.*;

@Entity
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne(mappedBy = "locker")
    private Member member;//양방향 연관 관계 설정
}
