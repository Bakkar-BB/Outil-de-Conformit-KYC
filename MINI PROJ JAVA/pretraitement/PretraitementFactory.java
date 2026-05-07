package pretraitement;

public final class PretraitementFactory {

    private PretraitementFactory() {}

    public static Pretraitement getNettoyeur() {
        return new Nettoyeur();
    }

    public static Pretraitement getNormalisation() {
        return new Normalisation();
    }

    public static Pretraitement getSuppressionAccents() {
        return new SuppressionAccents();
    }

    public static Pretraitement getDecomposeur() {
        return new Decomposeur();
    }
}



