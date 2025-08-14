package challenge.edu.oracle.literalura.model;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

public enum Language {

    EN("en", "INGLÊS"),
    ES("es", "ESPANHOL"),
    FR("fr", "FRANCÊS"),
    PT("pt", "PORTUGUÊS");

    private String symbol;
    private String name;

    Language(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public static Language getLanguageBySimbol(String symbol) {

        List<Language> languages = Arrays.stream(Language.values()).toList();

        Optional<Language> languageFinded = languages.stream()
                .filter(l -> l.symbol.equals(symbol.toLowerCase()))
                .findFirst();

        if (languageFinded.isPresent()) {
            return languageFinded.get();
        } else {
            throw new RuntimeException("Linguagem não encontrada no sistema.");
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
