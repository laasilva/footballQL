package com.football.ql.core.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    Long id;
    String name;
    Date dateOfBirth;
    String nationality;
    String gamePosition;
}
