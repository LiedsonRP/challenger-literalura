package challenge.edu.oracle.literalura;

import challenge.edu.oracle.literalura.dto.GutembergBookData;
import challenge.edu.oracle.literalura.model.Author;
import challenge.edu.oracle.literalura.model.Book;
import challenge.edu.oracle.literalura.model.Language;
import challenge.edu.oracle.literalura.repository.AuthorRepository;
import challenge.edu.oracle.literalura.repository.BookRepository;
import challenge.edu.oracle.literalura.service.GutenbergAPIService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private final Scanner scanner = new Scanner(System.in);

    public Principal(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void runProgram() {

        int option;

        do {
            System.out.println("""
                    ESCOLHA O NÚMERO DE SUA OPÇÃO
                    ---------------------------------
                    
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair
                    
                    Insira a opção que deseja consultar:
                    """);

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    getBookFromAPI();
                    break;

                case 2:
                    getAllBooksRegistered();
                    break;

                case 3:
                    getAllAuthorsRegistered();
                    break;

                case 4:
                    getAuthorsAliveInYear();
                    break;

                case 5:
                    getAllBooksInLanguage();
                    break;

                case 0:
                    System.out.println("Finalizando programa");
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while (option != 0);

        System.out.println("Fim do programa");
    }

    @Transactional
    public void getBookFromAPI() {

        System.out.println("Qual o nome do livro? ");
        String bookName = scanner.nextLine().toLowerCase();

        System.out.println(bookName);

        GutenbergAPIService api = new GutenbergAPIService();

        System.out.println("\n----Buscando livro na base");

        try {
            GutembergBookData dados = api.getBookAuthorData(bookName);

            System.out.println("\n----Salvando no banco de dados");
            Book book = new Book(dados);
            this.bookRepository.save(book);

        } catch (NoSuchElementException ex) {
            System.out.println("Livro não encontrado na base de dados");
        }

    }

    public void getAllBooksRegistered() {
        List<Book> books = bookRepository.findAll();
        books.forEach(b -> System.out.println(b.toString()));
    }

    public void getAllAuthorsRegistered() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(a -> System.out.println(a.toString()));
    }

    public void getAuthorsAliveInYear() {

        System.out.println("Qual ano deseja verificar? (YYYY)");
        var yearSearched = scanner.nextLine();

        List<Author> authors = authorRepository.findByBirthYear(yearSearched);

        if (authors.isEmpty()) {
            System.out.println("Não há autores vivos neste ano cadastrados no banco");
        } else {
            authors.forEach(a -> System.out.println(a.toString()));
        }
    }

    public void getAllBooksInLanguage() {

        List<Language> languageList = Arrays.stream(Language.values()).toList();

        System.out.println("Linguagens disponíveis");
        languageList
                .forEach(l -> System.out.println( l.getSymbol() + " - " + l.getName()));

        System.out.println("\nDigite a sigla da linguagem pedida: ");
        var symbol = scanner.nextLine();

        Language languageChose = Language.getLanguageBySimbol(symbol);

        List<Book> books = this.bookRepository.findByLanguage(languageChose);
        books.forEach(b -> System.out.println(b.toString()));
    }
}
