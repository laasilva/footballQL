package com.football.ql.core.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponsePojo {
    int count;
    List<TeamPojo> teams;

}
