package challenge.edu.oracle.literalura;

import challenge.edu.oracle.literalura.dto.GutembergBookData;
import challenge.edu.oracle.literalura.model.Book;
import challenge.edu.oracle.literalura.service.API.GutenbergAPIService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("começou");
        GutenbergAPIService api = new GutenbergAPIService();
        GutembergBookData dados = api.getBookAuthorData("moby dick");
        Book book = new Book(dados);
        System.out.println(book.toString());
    }
}
