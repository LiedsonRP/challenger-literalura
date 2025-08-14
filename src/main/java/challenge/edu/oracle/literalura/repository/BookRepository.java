package challenge.edu.oracle.literalura.repository;

import challenge.edu.oracle.literalura.model.Book;
import challenge.edu.oracle.literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(Language language);
}
