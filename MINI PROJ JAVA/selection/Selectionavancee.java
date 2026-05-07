package kyc.selection;
import kyc.model.ResultatComparaison;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionAvancee implements Selectionneur {
    private final double seuil;
    private final String sourcePrioritaire;

    public SelectionAvancee(double seuil, String sourcePrioritaire) {
        this.seuil             = seuil;
        this.sourcePrioritaire = sourcePrioritaire;
    }

    @Override
    public List<ResultatComparaison> filtrer(List<ResultatComparaison> resultats) {
        return resultats.stream()
                .filter(r -> r.score() >= seuil)
                .sorted(Comparator
                        .<ResultatComparaison, Integer>comparing(
                                r -> sourcePrioritaire.equalsIgnoreCase(r.source()) ? 0 : 1)
                        .thenComparingDouble(ResultatComparaison::score).reversed())
                .collect(Collectors.toList());
    }
}
