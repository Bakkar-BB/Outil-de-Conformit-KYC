package Pretraitement;
import model.Nom;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class Normalisation implements Pretraitement{
    @Override
    public List<String> traiter(Nom nom) {
        List<String> tokens = nom.getNomPretraite().isEmpty()
                ? Arrays.asList(nom.getNomBrut().trim().split("\\s+"))
                : nom.getNomPretraite();

        return tokens.stream()
                .map(String::toUpperCase)
                .map(String::trim)
                .filter(t -> !t.isBlank())
                .toList();
    }
}
