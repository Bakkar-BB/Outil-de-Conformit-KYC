package livraison;

import java.util.List;

public interface Livreur {
    void livrer(List<ResultatComparaison> resultats);
    void livrerAvecDetails(Nom nom, List<ResultatComparaison> resultats);
}