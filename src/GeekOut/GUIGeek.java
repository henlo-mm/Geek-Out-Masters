package GeekOut;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ActionMapUIResource;
import java.util.Random;
public class GUIGeek extends JFrame{
    public static final String MENSAJE_INICIO="Bienvenido a Geek-Out-Masters\n" +
            "\n Geek Out! Masters es un juego de dados y cada una de las 6 caras de los mismos "+
            "\n tienen 1 dibujo que permite al jugador hacer 1 acción especial:"+
            "\n      El 42 otorga puntos. Cada dado activo que salga con esta cara se pondrá en el track de puntos" +
            "\n      El Meeple permite relanzar otro dado en juego"+
            "\n      La Nave Espacial envía un dado no usado a la sección de dados inactivos"+
            "\n      El Superhéroe permite que cualquier dado no usado sea volteado y colocado en su cara opuesta"+
            "\n      El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo. "+
            "\n      El Dragón es la cara que queremos evitar, si al final de la ronda es el último dado activo perdemos nuestro puntos"+
            "\n De los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\""+
            "\n Ahora bien, para ganar el juego deberás tener un minimo de 30 puntos en menos de 5 rondas, de otra manera perderas el juego";
    private Header headerProject;
    private JButton tirar, salir,ayuda;
    private  JButton[] dados;
    private JButton[] botones;
    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUsados, panelPuntuacion;
    private ImageIcon imageDado, imageDado2, imageDado3,imageDado4, imageDado5, imageDado6;
    private GUIGeek.Escucha escucha;
    ArrayList<ImageIcon> imagenes;
    private Dado dado_;
    private JSeparator separator;
    private ModelGeek modelGeek;
    int uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;
    private TitledBorder titledBorder;


    public GUIGeek() {
        this.initGUI();
        this.setTitle("Geek Out Masters");
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
        dado_ = new Dado();
        headerProject = new Header("GEEK OUT MASTERS", new Color(68, 68, 68));
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=3;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        //Boton ayuda

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        //ayuda.setOpaque(true);
        //ayuda.setIcon(new ImageIcon(getClass().getResource("/resources/ayuda2.png")));
        //ayuda.setPreferredSize(new Dimension(30,30));
        //ayuda.setMargin(new Insets(0, 0, 0, 0));
        //ayuda.setBorder(null);
        //ayuda.setContentAreaFilled(false);
        //ayuda.setFocusable(true);
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

        uno = ran.nextInt(6);
        dos = ran.nextInt(6);
        tres = ran.nextInt(6);
        cuatro = ran.nextInt(6);
        cinco = ran.nextInt(6);
        seis = ran.nextInt(6);
        siete = ran.nextInt(6);
        ocho = ran.nextInt(6);
        nueve = ran.nextInt(6);
        diez = ran.nextInt(6) ;

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
        //dados[0].setActionCommand();
        dados[0].addActionListener(escucha);
        dados[0].setOpaque(true);
        dados[0].setBorder(null);
        dados[0].setContentAreaFilled(false);
        dados[0].setFocusable(true);

        dados[1] = new JButton(imagenes.get(cinco));
        dados[1].addActionListener(escucha);
        dados[1].setOpaque(true);
        dados[1].setBorder(null);
        dados[1].setContentAreaFilled(false);
        dados[1].setFocusable(true);

        dados[2] = new JButton(imagenes.get(seis));
        dados[2].addActionListener(escucha);
        dados[2].setOpaque(true);
        dados[2].setBorder(null);
        dados[2].setContentAreaFilled(false);
        dados[2].setFocusable(true);

        dados[3] = new JButton(imagenes.get(siete));
        dados[3].addActionListener(escucha);
        dados[3].setOpaque(true);
        dados[3].setBorder(null);
        dados[3].setContentAreaFilled(false);
        dados[3].setFocusable(true);

        dados[4] = new JButton(imagenes.get(ocho));
        dados[4].addActionListener(escucha);
        dados[4].setOpaque(true);
        dados[4].setBorder(null);
        dados[4].setContentAreaFilled(false);
        dados[4].setFocusable(true);

        dados[5] = new JButton(imagenes.get(nueve));
        dados[5].addActionListener(escucha);
        dados[5].setOpaque(true);
        dados[5].setBorder(null);
        dados[5].setContentAreaFilled(false);
        dados[5].setFocusable(true);

        dados[6] = new JButton(imagenes.get(diez));
        dados[6].addActionListener(escucha);
        dados[6].setOpaque(true);
        dados[6].setBorder(null);
        dados[6].setContentAreaFilled(false);
        dados[6].setFocusable(true);

        //Panel Dados Activos
        TitledBorder border = BorderFactory.createTitledBorder("DADOS ACTIVOS:");
        // border.setTitleColor(new Color(252, 252, 252));
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(border);
        //panelDadosActivos.setBackground(new Color(12, 30, 127));
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
        botones[0].addActionListener(escucha);
        botones[0].setOpaque(true);
        botones[0].setBorder(null);
        botones[0].setContentAreaFilled(false);
        botones[0].setFocusable(true);
        botones[0].setEnabled(false);

        botones[1] = new JButton(imagenes.get(dos));
        botones[1].addActionListener(escucha);
        botones[1].setOpaque(true);
        botones[1].setBorder(null);
        botones[1].setContentAreaFilled(false);
        botones[1].setFocusable(true);
        botones[1].setEnabled(false);

        botones[2] = new JButton(imagenes.get(tres));
        botones[2].addActionListener(escucha);
        botones[2].setOpaque(true);
        botones[2].setBorder(null);
        botones[2].setContentAreaFilled(false);
        botones[2].setFocusable(true);
        botones[2].setEnabled(false);

        //Panel Dados Inactivos

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("DADOS INACTIVOS:"));
        panelDadosInactivos.add(botones[0]);
        panelDadosInactivos.add(botones[1]);
        panelDadosInactivos.add(botones[2]);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosInactivos, constraints);

        //Panel Dados Usados

        panelDadosUsados = new JPanel();
        panelDadosUsados.setPreferredSize(new Dimension(450, 250));
        panelDadosUsados.setBorder(BorderFactory.createTitledBorder("DADOS USADOS:"));
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
        panelPuntuacion.setBorder(BorderFactory.createTitledBorder("PUNTAJE:"));
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

    private class Escucha extends MouseAdapter implements ActionListener {

        public void actionPerformed(ActionEvent e) {



            if (e.getSource() == salir){
                System.exit(0);
            }
            if (e.getSource() == ayuda){
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }

        }

        }
    }
