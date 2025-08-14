package challenge.edu.oracle.literalura;

import challenge.edu.oracle.literalura.dto.GutembergBookData;
import challenge.edu.oracle.literalura.model.Book;
import challenge.edu.oracle.literalura.repository.AuthorRepository;
import challenge.edu.oracle.literalura.repository.BookRepository;
import challenge.edu.oracle.literalura.service.GutenbergAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal(bookRepository, authorRepository);
        principal.runProgram();




    }
}
