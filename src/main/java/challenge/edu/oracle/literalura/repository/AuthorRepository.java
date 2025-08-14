package challenge.edu.oracle.literalura.repository;

import challenge.edu.oracle.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    public List<Author> findByBirthYear(String year);
}
