package com.football.ql.core.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamPojo {
    Long id;
    String name;
    String shortName;
    String tla;
    String crest;
    String address;
    String website;
    String founded;
    AreaPojo area;
    @SerializedName(value = "squad")
    List<PlayerPojo> players;
    CoachPojo coach;

}
