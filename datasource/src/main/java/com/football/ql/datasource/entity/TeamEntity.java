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
@Table(name = "team")
public class TeamEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String shortName;
    @Column
    private String tla;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "area_id")
    private AreaEntity area;
    @Column
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private CoachEntity coach;
    @ManyToMany(mappedBy = "teams")
    private List<CompetitionEntity> competitions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "team_players", schema = "public",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id")}
    )
    private List<PlayerEntity> players;

}
