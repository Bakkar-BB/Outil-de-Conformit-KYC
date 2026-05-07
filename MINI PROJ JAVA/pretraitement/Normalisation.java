package pretraitement;

import model.Nom;
import java.util.Arrays;
import java.util.List;

public class Normalisation implements Pretraitement {

    @Override
    public List<String> traiter(Nom nom) {
        List<String> tokens = nom.getNomPretraite().isEmpty()
                ? Arrays.asList(nom.getNomBrut().trim().split("\\s+"))
                : nom.getNomPretraite();

        return tokens.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(t -> !t.isBlank())
                .toList();
    }
}