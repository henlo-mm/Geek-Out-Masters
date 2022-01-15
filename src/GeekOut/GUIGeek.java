package GeekOut;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
public class GUIGeek extends JFrame{
    public static final String MENSAJE_INICIO="PROBANDO";
    private Header headerProject;
    private JButton tirar, salir,ayuda;
    private  JButton[] dados;
    private JButton[] botones;
    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUsados, panelPuntuacion;
    private ImageIcon imageDado, imageDado2, imageDado3,imageDado4, imageDado5, imageDado6, imageDado7, imageDado8, imageDado9, imageDado10, imageDadoInactivo, imageDadoInactivo2, imageDadoInactivo3;
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
        headerProject = new Header("Geek Out", new Color(88, 0, 255));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=3;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

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

        int min_val = 1;
        int max_val = 6;
        Random ran = new Random();

        int uno = ran.nextInt(max_val) + min_val;
        int dos = ran.nextInt(max_val) + min_val;
        int tres = ran.nextInt(max_val) + min_val;
        int cuatro = ran.nextInt(max_val) + min_val;
        int cinco = ran.nextInt(max_val) + min_val;
        int seis = ran.nextInt(max_val) + min_val;
        int siete = ran.nextInt(max_val) + min_val;
        int ocho = ran.nextInt(max_val) + min_val;
        int nueve = ran.nextInt(max_val) + min_val;
        int diez = ran.nextInt(max_val) + min_val;

        //Panel dados Activos
        dados = new JButton[7];

        imageDado = new ImageIcon(getClass().getResource("/resources/"+cuatro+".png"));
        dados[0] = new JButton(imageDado);
        dados[0].setOpaque(true);
        dados[0].setBorder(null);
        dados[0].setContentAreaFilled(false);
        dados[0].setFocusable(true);

        imageDado2 = new ImageIcon(getClass().getResource("/resources/"+cinco+".png"));
        dados[1] = new JButton(imageDado2);
        dados[1].setOpaque(true);
        dados[1].setBorder(null);
        dados[1].setContentAreaFilled(false);
        dados[1].setFocusable(true);

        imageDado3 = new ImageIcon(getClass().getResource("/resources/"+seis+".png"));
        dados[2] = new JButton(imageDado3);
        dados[2].setOpaque(true);
        dados[2].setBorder(null);
        dados[2].setContentAreaFilled(false);
        dados[2].setFocusable(true);

        imageDado4 = new ImageIcon(getClass().getResource("/resources/"+siete+".png"));
        dados[3] = new JButton(imageDado4);
        dados[3].setOpaque(true);
        dados[3].setBorder(null);
        dados[3].setContentAreaFilled(false);
        dados[3].setFocusable(true);

        imageDado5 = new ImageIcon(getClass().getResource("/resources/"+ocho+".png"));
        dados[4] = new JButton(imageDado5);
        dados[4].setOpaque(true);
        dados[4].setBorder(null);
        dados[4].setContentAreaFilled(false);
        dados[4].setFocusable(true);

        imageDado6 = new ImageIcon(getClass().getResource("/resources/"+nueve+".png"));
        dados[5] = new JButton(imageDado3);
        dados[5].setOpaque(true);
        dados[5].setBorder(null);
        dados[5].setContentAreaFilled(false);
        dados[5].setFocusable(true);

        imageDado7 = new ImageIcon(getClass().getResource("/resources/"+diez+".png"));
        dados[6] = new JButton(imageDado7);
        dados[6].setOpaque(true);
        dados[6].setBorder(null);
        dados[6].setContentAreaFilled(false);
        dados[6].setFocusable(true);

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos:"));
        panelDadosActivos.add(dados[0]);
        panelDadosActivos.add(dados[1]);
        panelDadosActivos.add(dados[2]);
        panelDadosActivos.add(dados[3]);
        panelDadosActivos.add(dados[4]);
        panelDadosActivos.add(dados[5]);
        panelDadosActivos.add(dados[6]);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosActivos, constraints);

        //Panel Dados Inactivos



        botones = new JButton[7];

        imageDadoInactivo = new ImageIcon(getClass().getResource("/resources/"+uno+".png"));

        botones[0] = new JButton(imageDadoInactivo);
        botones[0].setOpaque(true);
        botones[0].setBorder(null);
        botones[0].setContentAreaFilled(false);
        botones[0].setFocusable(true);


        imageDadoInactivo2 = new ImageIcon(getClass().getResource("/resources/"+dos+".png"));
        botones[1] = new JButton(imageDadoInactivo2);
        botones[1].setOpaque(true);
        botones[1].setBorder(null);
        botones[1].setContentAreaFilled(false);
        botones[1].setFocusable(true);


        imageDadoInactivo3 = new ImageIcon(getClass().getResource("/resources/"+tres+".png"));
        botones[2] = new JButton(imageDadoInactivo2);
        botones[2].setOpaque(true);
        botones[2].setBorder(null);
        botones[2].setContentAreaFilled(false);
        botones[2].setFocusable(true);



        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos:"));
        panelDadosInactivos.add(botones[0]);
        panelDadosInactivos.add(botones[1]);
        panelDadosInactivos.add(botones[2]);

        //panelDadosInactivos.setBackground();
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;


        add(panelDadosInactivos, constraints);


        //Panel Dados Usados

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

        //Panel Puntuacion

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

                /**int[] caras = modelGeek.getCaras();




                imageDado = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado.setIcon(imageDado);
                imageDado2 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado2.setIcon(imageDado2);
                imageDado3 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado3.setIcon(imageDado3);
                imageDado4 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado4.setIcon(imageDado4);
                imageDado5 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+"png"));
                dado5.setIcon(imageDado5);
                imageDado6 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado6.setIcon(imageDado6);
                imageDado7 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado7.setIcon(imageDado7);
                imageDado8 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado8.setIcon(imageDado8);
                imageDado9 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado8.setIcon(imageDado9);
                imageDado10 = new ImageIcon(getClass().getResource("/resources/"+caras[1]+".png"));
                dado10.setIcon(imageDado10);
    */
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
