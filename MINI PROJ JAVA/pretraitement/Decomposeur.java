package pretraitement;

import model.Nom;
import java.util.Arrays;
import java.util.List;

public class Nettoyeur implements Pretraitement {

    @Override
    public List<String> traiter(Nom nom) {
        String texte = nom.getNomBrut()
                .replaceAll("[^\\p{L}\\s]", "")
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();

        return decouper(texte);
    }

    private List<String> decouper(String texte) {
        return texte.isBlank() ? List.of() : Arrays.asList(texte.split("\\s+"));
    }
}



