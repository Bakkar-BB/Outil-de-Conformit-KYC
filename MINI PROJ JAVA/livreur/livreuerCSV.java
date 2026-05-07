package kyc.livraison;

import kyc.model.Nom;
import kyc.model.ResultatComparaison;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LivreurCSV implements Livreur {

    private final String cheminFichier;

    public LivreurCSV(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    @Override
    public void livrer(List<ResultatComparaison> resultats) {
        livrerAvecDetails(null, resultats);
    }

    @Override
    public void livrerAvecDetails(Nom nomClient, List<ResultatComparaison> resultats) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(cheminFichier)))) {
            pw.println("idEntreeListe,nomClient,idNomClient,nomTrouve,score,source");
            for (ResultatComparaison r : resultats) {
                String nomBrut = nomClient != null ? nomClient.getNomBrut()  : r.nomClient().getNomBrut();
                String idNom   = nomClient != null ? nomClient.getIdNom()    : r.nomClient().getIdNom();
                pw.printf("%s,\"%s\",%s,\"%s\",%.4f,%s%n",
                        r.idEntreeListe(), nomBrut, idNom,
                        r.nomTrouve(), r.score(), r.source());
            }
            System.out.println("[LivreurCSV] Fichier écrit : " + cheminFichier);
        } catch (IOException e) {
            System.err.println("[LivreurCSV] Erreur écriture : " + e.getMessage());
        }
    }
}
