package com.football.ql.datasource.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "team_players", schema = "public",
            joinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "team_id", insertable = false,
                            updatable = false, referencedColumnName = "id")
            }
    )
    private TeamEntity team;

}
