package com.football.ql.datasource.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "competition")
public class CompetitionEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String code;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private AreaEntity area;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "competition_teams", schema = "public",
            joinColumns = {@JoinColumn(name = "competition_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")}
    )
    private List<TeamEntity> teams;
}
