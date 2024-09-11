import java.util.ArrayList;
import java.util.List;

public class Verein {
    private String name;
    private String adresse;
    private int gruendungsjahr;
    private List<Mannschaft> mannschaften;

    // Konstruktor
    public Verein(String name, String adresse, int gruendungsjahr) {
        this.name = name;
        this.adresse = adresse;
        this.gruendungsjahr = gruendungsjahr;
        this.mannschaften = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Mannschaft
    public void addMannschaft(Mannschaft mannschaft) {
        mannschaften.add(mannschaft);
    }

    // Methode zum Entfernen einer Mannschaft
    public void removeMannschaft(Mannschaft mannschaft) {
        mannschaften.remove(mannschaft);
    }

    // Methode, um die Liste der Mannschaften zurückzugeben
    public List<Mannschaft> getMannschaften() {
        return mannschaften;
    }

    // Getter und Setter für die Attribute des Vereins
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getGruendungsjahr() {
        return gruendungsjahr;
    }

    public void setGruendungsjahr(int gruendungsjahr) {
        this.gruendungsjahr = gruendungsjahr;
    }
}
