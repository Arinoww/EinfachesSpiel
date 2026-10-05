import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class view extends JFrame {

    private static final String strtTxt = "Tippe eine Zahl von 1 bis 9";

    private final JLabel rndErg = TitleLabel("Rundenergebnis:");
    private final JLabel gsmtErg = TitleLabel("GesamtPunkte:");
    private final JLabel zahlLabel = TitleLabel("Deine Zahl:");
    private final JLabel compLabel = TitleLabel("Computer:");
    private final JLabel lbRundenPunkte = wertLabel(strtTxt);
    private final JLabel lbgesamtPunkte = wertLabel("");
    private final JTextField txtSpieler = zahlenf(true);
    private final JTextField txtcomp = zahlenf(false);
    private final JButton btnagain = new JButton("noch einmal");

    public view(){
        super("Zahlen-Spiel v1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel oben = new JPanel(new GridLayout(3, 2, 5, 5));
        oben.add(rndErg);
        oben.add(gsmtErg);
        oben.add(lbRundenPunkte);
        oben.add(lbgesamtPunkte);
        oben.add(zahlLabel);
        oben.add(compLabel);


        JPanel mitte = new JPanel(new GridLayout(1, 2, 15, 0));
        mitte.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        mitte.add(txtSpieler);
        mitte.add(txtcomp);

        JPanel unten = new JPanel();
        btnagain.setFont(new Font("SansSerif", Font.PLAIN, 18));
        unten.add(btnagain);

        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);

        setSize(640, 380);

        setVisible(true);
    }
    public String getSpielerEingabe() {
        return txtSpieler.getText().trim();
    }

    public void setRundenErgebnis(String text) {
        lbRundenPunkte.setText(text);
    }

    public void setGesamtPunkte(String text) {
        lbgesamtPunkte.setText(text);
    }

    public void setComputerZahl(String text) {
        txtcomp.setText(text);
    }

    public void setEingabeAktiv(boolean aktiv) {
        txtSpieler.setEditable(aktiv);
    }

    public void zeigeFehler(String meldung) {
        JOptionPane.showMessageDialog(this, meldung,
                "Ungültige Eingabe", JOptionPane.WARNING_MESSAGE);
    }

    public void neueRunde() {
        txtSpieler.setText("");
        txtcomp.setText("");
        lbRundenPunkte.setText(strtTxt);
        txtSpieler.setEditable(true);
        txtSpieler.requestFocusInWindow();
    }

    public void addSZahlListener(ActionListener listener) {
        txtSpieler.addActionListener(listener);
    }

    public void addNEListener(ActionListener listener) {
        btnagain.addActionListener(listener);
    }

    private static JLabel TitleLabel(String text){
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        return label;
    }

    private static JLabel wertLabel(String text){
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSrerif",Font.PLAIN, 22));
        label.setBackground(Color.WHITE);
        return label;
    }

    private static JTextField zahlenf(boolean edt){
        JTextField field = new JTextField();
        field.setFont(new Font("sansSerif", Font.BOLD,36));
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setEditable(edt);
        field.setBackground(Color.WHITE);
        if (!edt) {
            field.setBorder(BorderFactory.createEmptyBorder());
            field.setFocusable(false);
        }
        return field;
    }

}