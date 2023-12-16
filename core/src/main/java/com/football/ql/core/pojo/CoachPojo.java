package com.football.ql.core.pojo;

import com.football.ql.core.util.DateDeserializer;
import com.google.gson.annotations.JsonAdapter;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachPojo {
    Long id;
    String name;
    @JsonAdapter(DateDeserializer.class)
    Date dateOfBirth;
    String nationality;
}
