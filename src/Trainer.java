public class Trainer {
    private String name;
    private String lizenzLevel;
    private int erfahrung;

    // Konstruktor
    public Trainer(String name, String lizenzLevel, int erfahrung) {
        this.name = name;
        this.lizenzLevel = lizenzLevel;
        this.erfahrung = erfahrung;
    }

    // Getter und Setter für die Attribute des Trainers
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLizenzLevel() {
        return lizenzLevel;
    }

    public void setLizenzLevel(String lizenzLevel) {
        this.lizenzLevel = lizenzLevel;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }
}
