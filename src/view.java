import javax.swing.*;
import java.awt.*;

public class view extends JFrame {

    private static final String START_TEXT = "Tippe eine Zahl von 1 bis 9";

    public view(){
        super("Zahlen-Spiel v1.0");

    }

    private static JLabel TitleLabel(String text){
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        return label;
    }

    private static JLabel wertLabel(String text){
        JLabel label = new Jlabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSrerif",Font.PLAIN, 18));
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