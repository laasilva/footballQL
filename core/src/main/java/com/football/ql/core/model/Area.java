package com.football.ql.core.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Area {
    Long id;
    String name;
    String code;
    String flag;
}
