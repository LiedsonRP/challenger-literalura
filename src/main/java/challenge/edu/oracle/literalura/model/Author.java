package challenge.edu.oracle.literalura.model;

import challenge.edu.oracle.literalura.dto.GutembergAuthorData;

import java.util.List;

public class Author {

    private Long id;
    private String name;
    private String birthYear;
    private String deathYear;
    private List<Book> booksWrited;

    public Author(){}

    public Author(Long id, String name, String birthYear, String deathYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Author(GutembergAuthorData data) {
        this.name = data.name();
        this.birthYear = data.birthDate();
        this.deathYear = data.deathYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                '}';
    }
}
