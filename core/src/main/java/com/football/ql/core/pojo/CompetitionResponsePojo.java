package com.football.ql.core.pojo;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionResponsePojo {
    Long id;
    String name;
    String code;
    String eblem;
    AreaPojo area;
}
