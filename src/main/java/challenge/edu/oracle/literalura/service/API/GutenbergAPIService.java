package challenge.edu.oracle.literalura.service.API;

import challenge.edu.oracle.literalura.dto.GutembergBookData;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GutenbergAPIService {

    private static final String API_URL = "https://gutendex.com/books?search=";

    public GutembergBookData getBookAuthorData(String bookName) {

        API api = new API();

        String titleParam = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        String completeURL = API_URL + titleParam;

        String json = api.getData(completeURL);

        System.out.println(json);

        return null;
    }
}
