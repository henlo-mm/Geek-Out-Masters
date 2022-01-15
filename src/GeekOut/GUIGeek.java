package GeekOut;

import java.awt.*;
import java.util.*;
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
    private ImageIcon imageDado, imageDado2, imageDado3,imageDado4, imageDado5, imageDado6;
    private GUIGeek.Escucha escucha;
    ArrayList<ImageIcon> imagenes;
    private JSeparator separator;
    private ModelGeek modelGeek;
    int uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;


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

        //Generación de números random entre 0 y 6 para listar las imágenes

        Random ran = new Random();

        uno = ran.nextInt(5) + 1;
        dos = ran.nextInt(5) + 1;
        tres = ran.nextInt(5) + 1;
        cuatro = ran.nextInt(5) + 1;
        cinco = ran.nextInt(5) + 1;
        seis = ran.nextInt(5) + 1;
        siete = ran.nextInt(5) + 1;
        ocho = ran.nextInt(5) + 1;
        nueve = ran.nextInt(5) + 1;
        diez = ran.nextInt(5) + 1;

        //Arralist de imagenes
        imagenes = new ArrayList<ImageIcon>();

        //Imagenes
        imageDado = new ImageIcon(getClass().getResource("/resources/0.png"));
        imageDado2 = new ImageIcon(getClass().getResource("/resources/1.png"));
        imageDado3 = new ImageIcon(getClass().getResource("/resources/2.png"));
        imageDado4 = new ImageIcon(getClass().getResource("/resources/3.png"));
        imageDado5 = new ImageIcon(getClass().getResource("/resources/4.png"));
        imageDado6 = new ImageIcon(getClass().getResource("/resources/5.png"));

        //Añade las imágenes al array
        imagenes.add(imageDado);
        imagenes.add(imageDado2);
        imagenes.add(imageDado3);
        imagenes.add(imageDado4);
        imagenes.add(imageDado5);
        imagenes.add(imageDado6);

        //Array de Dados Activos

        dados = new JButton[7];

        dados[0] = new JButton(imagenes.get(cuatro));
        dados[0].setOpaque(true);
        dados[0].setBorder(null);
        dados[0].setContentAreaFilled(false);
        dados[0].setFocusable(true);

        dados[1] = new JButton(imagenes.get(cinco));
        dados[1].setOpaque(true);
        dados[1].setBorder(null);
        dados[1].setContentAreaFilled(false);
        dados[1].setFocusable(true);

        dados[2] = new JButton(imagenes.get(seis));
        dados[2].setOpaque(true);
        dados[2].setBorder(null);
        dados[2].setContentAreaFilled(false);
        dados[2].setFocusable(true);

        dados[3] = new JButton(imagenes.get(siete));
        dados[3].setOpaque(true);
        dados[3].setBorder(null);
        dados[3].setContentAreaFilled(false);
        dados[3].setFocusable(true);

        dados[4] = new JButton(imagenes.get(ocho));
        dados[4].setOpaque(true);
        dados[4].setBorder(null);
        dados[4].setContentAreaFilled(false);
        dados[4].setFocusable(true);

        dados[5] = new JButton(imagenes.get(nueve));
        dados[5].setOpaque(true);
        dados[5].setBorder(null);
        dados[5].setContentAreaFilled(false);
        dados[5].setFocusable(true);

        dados[6] = new JButton(imagenes.get(diez));
        dados[6].setOpaque(true);
        dados[6].setBorder(null);
        dados[6].setContentAreaFilled(false);
        dados[6].setFocusable(true);

        //Panel Dados Activos

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

        //Array de botones de Dados Inactivos

        botones = new JButton[3];

        botones[0] = new JButton(imagenes.get(uno));
        botones[0].setOpaque(true);
        botones[0].setBorder(null);
        botones[0].setContentAreaFilled(false);
        botones[0].setFocusable(true);

        botones[1] = new JButton(imagenes.get(dos));
        botones[1].setOpaque(true);
        botones[1].setBorder(null);
        botones[1].setContentAreaFilled(false);
        botones[1].setFocusable(true);

        botones[2] = new JButton(imagenes.get(tres));
        botones[2].setOpaque(true);
        botones[2].setBorder(null);
        botones[2].setContentAreaFilled(false);
        botones[2].setFocusable(true);

        //Panel Dados Inactivos

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
            if(uno == 0){
                System.out.println("todo salio good");

            }else if(uno == 1){
                System.out.println("todo salio good2");

            }else if (uno == 2){
                System.out.println("todo salio good3");

            }else if(uno == 3){
                System.out.println("todo salio good4");

            }else if(uno == 4){
                System.out.println("todo salio good5");

            }else if(uno == 5){
                System.out.println("todo salio good6");

            }else if(uno == 6){
                System.out.println("todo salio good7");

            }
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