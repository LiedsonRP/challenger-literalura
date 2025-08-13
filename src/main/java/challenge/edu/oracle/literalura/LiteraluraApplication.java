package challenge.edu.oracle.literalura;

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

        GutenbergAPIService api = new GutenbergAPIService();
        api.getBookAuthorData("moby dick");
    }
}
