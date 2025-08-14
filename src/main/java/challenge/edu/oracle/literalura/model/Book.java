package challenge.edu.oracle.literalura.model;

import challenge.edu.oracle.literalura.dto.GutembergBookData;

import java.util.List;

public class Book {

    private Long id;
    private String title;
    private Author author;
    private Language language;
    private Integer downloadNumber;

    public Book() {}

    public Book(Long id, String title, Author author, Language language, Integer downloadNumber) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.downloadNumber = downloadNumber;
    }

    public Book(GutembergBookData data) {
        this.title = data.title();
        this.author = new Author(data.author().getFirst());
        this.language = Language.getLanguageBySimbol(data.languages().getFirst());
        this.downloadNumber = data.dowloadNumber();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(Integer downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", language=" + language +
                ", downloadNumber=" + downloadNumber +
                '}';
    }
}
