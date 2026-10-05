public class Controller {
        private final GewinnModel model;
        private final view gui;

        public Controller(GewinnModel model, view gui) {
            this.model = model;
            this.gui = gui;
            gui.setGesamtPunkte("Gesamtpunkte: " + model.getGesamtPunkte());
        }

        public static void main(String[] args) {
            new Controller(new GewinnModel(), new view());
        }
}
