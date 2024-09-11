import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Vereinsverwaltung {
    private static Verein verein = new Verein("Beispiel Verein", "Musterstraße 1, 12345 Musterstadt", 1920);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Vereinsverwaltung ---");
                System.out.println("1. Verein verwalten");
                System.out.println("2. Mannschaft verwalten");
                System.out.println("3. Programm beenden");
                System.out.print("Bitte wählen Sie eine Option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Eingabepuffer leeren

                switch (choice) {
                    case 1:
                        verwalteVerein();
                        break;
                    case 2:
                        verwalteMannschaft();
                        break;
                    case 3:
                        System.out.println("Programm beendet.");
                        return;
                    default:
                        System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine(); // Eingabepuffer leeren
            }
        }
    }

    private static void verwalteVerein() {
        while (true) {
            try {
                System.out.println("\n--- Verein verwalten ---");
                System.out.println("1. Vereinsname anzeigen/ändern");
                System.out.println("2. Adresse anzeigen/ändern");
                System.out.println("3. Gründungsjahr anzeigen/ändern");
                System.out.println("4. Mannschaften anzeigen");
                System.out.println("5. Mannschaft hinzufügen");
                System.out.println("6. Mannschaft entfernen");
                System.out.println("7. Zurück zum Hauptmenü");
                System.out.print("Bitte wählen Sie eine Option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Eingabepuffer leeren

                switch (choice) {
                    case 1:
                        verwalteVereinsname();
                        break;
                    case 2:
                        verwalteAdresse();
                        break;
                    case 3:
                        verwalteGruendungsjahr();
                        break;
                    case 4:
                        zeigeMannschaften();
                        break;
                    case 5:
                        fuegeMannschaftHinzu();
                        break;
                    case 6:
                        entferneMannschaft();
                        break;
                    case 7:
                        return; // Zurück zum Hauptmenü
                    default:
                        System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine(); // Eingabepuffer leeren
            }
        }
    }

    private static void verwalteVereinsname() {
        System.out.println("Aktueller Vereinsname: " + verein.getName());
        System.out.print("Neuen Vereinsnamen eingeben (oder leer lassen, um nicht zu ändern): ");
        String neuerName = scanner.nextLine().trim();
        if (!neuerName.isEmpty()) {
            verein.setName(neuerName);
            System.out.println("Vereinsname aktualisiert: " + verein.getName());
        } else {
            System.out.println("Vereinsname unverändert.");
        }
    }

    private static void verwalteAdresse() {
        System.out.println("Aktuelle Adresse: " + verein.getAdresse());
        System.out.print("Neue Adresse eingeben (oder leer lassen, um nicht zu ändern): ");
        String neueAdresse = scanner.nextLine().trim();
        if (!neueAdresse.isEmpty()) {
            verein.setAdresse(neueAdresse);
            System.out.println("Adresse aktualisiert: " + verein.getAdresse());
        } else {
            System.out.println("Adresse unverändert.");
        }
    }

    private static void verwalteGruendungsjahr() {
        System.out.println("Aktuelles Gründungsjahr: " + verein.getGruendungsjahr());
        System.out.print("Neues Gründungsjahr eingeben (oder 0, um nicht zu ändern): ");
        try {
            int neuesJahr = scanner.nextInt();
            scanner.nextLine(); // Eingabepuffer leeren
            if (neuesJahr > 0) {
                verein.setGruendungsjahr(neuesJahr);
                System.out.println("Gründungsjahr aktualisiert: " + verein.getGruendungsjahr());
            } else {
                System.out.println("Gründungsjahr unverändert.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
            scanner.nextLine(); // Eingabepuffer leeren
        }
    }

    private static void zeigeMannschaften() {
        List<Mannschaft> mannschaften = verein.getMannschaften();
        if (mannschaften.isEmpty()) {
            System.out.println("Es sind keine Mannschaften vorhanden.");
        } else {
            System.out.println("--- Mannschaften im Verein ---");
            for (Mannschaft mannschaft : mannschaften) {
                System.out.println("Name: " + mannschaft.getName() + ", Liga: " + mannschaft.getLiga() + ", Trainer: " + mannschaft.getTrainer().getName());
            }
        }
    }

    private static void fuegeMannschaftHinzu() {
        System.out.print("Name der neuen Mannschaft: ");
        String name = scanner.nextLine().trim();
        System.out.print("Liga der neuen Mannschaft: ");
        String liga = scanner.nextLine().trim();
        System.out.print("Name des Trainers: ");
        String trainerName = scanner.nextLine().trim();
        System.out.print("LizenzLevel des Trainers: ");
        String lizenzLevel = scanner.nextLine().trim();
        System.out.print("Erfahrung des Trainers in Jahren: ");
        try {
            int erfahrung = scanner.nextInt();
            scanner.nextLine(); // Eingabepuffer leeren

            Trainer trainer = new Trainer(trainerName, lizenzLevel, erfahrung);
            Mannschaft neueMannschaft = new Mannschaft(name, liga, trainer);
            verein.addMannschaft(neueMannschaft);
            System.out.println("Mannschaft erfolgreich hinzugefügt.");
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl für die Erfahrung ein.");
            scanner.nextLine(); // Eingabepuffer leeren
        }
    }

    private static void entferneMannschaft() {
        zeigeMannschaften();
        System.out.print("Name der zu entfernenden Mannschaft: ");
        String name = scanner.nextLine().trim();
        Mannschaft zuEntfernen = null;
        for (Mannschaft mannschaft : verein.getMannschaften()) {
            if (mannschaft.getName().equalsIgnoreCase(name)) {
                zuEntfernen = mannschaft;
                break;
            }
        }
        if (zuEntfernen != null) {
            verein.removeMannschaft(zuEntfernen);
            System.out.println("Mannschaft erfolgreich entfernt.");
        } else {
            System.out.println("Keine Mannschaft mit diesem Namen gefunden.");
        }
    }

    private static void verwalteMannschaft() {
        if (verein.getMannschaften().isEmpty()) {
            System.out.println("Es sind keine Mannschaften im Verein vorhanden.");
            return;
        }

        System.out.print("Name der Mannschaft, die verwaltet werden soll: ");
        String name = scanner.nextLine().trim();
        Mannschaft gewaehlteMannschaft = null;
        for (Mannschaft mannschaft : verein.getMannschaften()) {
            if (mannschaft.getName().equalsIgnoreCase(name)) {
                gewaehlteMannschaft = mannschaft;
                break;
            }
        }

        if (gewaehlteMannschaft != null) {
            verwalteSpielerUndTrainer(gewaehlteMannschaft);
        } else {
            System.out.println("Keine Mannschaft mit diesem Namen gefunden.");
        }
    }

    private static void verwalteSpielerUndTrainer(Mannschaft mannschaft) {
        while (true) {
            try {
                System.out.println("\n--- Mannschaft verwalten ---");
                System.out.println("1. Spieler hinzufügen");
                System.out.println("2. Spieler entfernen");
                System.out.println("3. Spieler anzeigen");
                System.out.println("4. Trainer anzeigen/ändern");
                System.out.println("5. Zurück zum Hauptmenü");
                System.out.print("Bitte wählen Sie eine Option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Eingabepuffer leeren

                switch (choice) {
                    case 1:
                        fuegeSpielerHinzu(mannschaft);
                        break;
                    case 2:
                        entferneSpieler(mannschaft);
                        break;
                    case 3:
                        zeigeSpieler(mannschaft);
                        break;
                    case 4:
                        verwalteTrainer(mannschaft);
                        break;
                    case 5:
                        return; // Zurück zum Hauptmenü
                    default:
                        System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine(); // Eingabepuffer leeren
            }
        }
    }

    private static void fuegeSpielerHinzu(Mannschaft mannschaft) {
        System.out.print("Name des neuen Spielers: ");
        String name = scanner.nextLine().trim();
        System.out.print("Geburtsdatum (YYYY-MM-DD): ");
        String geburtsdatum = scanner.nextLine().trim();
        System.out.print("Position: ");
        String position = scanner.nextLine().trim();
        System.out.print("Rückennummer: ");
        try {
            int rueckennummer = scanner.nextInt();
            scanner.nextLine(); // Eingabepuffer leeren

            Spieler spieler = new Spieler(name, geburtsdatum, position, rueckennummer);
            mannschaft.addSpieler(spieler);
            System.out.println("Spieler erfolgreich hinzugefügt.");
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl für die Rückennummer ein.");
            scanner.nextLine(); // Eingabepuffer leeren
        }
    }

    private static void entferneSpieler(Mannschaft mannschaft) {
        zeigeSpieler(mannschaft);
        System.out.print("Name des zu entfernenden Spielers: ");
        String name = scanner.nextLine().trim();
        Spieler zuEntfernen = null;
        for (Spieler spieler : mannschaft.getSpielerListe()) {
            if (spieler.getName().equalsIgnoreCase(name)) {
                zuEntfernen = spieler;
                break;
            }
        }
        if (zuEntfernen != null) {
            mannschaft.removeSpieler(zuEntfernen);
            System.out.println("Spieler erfolgreich entfernt.");
        } else {
            System.out.println("Kein Spieler mit diesem Namen gefunden.");
        }
    }

    private static void zeigeSpieler(Mannschaft mannschaft) {
        List<Spieler> spielerListe = mannschaft.getSpielerListe();
        if (spielerListe.isEmpty()) {
            System.out.println("Es sind keine Spieler in dieser Mannschaft vorhanden.");
        } else {
            System.out.println("--- Spieler in der Mannschaft " + mannschaft.getName() + " ---");
            for (Spieler spieler : spielerListe) {
                System.out.println("Name: " + spieler.getName() + ", Position: " + spieler.getPosition() + ", Rückennummer: " + spieler.getRueckennummer());
            }
        }
    }

    private static void verwalteTrainer(Mannschaft mannschaft) {
        Trainer trainer = mannschaft.getTrainer();
        System.out.println("Aktueller Trainer: " + trainer.getName());
        System.out.print("Neuen Trainername eingeben (oder leer lassen, um nicht zu ändern): ");
        String neuerName = scanner.nextLine().trim();
        if (!neuerName.isEmpty()) {
            trainer.setName(neuerName);
        }
        System.out.print("Neues LizenzLevel eingeben (oder leer lassen, um nicht zu ändern): ");
        String neuesLizenzLevel = scanner.nextLine().trim();
        if (!neuesLizenzLevel.isEmpty()) {
            trainer.setLizenzLevel(neuesLizenzLevel);
        }
        System.out.print("Neue Erfahrung in Jahren eingeben (oder 0, um nicht zu ändern): ");
        try {
            int neueErfahrung = scanner.nextInt();
            scanner.nextLine(); // Eingabepuffer leeren
            if (neueErfahrung > 0) {
                trainer.setErfahrung(neueErfahrung);
            }
            System.out.println("Trainer aktualisiert.");
        } catch (InputMismatchException e) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl für die Erfahrung ein.");
            scanner.nextLine(); // Eingabepuffer leeren
        }
    }
}
