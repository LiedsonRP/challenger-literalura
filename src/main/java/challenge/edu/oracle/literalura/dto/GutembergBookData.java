package challenge.edu.oracle.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutembergBookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<GutembergAuthorData> author,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer dowloadNumber
) {
}
