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
@Table(name = "coach")
public class CoachEntity {
    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;
}
