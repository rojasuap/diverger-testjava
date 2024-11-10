package es.petama.diverger.swapi.api_restful.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeopleDto {
            private String name;
            private Integer height;
            private Integer mass;
            @JsonAlias({ "hair_color"})
            private String hairColor;
            @JsonAlias({ "skin_color"})
            private String skinColor;
            @JsonAlias({ "eye_color"})
            private String eyeColor;
            @JsonAlias({ "birth_year"})
            private String birthYear;
            private String gender;
            private String homeworld;
            private List<String> films;
            private List<String> species;
            private List<String> vehicles;
            private List<String> starships;
            private String created;
            private String edited;
            private String url;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hairColor='" + hairColor + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", films=" + films +
                ", species=" + species +
                ", vehicles=" + vehicles +
                ", starships=" + starships +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
