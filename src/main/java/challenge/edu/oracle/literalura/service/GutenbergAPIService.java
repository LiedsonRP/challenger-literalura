package challenge.edu.oracle.literalura.service;

import challenge.edu.oracle.literalura.dto.GutembergResponseData;
import challenge.edu.oracle.literalura.dto.GutembergBookData;
import challenge.edu.oracle.literalura.service.API.API;
import challenge.edu.oracle.literalura.service.API.JSONConverter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GutenbergAPIService {

    private static final String API_URL = "https://gutendex.com/books/?search=";

    public GutembergBookData getBookAuthorData(String bookName) {

        API api = new API();
        JSONConverter jsonConverter = new JSONConverter();

        String titleParam = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        String completeURL = API_URL + titleParam;

        System.out.println(completeURL);
        String json = api.getData(completeURL);

        GutembergResponseData response =  jsonConverter.getData(json, GutembergResponseData.class);

        return response.results().getFirst();
    }
}
