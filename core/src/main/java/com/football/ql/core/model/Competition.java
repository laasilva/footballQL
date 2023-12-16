package com.football.ql.core.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competition {
    Long id;
    String name;
    String code;
    Area area;
    List<Team> teams;
}
