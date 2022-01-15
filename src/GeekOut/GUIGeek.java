package GeekOut;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIGeek extends JFrame{
    public static final String MENSAJE_INICIO="PROBANDO";
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
        setUndecorated(true);
        //this.setSize(1000, 400);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelGeek = new ModelGeek();
        headerProject = new Header("Geek Out", Color.BLUE);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=3;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

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
         activos = new ImageIcon(getClass().getResource("/resources/dados_inactivo2s.png"));
         dados_activos = new JLabel(activos);
         */

        //Boton ayuda
        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        //Boton Tirar
        tirar = new JButton(" Tirar ");
        tirar.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(tirar,constraints);

        //Boton Salir
        salir = new JButton(" Salir ");
        salir.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salir,constraints);

        //Panel dados Activos
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos:"));
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosActivos, constraints);
        //panelDadosActivos.add(dados_activos);


        /*inactivos = new ImageIcon(getClass().getResource("/resources/dados_inactivo2s.png"));
        dados_inactivos = new JLabel(inactivos);*/

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos:"));
        //panelDadosInactivos.add(dados_inactivos);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosInactivos, constraints);
        // panelDadosInactivos.add();


        /*usados = new ImageIcon(getClass().getResource("/resources/dados_utilizados.png"));
        dados_usados = new JLabel(usados);*/

        panelDadosUsados = new JPanel();
        panelDadosUsados.setPreferredSize(new Dimension(450, 250));
        panelDadosUsados.setBorder(BorderFactory.createTitledBorder("Dados Usados"));
        //panelDadosUsados.add(dados_usados);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosUsados, constraints);
        // panelDadosUsados.add();


        /*tarjeton = new ImageIcon(getClass().getResource("/resources/Tarjeton-puntajes.png"));
        tarjeton_puntaje = new JLabel(tarjeton);*/

        panelPuntuacion = new JPanel();
        panelPuntuacion.setPreferredSize(new Dimension(450, 250));
        panelPuntuacion.setBorder(BorderFactory.createTitledBorder("Puntaje"));
        //panelPuntuacion.add(tarjeton_puntaje);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelPuntuacion, constraints);
        //panelPuntuacion.add();

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
            if (e.getSource() == tirar) {
                System.out.println("todo salio good");

            }
            else {
                if (e.getSource() == ayuda){
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                }else{
                    System.exit(0);
                }
            }
        }
    }
}
