import java.awt.Color;
public class Controller {
    private final GewinnModel model;
    private final view gui;


    public Controller(GewinnModel model, view gui) {
        this.model = model;
        this.gui = gui;
        gui.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
        gui.addSZahlListener(e -> rundeSpielen());
        gui.addNEListener(e -> neueRunde());
    }

    private void rundeSpielen() {
        if (spielVorbei()) {
            return;
        }
        String eingabe = gui.getSpielerEingabe();
        if (!istGueltig(eingabe)) {
            gui.zeigeFehler("Bitte eine ganze Zahl von 1 bis 9 eingeben.");
            return;
        }
        model.berechneRunde(Integer.parseInt(eingabe));
        aktualisiereAnzeige();
    }

    private boolean istGueltig(String eingabe) {
        return eingabe != null && eingabe.matches("[1-9]");
    }

    private void aktualisiereAnzeige() {
        gui.setComputerZahl(String.valueOf(model.getComputerZahl()));
        gui.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));
        if (model.hatGewonnen()) {
            gui.setRundenErgebnis("Gewonnen");
        } else if (model.hatVerloren()) {
            gui.setRundenErgebnis("Verloren");
        } else {
            gui.setRundenErgebnis(String.format("%+d", model.getRundenErgebnis()));
        }
        gui.setEingabeAktiv(false);
        gui.setButtonAktiv(!spielVorbei());
        gui.setErgebnisFarbe(model.getRundenErgebnis() > 0 ? Color.GREEN : Color.RED);
    }

    private boolean spielVorbei() {
        return model.hatGewonnen() || model.hatVerloren();
    }
    private void neueRunde() {
        if (spielVorbei()) {
            return;
        }
        gui.setEingabeAktiv(true);
        gui.setButtonAktiv(false);
        gui.neueRunde();
    }

    public static void main(String[] args) {
        new Controller(new GewinnModel(), new view());
    }
}
