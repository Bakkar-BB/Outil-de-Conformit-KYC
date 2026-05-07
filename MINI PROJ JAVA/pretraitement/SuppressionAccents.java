package pretraitement;

import model.Nom;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SuppressionAccents implements Pretraitement {

    private static final Pattern ACCENTS =
            Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    @Override
    public List<String> traiter(Nom nom) {
        List<String> tokens = nom.getNomPretraite().isEmpty()
                ? Arrays.asList(nom.getNomBrut().trim().split("\\s+"))
                : nom.getNomPretraite();

        return tokens.stream()
                .map(t -> Normalizer.normalize(t, Normalizer.Form.NFD))
                .map(t -> ACCENTS.matcher(t).replaceAll(""))
                .filter(t -> !t.isBlank())
                .toList();
    }
}