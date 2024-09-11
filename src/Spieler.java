public class Spieler {
    private String name;
    private String geburtsdatum;
    private String position;
    private int rueckennummer;

    // Konstruktor
    public Spieler(String name, String geburtsdatum, String position, int rueckennummer) {
        this.name = name;
        this.geburtsdatum = geburtsdatum;
        this.position = position;
        this.rueckennummer = rueckennummer;
    }

    // Getter und Setter für die Attribute des Spielers
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRueckennummer() {
        return rueckennummer;
    }

    public void setRueckennummer(int rueckennummer) {
        this.rueckennummer = rueckennummer;
    }
}
