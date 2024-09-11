import java.util.ArrayList;
import java.util.List;

public class Mannschaft {
    private String name;
    private String liga;
    private Trainer trainer;
    private List<Spieler> spielerListe;

    // Konstruktor
    public Mannschaft(String name, String liga, Trainer trainer) {
        this.name = name;
        this.liga = liga;
        this.trainer = trainer;
        this.spielerListe = new ArrayList<>();
    }

    // Methode zum Hinzufügen eines Spielers
    public void addSpieler(Spieler spieler) {
        spielerListe.add(spieler);
    }

    // Methode zum Entfernen eines Spielers
    public void removeSpieler(Spieler spieler) {
        spielerListe.remove(spieler);
    }

    // Methode, um die Liste der Spieler zurückzugeben
    public List<Spieler> getSpielerListe() {
        return spielerListe;
    }

    // Getter und Setter für die Attribute der Mannschaft
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
