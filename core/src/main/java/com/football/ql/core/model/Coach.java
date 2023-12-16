package com.football.ql.core.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coach {
    Long id;
    Person person;
}
