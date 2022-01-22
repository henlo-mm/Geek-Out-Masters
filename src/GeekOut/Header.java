package GeekOut;

import javax.swing.*;
import java.awt.*;
//provee el estilo al titulo del juego
public class Header extends JLabel{
    public Header(String title, Color colorBackground) {
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(255, 255, 255));
        this.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
    }
}
