package selection;

import java.util.List;

public interface Selectionneur {
    List<ResultatComparaison> filtrer(List<ResultatComparaison> resultats);
}