package Pretraitement;

public final class PretraitementFactory {

    private PretraitementFactory() {}

    public static Pretraitement nettoyeur() {
        return new Nettoyeur();
    }

    public static Pretraitement normalisation() {
        return new Normalisation();
    }

    public static Pretraitement suppressionAccents() {
        return new SuppressionAccents();
    }

    public static Pretraitement decomposeur() {
        return new Decomposeur();
    }
}
