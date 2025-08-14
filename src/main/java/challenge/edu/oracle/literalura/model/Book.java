package challenge.edu.oracle.literalura.model;

import challenge.edu.oracle.literalura.dto.GutembergBookData;
import jakarta.persistence.*;


import java.util.List;

@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @Column(name = "download_number")
    private Integer downloadNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "------------------------\ntitle ='" + title + '\'' +
                ", author =" + author.getName() +
                ", language =" + language.getName() +
                ", downloadNumber =" + downloadNumber;
    }
}
