import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int berechneComputerZahl(){
        Random random = new Random();
        return random.nextInt(9) +1;
    }
    public void berechneRunde(int spielerZ){
        computerZahl = berechneComputerZahl();
        if(computerZahl == spielerZ){
            rundenErgebnis = 20;
        } else if (spielerZ + 1 == computerZahl || spielerZ - 1 == computerZahl) {
            rundenErgebnis = 5;
        }
        else{
            rundenErgebnis = -10;
        }
        spielerZahl = spielerZ;
        gesamtPunkte += rundenErgebnis;
    }


    public boolean hatGewonnen(){
        if (gesamtPunkte >= 100) return true;
        return false;
    }
    public boolean hatVerloren(){
        if (gesamtPunkte <= 0) return true;
        return false;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public void setGesamtPunkte(int gesamtPunkte) {
        this.gesamtPunkte = gesamtPunkte;
    }

    public int getSpielerZahl() {
        return spielerZahl;
    }

    public void setSpielerZahl(int spielerZahl) {
        this.spielerZahl = spielerZahl;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public void setComputerZahl(int computerZahl) {
        this.computerZahl = computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void setRundenErgebnis(int rundenErgebnis) {
        this.rundenErgebnis = rundenErgebnis;
    }


}
