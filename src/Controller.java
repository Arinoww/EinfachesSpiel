public class Controller {
    private final GewinnModel model;
    private final view gui;

    public Controller(GewinnModel model, view gui) {
        this.model = model;
        this.gui = gui;
        gui.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
        gui.addSZahlListener(e -> rundeSpielen());
    }

    private void rundeSpielen() {
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
        gui.setRundenErgebnis(String.format("%+d", model.getRundenErgebnis()));
        gui.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));
    }

    public static void main(String[] args) {
        new Controller(new GewinnModel(), new view());
    }
}
