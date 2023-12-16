package com.football.ql.core.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {
    Long id;
    String name;
    String shortName;
    String tla;
    Area area;
    String address;
    Coach coach;
    List<Player> players;
}
