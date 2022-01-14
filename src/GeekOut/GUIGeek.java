package GeekOut;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIGeek extends JFrame{
    private Header headerProject;
    private JLabel dragon_lab, nave_lab,meple_lab, puntos_lab, heroe_lab, corazon_lab, dados_activos, dados_inactivos, dados_usados, tarjeton_puntaje;
    private JButton tirar, salir,ayuda,dragon,nave, meple, puntos, heroe, corazon;
    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUsados, panelPuntuacion;
    private ImageIcon imageDragon, imageHeroe,imageCorazon, imageMeple, imageNave, imagePunto, activos, inactivos, usados, tarjeton;
    private GUIGeek.Escucha escucha;
    private JSeparator separator;
    private ModelGeek modelGeek;

    public GUIGeek() {
        this.initGUI();
        this.setTitle("GeekOutMasters");
        this.setSize(1000, 400);
        this.setLocationRelativeTo((Component)null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());

        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelGeek = new ModelGeek();

       /** imageDragon = new ImageIcon(getClass().getResource("/resources/Dragon.png"));
        imageHeroe = new ImageIcon(getClass().getResource("/resources/Superheroe.png"));
        imageCorazon = new ImageIcon(getClass().getResource("/resources/Corazon.png"));
        imageMeple = new ImageIcon(getClass().getResource("/resources/Meple.png"));
        imageNave = new ImageIcon(getClass().getResource("/resources/Cohete.png"));
        imagePunto = new ImageIcon(getClass().getResource("/resources/42.png"));



        dragon_lab = new JLabel(imageDragon);
        nave_lab = new JLabel(imageNave);
        meple_lab = new JLabel(imageMeple);
        puntos_lab = new JLabel(imagePunto);
        heroe_lab = new JLabel(imageHeroe);
        corazon_lab = new JLabel(imageCorazon);
        */


        activos = new ImageIcon(getClass().getResource("/resources/dados_inactivo2s.png"));



        dados_activos = new JLabel(activos);

        //Set up JComponents
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Tus dados:"));
        panelDadosActivos.add(dados_activos);

      //  panelDadosACtivos.add();
        add(panelDadosActivos);

        inactivos = new ImageIcon(getClass().getResource("/resources/dados_inactivo2s.png"));



        dados_inactivos = new JLabel(inactivos);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Tus dados:"));
        panelDadosInactivos.add(dados_inactivos);
       // panelDadosInactivos.add();
        add(panelDadosInactivos);

        usados = new ImageIcon(getClass().getResource("/resources/dados_utilizados.png"));



        dados_usados = new JLabel(usados);

        panelDadosUsados = new JPanel();
        panelDadosUsados.setPreferredSize(new Dimension(450, 250));
        panelDadosUsados.setBorder(BorderFactory.createTitledBorder("Tus dados:"));
        panelDadosUsados.add(dados_usados);
       // panelDadosUsados.add();
        add(panelDadosUsados);

        tarjeton = new ImageIcon(getClass().getResource("/resources/Tarjeton-puntajes.png"));



        tarjeton_puntaje = new JLabel(tarjeton);

        panelPuntuacion = new JPanel();
        panelPuntuacion.setPreferredSize(new Dimension(450, 250));
        panelPuntuacion.setBorder(BorderFactory.createTitledBorder("Tus dados:"));
        panelPuntuacion.add(tarjeton_puntaje);
       //panelPuntuacion.add();
        add(panelPuntuacion);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIGeek miProjectGUI =  new GUIGeek();
        });
    }

    private class Escucha implements ActionListener {
        private Escucha() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() != GUIGeek.this.tirar && e.getSource() != GUIGeek.this.ayuda) {
                System.exit(0);
            }

        }
    }
}
