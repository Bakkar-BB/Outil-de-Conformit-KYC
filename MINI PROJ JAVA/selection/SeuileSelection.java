package selection;

import java.util.List;
import java.util.stream.Collectors;

class ResultatComparaison {
    private String nom;
    private double score;
    private String source;

    public ResultatComparaison(String nom, double score, String source) {
        this.nom = nom;
        this.score = score;
        this.source = source;
    }

    public String getNom() { return nom; }
    public double getScore() { return score; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return nom + " | score=" + score + " | source=" + source;
    }
}



public class SeuileSelection implements Selectionneur {

    private double seuil;

    public SeuileSelection(double seuil) {
        this.seuil = seuil;
    }

    @Override
    public List<ResultatComparaison> filtrer(List<ResultatComparaison> resultats) {
        return resultats.stream()
                .filter(r -> r.getScore() >= seuil)
                .collect(Collectors.toList());
    }
}