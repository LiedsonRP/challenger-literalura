package challenge.edu.oracle.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutembergAuthorData(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") String birthDate,
        @JsonAlias("death_year") String deathYear
) {
}
