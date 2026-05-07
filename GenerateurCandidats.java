package comparateur;

import java.util.ArrayList;
import java.util.List;

public class GenerateurCandidats {

    private List<List<String>> candidats;

    public GenerateurCandidats() {
        this.candidats = new ArrayList<>();
    }

    public void ajouterCandidat(List<String> tokens) {
        candidats.add(tokens);
    }

    public List<List<String>> generer() {
        return candidats;
    }

    public static GenerateurCandidats depuisNoms(List<String> nomsComplets) {
        GenerateurCandidats generateur = new GenerateurCandidats();
        for (String nom : nomsComplets) {
            List<String> tokens = List.of(nom.split(" "));
            generateur.ajouterCandidat(tokens);
        }
        return generateur;
    }
}