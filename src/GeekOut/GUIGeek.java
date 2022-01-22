package GeekOut;
//Esperanza Calderon 2025176 - 2711
//Robert Fernando Gil 2022985 - 2711
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Random;
public class GUIGeek extends JFrame {
    public static final String MENSAJE_INICIO = "Bienvenido a Geek-Out-Masters\n" +
            "\n Geek Out! Masters es un juego de dados y cada una de las 6 caras de los mismos " +
            "\n tienen 1 dibujo que permite al jugador hacer 1 acción especial:" +
            "\n      El 42 otorga puntos. Cada dado activo que salga con esta cara se pondrá en el track de puntos" +
            "\n      El Meeple permite relanzar otro dado en juego" +
            "\n      La Nave Espacial envía un dado no usado a la sección de dados inactivos" +
            "\n      El Superhéroe permite que cualquier dado no usado sea volteado y colocado en su cara opuesta" +
            "\n      El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo. " +
            "\n      El Dragón es la cara que queremos evitar, si al final de la ronda es el último dado activo perdemos nuestro puntos" +
            "\n De los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\"" +
            "\n Ahora bien, para ganar el juego deberás tener un minimo de 30 puntos en menos de 5 rondas, de otra manera perderas el juego";
    private JButton tirar, salir, ayuda;
    private JButton[] dados;
    private JButton[] botones;
    private JPanel panelDadosActivos, panelDadosInactivos, panelDadosUsados, panelPuntuacion;
    private ImageIcon imageDado, imageDado2, imageDado3, imageDado4, imageDado5, imageDado6;
    private GUIGeek.Escucha escucha;
    ArrayList<ImageIcon> imagenes;
    private Dado dado_;
    private ModelGeek modelGeek;
    int uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;



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
        Header headerProject = new Header("GEEK OUT MASTERS", new Color(68, 68, 68));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

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
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda, constraints);

        //Boton Tirar
        tirar = new JButton(" Tirar ");
        tirar.addActionListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(tirar, constraints);

        //Boton Salir
        salir = new JButton(" Salir ");
        salir.addActionListener(escucha);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir, constraints);

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
        diez = ran.nextInt(6);

        //Arralist de imagenes
        imagenes = new ArrayList<>();

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
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
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
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelDadosInactivos, constraints);

        //Panel Dados Usados

        panelDadosUsados = new JPanel();
        panelDadosUsados.setPreferredSize(new Dimension(450, 250));
        panelDadosUsados.setBorder(BorderFactory.createTitledBorder("DADOS USADOS:"));
        //panelDadosUsados.add(dados_usados);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelDadosUsados, constraints);

        //Panel Puntuacion

        panelPuntuacion = new JPanel();
        panelPuntuacion.setPreferredSize(new Dimension(450, 250));
        panelPuntuacion.setBorder(BorderFactory.createTitledBorder("PUNTAJE:"));
        //panelPuntuacion.add(tarjeton_puntaje);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelPuntuacion, constraints);
        //panelPuntuacion.add();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIGeek miProjectGUI = new GUIGeek();
        });
    }

    private class Escucha implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            //Primer dado activo
            //Acciones del Dragón

            if (e.getSource() == dados[0] && cuatro == 0) {
                dado_.getDragon();
            }else if (e.getSource() == dados[1] && cinco == 0) {
                dado_.getDragon();
            }else if (e.getSource() == dados[2] && seis == 0) {
                dado_.getDragon();
            }else  if (e.getSource() == dados[3] && siete == 0) {
                dado_.getDragon();
            } if (e.getSource() == dados[4] && ocho == 0) {
                dado_.getDragon();
            }  if (e.getSource() == dados[5] && nueve == 0) {
                dado_.getDragon();
            }if (e.getSource() == dados[6] && diez == 0) {
                dado_.getDragon();
            }
            //Segundo dado activo
            //Acciones del Meple

            //Segundo dado activo
            //Acciones del Meple

            // -------------------   AQUI EMPIEZAN LOS DADOS DEL MEEPLE  ------------
            else if (e.getSource() == dados[0] && cuatro == 1) {

                panelDadosActivos.remove(dados[0]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[0]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;


                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;


                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[2] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && siete == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 4;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && nueve == 0) {

                                        dados[5].setIcon(imagenes.get(2));
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;


                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            }
            // segundo dado
            // -------------------   AQUI EMPIEZAN LOS DADOS DEL MEEPLE  ------------
            else if (e.getSource() == dados[1] && cuatro == 1) {

                panelDadosActivos.remove(dados[1]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[1]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[2] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && siete == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 4;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && nueve == 0) {

                                        dados[5].setIcon(imagenes.get(2));
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;


                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            }
            else if (e.getSource() == dados[2] && cuatro == 1) {

                panelDadosActivos.remove(dados[2]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[2]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && siete == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;
                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[3].setIcon(imagenes.get(x));
                                        dados[3].addActionListener(escucha);
                                        siete = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 4;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && nueve == 0) {

                                        dados[5].setIcon(imagenes.get(2));
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;


                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            } else if (e.getSource() == dados[3] && siete == 1) {

                panelDadosActivos.remove(dados[3]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[3]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);


                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 4;
                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && ocho == 0) {

                                        dados[5].setIcon(imagenes.get(2));
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;


                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            } else if (e.getSource() == dados[4] && cuatro == 1) {

                panelDadosActivos.remove(dados[4]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[4]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);


                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && siete == 0) {

                                        dados[3].setIcon(imagenes.get(2));
                                        dados[3].addActionListener(escucha);
                                        siete = 2;
                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        dados[3].setIcon(imagenes.get(4));
                                        dados[3].addActionListener(escucha);
                                        siete = 4;
                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {

                                        dados[3].setIcon(imagenes.get(0));
                                        dados[3].addActionListener(escucha);
                                        siete = 0;

                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {

                                        dados[3].setIcon(imagenes.get(5));
                                        dados[3].addActionListener(escucha);
                                        siete = 5;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {

                                        dados[3].setIcon(imagenes.get(1));
                                        dados[3].addActionListener(escucha);
                                        siete = 1;

                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {

                                        dados[3].setIcon(imagenes.get(3));
                                        dados[3].addActionListener(escucha);
                                        siete = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && nueve == 0) {

                                        dados[5].setIcon(imagenes.get(2));
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;


                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            }  else if (e.getSource() == dados[6] && cuatro == 1) {

                panelDadosActivos.remove(dados[6]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[6]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);


                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && siete == 0) {

                                        dados[3].setIcon(imagenes.get(2));
                                        dados[3].addActionListener(escucha);
                                        siete = 2;
                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        dados[3].setIcon(imagenes.get(4));
                                        dados[3].addActionListener(escucha);
                                        siete = 4;
                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {

                                        dados[3].setIcon(imagenes.get(0));
                                        dados[3].addActionListener(escucha);
                                        siete = 0;

                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {

                                        dados[3].setIcon(imagenes.get(5));
                                        dados[3].addActionListener(escucha);
                                        siete = 5;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {

                                        dados[3].setIcon(imagenes.get(1));
                                        dados[3].addActionListener(escucha);
                                        siete = 1;

                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {

                                        dados[3].setIcon(imagenes.get(3));
                                        dados[3].addActionListener(escucha);
                                        siete = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;


                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);


                            dados[5].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[5] && nueve == 0) {

                                        dados[5].setIcon(imagenes.get(2));;
                                        dados[5].addActionListener(escucha);
                                        nueve = 2;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 1) {

                                        dados[5].setIcon(imagenes.get(4));
                                        dados[5].addActionListener(escucha);
                                        nueve = 4;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 2) {

                                        dados[5].setIcon(imagenes.get(0));
                                        dados[5].addActionListener(escucha);
                                        nueve = 0;
                                    }
                                    if (e.getSource() == dados[5] && nueve == 3) {

                                        dados[5].setIcon(imagenes.get(5));
                                        dados[5].addActionListener(escucha);
                                        nueve = 5;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 4) {

                                        dados[5].setIcon(imagenes.get(1));
                                        dados[5].addActionListener(escucha);
                                        nueve = 1;

                                    }
                                    if (e.getSource() == dados[5] && nueve == 5) {

                                        dados[5].setIcon(imagenes.get(3));
                                        dados[5].addActionListener(escucha);
                                        nueve = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            }  else if (e.getSource() == dados[5] && cuatro == 1) {

                panelDadosActivos.remove(dados[5]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[5]);
                panelDadosUsados.repaint();
                System.out.print(e.getID());


                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[0] && cuatro == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 1) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 2) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 3) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;


                                    }
                                    if (e.getSource() == dados[0] && cuatro == 4) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }
                                    if (e.getSource() == dados[0] && cuatro == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[0].setIcon(imagenes.get(x));
                                        dados[0].addActionListener(escucha);
                                        cuatro = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[1] && cinco == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;
                                    }
                                    if (e.getSource() == dados[1] && cinco == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }
                                    if (e.getSource() == dados[1] && cinco == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[1].setIcon(imagenes.get(x));
                                        dados[1].addActionListener(escucha);
                                        cinco = x;

                                    }


                                }
                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);


                            dados[2].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[3] && seis == 0) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 1) {

                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 2) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 3) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }
                                    if (e.getSource() == dados[2] && seis == 4) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;
                                    }
                                    if (e.getSource() == dados[2] && seis == 5) {
                                        Random ran = new Random();
                                        int x = ran.nextInt(6);
                                        dados[2].setIcon(imagenes.get(x));
                                        dados[2].addActionListener(escucha);
                                        seis = x;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);


                            dados[3].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && siete == 0) {

                                        dados[3].setIcon(imagenes.get(2));
                                        dados[3].addActionListener(escucha);
                                        siete = 2;
                                    }
                                    if (e.getSource() == dados[3] && siete == 1) {

                                        dados[3].setIcon(imagenes.get(4));
                                        dados[3].addActionListener(escucha);
                                        siete = 4;
                                    }
                                    if (e.getSource() == dados[3] && siete == 2) {

                                        dados[3].setIcon(imagenes.get(0));
                                        dados[3].addActionListener(escucha);
                                        siete = 0;

                                    }
                                    if (e.getSource() == dados[3] && siete == 3) {

                                        dados[3].setIcon(imagenes.get(5));
                                        dados[3].addActionListener(escucha);
                                        siete = 5;

                                    }
                                    if (e.getSource() == dados[3] && siete == 4) {

                                        dados[3].setIcon(imagenes.get(1));
                                        dados[3].addActionListener(escucha);
                                        siete = 1;

                                    }
                                    if (e.getSource() == dados[3] && siete == 5) {

                                        dados[3].setIcon(imagenes.get(3));
                                        dados[3].addActionListener(escucha);
                                        siete = 3;

                                    }

                                }
                            });
                        }
                    }
                });


                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);


                            dados[4].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[4] && ocho == 0) {

                                        dados[4].setIcon(imagenes.get(2));
                                        dados[4].addActionListener(escucha);
                                        ocho = 2;

                                    }
                                    if (e.getSource() == dados[5] && ocho == 1) {

                                        dados[4].setIcon(imagenes.get(4));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 2) {

                                        dados[4].setIcon(imagenes.get(0));
                                        dados[4].addActionListener(escucha);
                                        ocho = 0;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 3) {

                                        dados[4].setIcon(imagenes.get(5));
                                        dados[4].addActionListener(escucha);
                                        ocho = 5;

                                    }
                                    if (e.getSource() == dados[4] && ocho == 4) {

                                        dados[4].setIcon(imagenes.get(1));
                                        dados[4].addActionListener(escucha);
                                        ocho = 1;


                                    }
                                    if (e.getSource() == dados[4] && ocho == 5) {

                                        dados[4].setIcon(imagenes.get(3));
                                        dados[4].addActionListener(escucha);
                                        ocho = 3;

                                    }

                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);


                            dados[6].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == dados[6] && diez == 0) {

                                        dados[6].setIcon(imagenes.get(2));;
                                        dados[6].addActionListener(escucha);
                                        diez = 2;

                                    }
                                    if (e.getSource() == dados[6] && diez == 1) {

                                        dados[6].setIcon(imagenes.get(4));
                                        dados[6].addActionListener(escucha);
                                        diez = 4;

                                    }
                                    if (e.getSource() == dados[6] && diez == 2) {

                                        dados[6].setIcon(imagenes.get(0));
                                        dados[6].addActionListener(escucha);
                                        diez = 0;
                                    }
                                    if (e.getSource() == dados[6] && diez == 3) {

                                        dados[6].setIcon(imagenes.get(5));
                                        dados[6].addActionListener(escucha);
                                        diez = 5;

                                    }
                                    if (e.getSource() == dados[6] && diez == 4) {

                                        dados[6].setIcon(imagenes.get(1));
                                        dados[6].addActionListener(escucha);
                                        diez = 1;

                                    }
                                    if (e.getSource() == dados[6] && diez == 5) {

                                        dados[6].setIcon(imagenes.get(3));
                                        dados[6].addActionListener(escucha);
                                        diez = 3;

                                    }

                                }
                            });
                        }

                    }
                });


            }
            //Tercer dado activo
            //Acciones del Superhéroe

            if (e.getSource() == dados[0] && cuatro == 2) {

                panelDadosActivos.remove(dados[0]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[0]);
                panelDadosUsados.repaint();

                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e143 -> {
                                if (e143.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e143.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e143.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e143.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e143.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e143.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });


                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e144 -> {
                                if (e144.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;
                                }
                                if (e144.getSource() == dados[2] && seis == 1) {

                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e144.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e144.getSource() == dados[2] && seis == 3) {

                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;

                                }
                                if (e144.getSource() == dados[2] && seis == 4) {

                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;

                                }
                                if (e144.getSource() == dados[2] && seis == 5) {

                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e145 -> {
                                if (e145.getSource() == dados[3] && siete == 0) {

                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;

                                }
                                if (e145.getSource() == dados[3] && siete == 1) {

                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;

                                }
                                if (e145.getSource() == dados[3] && siete == 2) {

                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;

                                }
                                if (e145.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;

                                }
                                if (e145.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e145.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 3;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e146 -> {
                                if (e146.getSource() == dados[4] && ocho == 0) {

                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e146.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;
                                }
                                if (e146.getSource() == dados[4] && ocho == 2) {

                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;

                                }
                                if (e146.getSource() == dados[4] && ocho == 3) {

                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;

                                }
                                if (e146.getSource() == dados[4] && ocho == 4) {

                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;

                                }
                                if (e146.getSource() == dados[4] && ocho == 5) {

                                    dados[3].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e147 -> {
                                if (e147.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e147.getSource() == dados[5] && nueve == 1) {

                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;

                                }
                                if (e147.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;

                                }
                                if (e147.getSource() == dados[5] && nueve == 3) {

                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;

                                }
                                if (e147.getSource() == dados[5] && nueve == 4) {

                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;

                                }
                                if (e147.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e148 -> {
                                if (e148.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e148.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez = 4;

                                }
                                if (e148.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e148.getSource() == dados[6] && diez == 3) {

                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;

                                }
                                if (e148.getSource() == dados[6] && diez == 4) {

                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;

                                }
                                if (e148.getSource() == dados[6] && diez == 5) {

                                    dados[5].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }

                            });
                        }

                    }
                });
            }

            else if (e.getSource() == dados[1] && cinco == 2) {

                panelDadosActivos.remove(dados[1]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[1]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e12 -> {
                                if (e12.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e12.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e12.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e12.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e12.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e12.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e13 -> {
                                if (e13.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;

                                }
                                if (e13.getSource() == dados[2] && seis == 1) {
                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e13.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e13.getSource() == dados[2] && seis == 3) {
                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 5;
                                }
                                if (e13.getSource() == dados[2] && seis == 4) {

                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;
                                }
                                if (e13.getSource() == dados[2] && seis == 5) {
                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e14 -> {
                                if (e14.getSource() == dados[3] && siete == 0) {
                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;
                                }
                                if (e14.getSource() == dados[3] && siete == 1) {
                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;
                                }
                                if (e14.getSource() == dados[3] && siete == 2) {
                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;
                                }
                                if (e14.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                                if (e14.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e14.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e15 -> {
                                if (e15.getSource() == dados[4] && ocho == 0) {
                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e15.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;

                                }
                                if (e15.getSource() == dados[4] && ocho == 2) {
                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;
                                }
                                if (e15.getSource() == dados[4] && ocho == 3) {
                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;
                                }
                                if (e15.getSource() == dados[4] && ocho == 4) {
                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;
                                }
                                if (e15.getSource() == dados[4] && ocho == 5) {
                                    dados[4].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e16 -> {
                                if (e16.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e16.getSource() == dados[5] && nueve == 1) {
                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 4;
                                }
                                if (e16.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;
                                }
                                if (e16.getSource() == dados[5] && nueve == 3) {
                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;
                                }
                                if (e16.getSource() == dados[5] && nueve == 4) {
                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;
                                }
                                if (e16.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e17 -> {
                                if (e17.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e17.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez=4;
                                }
                                if (e17.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e17.getSource() == dados[6] && diez == 3) {
                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;
                                }
                                if (e17.getSource() == dados[6] && diez == 4) {
                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;
                                }
                                if (e17.getSource() == dados[6] && diez == 5) {
                                    dados[6].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }
                            });
                        }
                    }
                });

            }

            else if (e.getSource() == dados[2] && seis == 2) {

                panelDadosActivos.remove(dados[2]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[2]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e1 -> {
                                if (e1.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e1.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e1.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e1.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e1.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e1.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e18 -> {
                                if (e18.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e18.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e18.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e18.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e18.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e18.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });



                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e19 -> {
                                if (e19.getSource() == dados[3] && siete == 0) {
                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;
                                }
                                if (e19.getSource() == dados[3] && siete == 1) {
                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;
                                }
                                if (e19.getSource() == dados[3] && siete == 2) {
                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;
                                }
                                if (e19.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                                if (e19.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e19.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e110 -> {
                                if (e110.getSource() == dados[4] && ocho == 0) {
                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e110.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;

                                }
                                if (e110.getSource() == dados[4] && ocho == 2) {
                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;
                                }
                                if (e110.getSource() == dados[4] && ocho == 3) {
                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;
                                }
                                if (e110.getSource() == dados[4] && ocho == 4) {
                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;
                                }
                                if (e110.getSource() == dados[4] && ocho == 5) {
                                    dados[4].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e111 -> {
                                if (e111.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e111.getSource() == dados[5] && nueve == 1) {
                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 4;
                                }
                                if (e111.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;
                                }
                                if (e111.getSource() == dados[5] && nueve == 3) {
                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;
                                }
                                if (e111.getSource() == dados[5] && nueve == 4) {
                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;
                                }
                                if (e111.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e112 -> {
                                if (e112.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e112.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez=4;
                                }
                                if (e112.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e112.getSource() == dados[6] && diez == 3) {
                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;
                                }
                                if (e112.getSource() == dados[6] && diez == 4) {
                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;
                                }
                                if (e112.getSource() == dados[6] && diez == 5) {
                                    dados[6].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }
                            });
                        }
                    }
                });

            }
            else if (e.getSource() == dados[3] && siete == 2) {

                panelDadosActivos.remove(dados[3]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[3]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e113 -> {
                                if (e113.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e113.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e113.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e113.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e113.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e113.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e114 -> {
                                if (e114.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e114.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e114.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e114.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e114.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e114.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });
                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e115 -> {
                                if (e115.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;

                                }
                                if (e115.getSource() == dados[2] && seis == 1) {
                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e115.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e115.getSource() == dados[2] && seis == 3) {
                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 5;
                                }
                                if (e115.getSource() == dados[2] && seis == 4) {

                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;
                                }
                                if (e115.getSource() == dados[2] && seis == 5) {
                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e116 -> {
                                if (e116.getSource() == dados[4] && ocho == 0) {
                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e116.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;

                                }
                                if (e116.getSource() == dados[4] && ocho == 2) {
                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;
                                }
                                if (e116.getSource() == dados[4] && ocho == 3) {
                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;
                                }
                                if (e116.getSource() == dados[4] && ocho == 4) {
                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;
                                }
                                if (e116.getSource() == dados[4] && ocho == 5) {
                                    dados[4].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e117 -> {
                                if (e117.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e117.getSource() == dados[5] && nueve == 1) {
                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 4;
                                }
                                if (e117.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;
                                }
                                if (e117.getSource() == dados[5] && nueve == 3) {
                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;
                                }
                                if (e117.getSource() == dados[5] && nueve == 4) {
                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;
                                }
                                if (e117.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e118 -> {
                                if (e118.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e118.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez=4;
                                }
                                if (e118.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e118.getSource() == dados[6] && diez == 3) {
                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;
                                }
                                if (e118.getSource() == dados[6] && diez == 4) {
                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;
                                }
                                if (e118.getSource() == dados[6] && diez == 5) {
                                    dados[6].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }
                            });
                        }
                    }
                });

            }
            else if (e.getSource() == dados[4] && ocho == 2) {

                panelDadosActivos.remove(dados[4]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[4]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e119 -> {
                                if (e119.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e119.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e119.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e119.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e119.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e119.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e120 -> {
                                if (e120.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e120.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e120.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e120.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e120.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e120.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });
                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e121 -> {
                                if (e121.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;

                                }
                                if (e121.getSource() == dados[2] && seis == 1) {
                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e121.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e121.getSource() == dados[2] && seis == 3) {
                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 5;
                                }
                                if (e121.getSource() == dados[2] && seis == 4) {
                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;
                                }
                                if (e121.getSource() == dados[2] && seis == 5) {
                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });




                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e122 -> {
                                if (e122.getSource() == dados[3] && siete == 0) {
                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;
                                }
                                if (e122.getSource() == dados[3] && siete == 1) {
                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;
                                }
                                if (e122.getSource() == dados[3] && siete == 2) {
                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;
                                }
                                if (e122.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                                if (e122.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e122.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e123 -> {
                                if (e123.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e123.getSource() == dados[5] && nueve == 1) {
                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 4;
                                }
                                if (e123.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;
                                }
                                if (e123.getSource() == dados[5] && nueve == 3) {
                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;
                                }
                                if (e123.getSource() == dados[5] && nueve == 4) {
                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;
                                }
                                if (e123.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e124 -> {
                                if (e124.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e124.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez=4;
                                }
                                if (e124.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e124.getSource() == dados[6] && diez == 3) {
                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;
                                }
                                if (e124.getSource() == dados[6] && diez == 4) {
                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;
                                }
                                if (e124.getSource() == dados[6] && diez == 5) {
                                    dados[6].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }
                            });
                        }
                    }
                });

            }
            else if (e.getSource() == dados[5] && nueve == 2) {

                panelDadosActivos.remove(dados[5]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[5]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e125 -> {
                                if (e125.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e125.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e125.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e125.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e125.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e125.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e126 -> {
                                if (e126.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e126.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e126.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e126.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e126.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e126.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });
                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e127 -> {
                                if (e127.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;

                                }
                                if (e127.getSource() == dados[2] && seis == 1) {
                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e127.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e127.getSource() == dados[2] && seis == 3) {
                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 5;
                                }
                                if (e127.getSource() == dados[2] && seis == 4) {

                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;
                                }
                                if (e127.getSource() == dados[2] && seis == 5) {
                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });




                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e128 -> {
                                if (e128.getSource() == dados[3] && siete == 0) {
                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;
                                }
                                if (e128.getSource() == dados[3] && siete == 1) {
                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;
                                }
                                if (e128.getSource() == dados[3] && siete == 2) {
                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;
                                }
                                if (e128.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                                if (e128.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e128.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e129 -> {
                                if (e129.getSource() == dados[4] && ocho == 0) {
                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e129.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;

                                }
                                if (e129.getSource() == dados[4] && ocho == 2) {
                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;
                                }
                                if (e129.getSource() == dados[4] && ocho == 3) {
                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;
                                }
                                if (e129.getSource() == dados[4] && ocho == 4) {
                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;
                                }
                                if (e129.getSource() == dados[4] && ocho == 5) {
                                    dados[4].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e130 -> {
                                if (e130.getSource() == dados[6] && diez == 0) {
                                    dados[6].setIcon(imagenes.get(2));
                                    dados[6].addActionListener(escucha);
                                    diez = 2;
                                }
                                if (e130.getSource() == dados[6] && diez == 1) {
                                    dados[6].setIcon(imagenes.get(4));
                                    dados[6].addActionListener(escucha);
                                    diez=4;
                                }
                                if (e130.getSource() == dados[6] && diez == 2) {
                                    dados[6].setIcon(imagenes.get(0));
                                    dados[6].addActionListener(escucha);
                                    diez = 0;
                                }
                                if (e130.getSource() == dados[6] && diez == 3) {
                                    dados[6].setIcon(imagenes.get(5));
                                    dados[6].addActionListener(escucha);
                                    diez = 5;
                                }
                                if (e130.getSource() == dados[6] && diez == 4) {
                                    dados[6].setIcon(imagenes.get(1));
                                    dados[6].addActionListener(escucha);
                                    diez = 1;
                                }
                                if (e130.getSource() == dados[6] && diez == 5) {
                                    dados[6].setIcon(imagenes.get(3));
                                    dados[6].addActionListener(escucha);
                                    diez = 3;
                                }
                            });
                        }
                    }
                });

            }
            else if (e.getSource() == dados[6] && diez == 2) {

                panelDadosActivos.remove(dados[6]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[6]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e131 -> {
                                if (e131.getSource() == dados[0] && cuatro == 0) {
                                    dados[0].setIcon(imagenes.get(2));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 2;
                                }
                                if (e131.getSource() == dados[0] && cuatro == 1) {
                                    dados[0].setIcon(imagenes.get(4));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 4;
                                }
                                if (e131.getSource() == dados[0] && cuatro == 2) {

                                    dados[0].setIcon(imagenes.get(0));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 0;
                                }
                                if (e131.getSource() == dados[0] && cuatro== 3) {
                                    dados[0].setIcon(imagenes.get(5));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 5;
                                }
                                if (e131.getSource() == dados[0] && cuatro== 4) {
                                    dados[0].setIcon(imagenes.get(1));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 1;
                                }
                                if (e131.getSource() == dados[0] && cuatro == 5) {
                                    dados[0].setIcon(imagenes.get(3));
                                    dados[0].addActionListener(escucha);
                                    cuatro = 3;
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e132 -> {
                                if (e132.getSource() == dados[1] && cinco == 0) {
                                    dados[1].setIcon(imagenes.get(2));
                                    dados[1].addActionListener(escucha);
                                    cinco = 2;
                                }
                                if (e132.getSource() == dados[1] && cinco == 1) {
                                    dados[1].setIcon(imagenes.get(4));
                                    dados[1].addActionListener(escucha);
                                    cinco = 4;

                                }
                                if (e132.getSource() == dados[1] && cinco == 2) {

                                    dados[1].setIcon(imagenes.get(0));
                                    dados[1].addActionListener(escucha);
                                    cinco = 0;
                                }
                                if (e132.getSource() == dados[1] && cinco == 3) {

                                    dados[1].setIcon(imagenes.get(5));
                                    dados[1].addActionListener(escucha);
                                    cinco = 5;
                                }
                                if (e132.getSource() == dados[1] && cinco == 4) {

                                    dados[1].setIcon(imagenes.get(1));
                                    dados[1].addActionListener(escucha);
                                    cinco = 1;
                                }
                                if (e132.getSource() == dados[1] && cinco == 5) {
                                    dados[1].setIcon(imagenes.get(3));
                                    dados[1].addActionListener(escucha);
                                    cinco = 3;
                                }


                            });
                        }
                    }
                });
                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e133 -> {
                                if (e133.getSource() == dados[2] && seis == 0) {
                                    dados[2].setIcon(imagenes.get(2));
                                    dados[2].addActionListener(escucha);
                                    seis = 2;

                                }
                                if (e133.getSource() == dados[2] && seis == 1) {
                                    dados[2].setIcon(imagenes.get(4));
                                    dados[2].addActionListener(escucha);
                                    seis = 4;
                                }
                                if (e133.getSource() == dados[2] && seis == 2) {

                                    dados[2].setIcon(imagenes.get(0));
                                    dados[2].addActionListener(escucha);
                                    seis = 0;
                                }
                                if (e133.getSource() == dados[2] && seis == 3) {
                                    dados[2].setIcon(imagenes.get(5));
                                    dados[2].addActionListener(escucha);
                                    seis = 5;
                                }
                                if (e133.getSource() == dados[2] && seis == 4) {

                                    dados[2].setIcon(imagenes.get(1));
                                    dados[2].addActionListener(escucha);
                                    seis = 1;
                                }
                                if (e133.getSource() == dados[2] && seis == 5) {
                                    dados[2].setIcon(imagenes.get(3));
                                    dados[2].addActionListener(escucha);
                                    seis = 3;
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e134 -> {
                                if (e134.getSource() == dados[3] && siete == 0) {
                                    dados[3].setIcon(imagenes.get(2));
                                    dados[3].addActionListener(escucha);
                                    siete = 2;
                                }
                                if (e134.getSource() == dados[3] && siete == 1) {
                                    dados[3].setIcon(imagenes.get(4));
                                    dados[3].addActionListener(escucha);
                                    siete = 4;
                                }
                                if (e134.getSource() == dados[3] && siete == 2) {
                                    dados[3].setIcon(imagenes.get(0));
                                    dados[3].addActionListener(escucha);
                                    siete = 0;
                                }
                                if (e134.getSource() == dados[3] && siete == 3) {
                                    dados[3].setIcon(imagenes.get(5));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                                if (e134.getSource() == dados[3] && siete == 4) {
                                    dados[3].setIcon(imagenes.get(1));
                                    dados[3].addActionListener(escucha);
                                    siete = 1;
                                }
                                if (e134.getSource() == dados[3] && siete == 5) {
                                    dados[3].setIcon(imagenes.get(3));
                                    dados[3].addActionListener(escucha);
                                    siete = 5;
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e135 -> {
                                if (e135.getSource() == dados[4] && ocho == 0) {
                                    dados[4].setIcon(imagenes.get(2));
                                    dados[4].addActionListener(escucha);
                                    ocho = 2;
                                }
                                if (e135.getSource() == dados[4] && ocho == 1) {

                                    dados[4].setIcon(imagenes.get(4));
                                    dados[4].addActionListener(escucha);
                                    ocho = 4;

                                }
                                if (e135.getSource() == dados[4] && ocho == 2) {
                                    dados[4].setIcon(imagenes.get(0));
                                    dados[4].addActionListener(escucha);
                                    ocho = 0;
                                }
                                if (e135.getSource() == dados[4] && ocho == 3) {
                                    dados[4].setIcon(imagenes.get(5));
                                    dados[4].addActionListener(escucha);
                                    ocho = 5;
                                }
                                if (e135.getSource() == dados[4] && ocho == 4) {
                                    dados[4].setIcon(imagenes.get(1));
                                    dados[4].addActionListener(escucha);
                                    ocho = 1;
                                }
                                if (e135.getSource() == dados[4] && ocho == 5) {
                                    dados[4].setIcon(imagenes.get(3));
                                    dados[4].addActionListener(escucha);
                                    ocho = 3;
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e136 -> {
                                if (e136.getSource() == dados[5] && nueve == 0) {
                                    dados[5].setIcon(imagenes.get(2));
                                    dados[5].addActionListener(escucha);
                                    nueve = 2;
                                }
                                if (e136.getSource() == dados[5] && nueve == 1) {
                                    dados[5].setIcon(imagenes.get(4));
                                    dados[5].addActionListener(escucha);
                                    nueve = 4;
                                }
                                if (e136.getSource() == dados[5] && nueve == 2) {
                                    dados[5].setIcon(imagenes.get(0));
                                    dados[5].addActionListener(escucha);
                                    nueve = 0;
                                }
                                if (e136.getSource() == dados[5] && nueve == 3) {
                                    dados[5].setIcon(imagenes.get(5));
                                    dados[5].addActionListener(escucha);
                                    nueve = 5;
                                }
                                if (e136.getSource() == dados[5] && nueve == 4) {
                                    dados[5].setIcon(imagenes.get(1));
                                    dados[5].addActionListener(escucha);
                                    nueve = 1;
                                }
                                if (e136.getSource() == dados[5] && nueve == 5) {
                                    dados[5].setIcon(imagenes.get(3));
                                    dados[5].addActionListener(escucha);
                                    nueve = 3;
                                }
                            });
                        }
                    }
                });
            }

            //Tercer dado activo
            //"Acciones" del 42
            if (e.getSource() == dados[0] && cuatro == 3) {
                System.out.print("42");
            }else if (e.getSource() == dados[1] && cinco == 3) {
                System.out.print("42");

            }  else if (e.getSource() == dados[2] && seis == 3) {
                System.out.print("42");

            }else if (e.getSource() == dados[3] && siete == 3) {
                System.out.print("42");

            }  else if (e.getSource() == dados[4] && ocho == 3) {
                System.out.print("42");

            } else if (e.getSource() == dados[5] && nueve == 3) {
                System.out.print("42");

            } else if (e.getSource() == dados[6] && diez == 3) {
                System.out.print("42");
            }

            //Cuarto dado activo
            //Acciones del cohete

            if (e.getSource() == dados[0] && cuatro == 4) {
                panelDadosActivos.remove(dados[0]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[0]);
                panelDadosUsados.repaint();

                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e137 -> {
                                if (e137.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e137.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e137.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e137.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e137.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e137.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });
                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e138 -> {
                                if (e138.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e138.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e138.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e138.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e138.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e138.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(80,80);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e139 -> {
                                if (e139.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e139.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e139.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e139.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e139.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e139.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(80,80);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e140 -> {
                                if (e140.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e140.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e140.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e140.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e140.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e140.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(70,70);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e141 -> {
                                if (e141.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e141.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e141.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e141.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e141.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e141.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });
                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e142 -> {
                                if (e142.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e142.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e142.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e142.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e142.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e142.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(65,65);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });


            } else if (e.getSource() == dados[1] && cinco == 4) {
                panelDadosActivos.remove(dados[1]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[1]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e149 -> {
                                if (e149.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e149.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e149.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e149.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e149.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e149.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e150 -> {
                                if (e150.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e150.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e150.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e150.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e150.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e150.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e151 -> {
                                if (e151.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e151.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e151.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e151.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e151.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e151.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e152 -> {
                                if (e152.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e152.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e152.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e152.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e152.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e152.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e153 -> {
                                if (e153.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e153.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e153.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e153.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e153.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e153.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e154 -> {
                                if (e154.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e154.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e154.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e154.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e154.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e154.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });




            }else if (e.getSource() == dados[2] && seis == 4) {
                panelDadosActivos.remove(dados[2]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[2]);
                panelDadosUsados.repaint();
                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e155 -> {
                                if (e155.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e155.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e155.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e155.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e155.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e155.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e156 -> {
                                if (e156.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e156.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e156.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e156.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e156.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e156.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e157 -> {
                                if (e157.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e157.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e157.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e157.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e157.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e157.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e158 -> {
                                if (e158.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e158.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e158.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e158.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e158.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e158.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e159 -> {
                                if (e159.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e159.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e159.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e159.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e159.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e159.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e160 -> {
                                if (e160.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e160.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e160.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e160.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e160.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e160.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



            } else if (e.getSource() == dados[3] && siete == 4) {
                panelDadosActivos.remove(dados[3]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[3]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e161 -> {
                                if (e161.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e161.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e161.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e161.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e161.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e161.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e162 -> {
                                if (e162.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e162.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e162.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e162.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e162.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e162.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e163 -> {
                                if (e163.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e163.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e163.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e163.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e163.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e163.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e164 -> {
                                if (e164.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e164.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e164.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e164.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e164.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e164.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e165 -> {
                                if (e165.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e165.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e165.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e165.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e165.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e165.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e166 -> {
                                if (e166.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e166.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e166.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e166.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e166.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e166.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



            }else if (e.getSource() == dados[4] && ocho == 4) {
                panelDadosActivos.remove(dados[4]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[4]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e167 -> {
                                if (e167.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e167.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e167.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e167.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e167.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e167.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e168 -> {
                                if (e168.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e168.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e168.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e168.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e168.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e168.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e169 -> {
                                if (e169.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e169.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e169.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e169.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e169.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e169.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e170 -> {
                                if (e170.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e170.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e170.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e170.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e170.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e170.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e171 -> {
                                if (e171.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e171.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e171.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e171.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e171.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e171.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e172 -> {
                                if (e172.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e172.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e172.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e172.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e172.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e172.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



            }else if (e.getSource() == dados[5] && nueve == 4) {
                panelDadosActivos.remove(dados[5]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[5]);
                panelDadosUsados.repaint();
                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e173 -> {
                                if (e173.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e173.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e173.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e173.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e173.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e173.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e174 -> {
                                if (e174.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e174.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e174.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e174.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e174.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e174.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e178 -> {
                                if (e178.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e178.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e178.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e178.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e178.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e178.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e177 -> {
                                if (e177.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e177.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e177.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e177.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e177.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e177.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e176 -> {
                                if (e176.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e176.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e176.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e176.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e176.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e176.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[6].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[6].removeActionListener(escucha);
                            dados[6].addActionListener(e175 -> {
                                if (e175.getSource() == dados[6] && diez == 0) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e175.getSource() == dados[6] && diez == 1) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e175.getSource() == dados[6] && diez == 2) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e175.getSource() == dados[6] && diez == 3) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e175.getSource() == dados[6] && diez == 4) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e175.getSource() == dados[6] && diez == 5) {
                                    panelDadosActivos.remove(dados[6]);
                                    panelDadosActivos.repaint();
                                    dados[6].setLocation(75,75);
                                    panelDadosInactivos.add(dados[6]);
                                    dados[6].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });



            }else if (e.getSource() == dados[6] && diez == 4) {
                panelDadosActivos.remove(dados[6]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[6]);
                panelDadosUsados.repaint();

                dados[0].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[0].removeActionListener(escucha);
                            dados[0].addActionListener(e179 -> {
                                if (e179.getSource() == dados[0] && cuatro == 0) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e179.getSource() == dados[0] && cuatro == 1) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e179.getSource() == dados[0] && cuatro == 2) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e179.getSource() == dados[0] && cuatro== 3) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e179.getSource() == dados[0] && cuatro== 4) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e179.getSource() == dados[0] && cuatro == 5) {
                                    panelDadosActivos.remove(dados[0]);
                                    panelDadosActivos.repaint();
                                    dados[0].setLocation(50,50);
                                    panelDadosInactivos.add(dados[0]);
                                    dados[0].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }


                            });
                        }
                    }
                });
                dados[1].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[1].removeActionListener(escucha);
                            dados[1].addActionListener(e180 -> {
                                if (e180.getSource() == dados[1] && cinco == 0) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e180.getSource() == dados[1] && cinco == 1) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e180.getSource() == dados[1] && cinco == 2) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e180.getSource() == dados[1] && cinco == 3) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e180.getSource() == dados[1] && cinco == 4) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e180.getSource() == dados[1] && cinco == 5) {
                                    panelDadosActivos.remove(dados[1]);
                                    panelDadosActivos.repaint();
                                    dados[1].setLocation(95,95);
                                    panelDadosInactivos.add(dados[1]);
                                    dados[1].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[2].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[2].removeActionListener(escucha);
                            dados[2].addActionListener(e181 -> {
                                if (e181.getSource() == dados[2] && seis == 0) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();

                                }
                                if (e181.getSource() == dados[2] && seis == 1) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e181.getSource() == dados[2] && seis == 2) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e181.getSource() == dados[2] && seis == 3) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e181.getSource() == dados[2] && seis == 4) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e181.getSource() == dados[2] && seis == 5) {
                                    panelDadosActivos.remove(dados[2]);
                                    panelDadosActivos.repaint();
                                    dados[2].setLocation(60,60);
                                    panelDadosInactivos.add(dados[2]);
                                    dados[2].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[3].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[3].removeActionListener(escucha);
                            dados[3].addActionListener(e182 -> {
                                if (e182.getSource() == dados[3] && siete == 0) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e182.getSource() == dados[3] && siete == 1) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e182.getSource() == dados[3] && siete == 2) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e182.getSource() == dados[3] && siete == 3) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e182.getSource() == dados[3] && siete == 4) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e182.getSource() == dados[3] && siete == 5) {
                                    panelDadosActivos.remove(dados[3]);
                                    panelDadosActivos.repaint();
                                    dados[3].setLocation(70,70);
                                    panelDadosInactivos.add(dados[3]);
                                    dados[3].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[4].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[4].removeActionListener(escucha);
                            dados[4].addActionListener(e183 -> {
                                if (e183.getSource() == dados[4] && ocho == 0) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e183.getSource() == dados[4] && ocho == 1) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e183.getSource() == dados[4] && ocho == 2) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e183.getSource() == dados[4] && ocho == 3) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e183.getSource() == dados[4] && ocho == 4) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e183.getSource() == dados[4] && ocho == 5) {
                                    panelDadosActivos.remove(dados[4]);
                                    panelDadosActivos.repaint();
                                    dados[4].setLocation(80,80);
                                    panelDadosInactivos.add(dados[4]);
                                    dados[4].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });

                dados[5].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        System.out.println(e.getButton() == MouseEvent.BUTTON3);

                        if (e.getButton() == MouseEvent.BUTTON3) {
                            dados[5].removeActionListener(escucha);
                            dados[5].addActionListener(e184 -> {
                                if (e184.getSource() == dados[5] && nueve == 0) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e184.getSource() == dados[5] && nueve == 1) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e184.getSource() == dados[5] && nueve == 2) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e184.getSource() == dados[5] && nueve == 3) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e184.getSource() == dados[5] && nueve == 4) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                                if (e184.getSource() == dados[5] && nueve == 5) {
                                    panelDadosActivos.remove(dados[5]);
                                    panelDadosActivos.repaint();
                                    dados[5].setLocation(90,90);
                                    panelDadosInactivos.add(dados[5]);
                                    dados[5].setEnabled(false);
                                    panelDadosInactivos.repaint();
                                }
                            });
                        }
                    }
                });


            }

            //Quinto dado activo
            //Acciones del corazón
            if (e.getSource() == dados[0] && cuatro == 5) {
                panelDadosActivos.remove(dados[0]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[0]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            }else if (e.getSource() == dados[1] && cinco == 5) {
                panelDadosActivos.remove(dados[1]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[1]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            }else if (e.getSource() == dados[2] && seis == 5) {
                panelDadosActivos.remove(dados[2]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[2]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            } else if (e.getSource() == dados[3] && siete == 5) {
                panelDadosActivos.remove(dados[3]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[3]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            }else if (e.getSource() == dados[4] && ocho == 5) {
                panelDadosActivos.remove(dados[4]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[4]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            }else if (e.getSource() == dados[5] && nueve == 5) {
                panelDadosActivos.remove(dados[5]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[5]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            } else if (e.getSource() == dados[6] && diez == 5) {
                panelDadosActivos.remove(dados[6]);
                panelDadosActivos.repaint();
                panelDadosUsados.add(dados[6]);
                panelDadosUsados.repaint();
                botones[0].setEnabled(true);
                botones[1].setEnabled(true);
                botones[2].setEnabled(true);
            }


            //Primer dado inactivo
            if (e.getSource() == botones[0] && uno == 0) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[0] && uno == 1) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[0] && uno == 2) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[0] && uno == 3) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[0] && uno == 4) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[0] && uno == 5) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[0]);
                panelDadosUsados.repaint();

            }


            //Segundo dado inactivo
            if (e.getSource() == botones[1] && dos == 0) {
                panelDadosInactivos.remove(botones[0]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[1] && dos == 1) {
                panelDadosInactivos.remove(botones[1]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[1] && dos == 2) {
                panelDadosInactivos.remove(botones[1]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == dados[1] && dos == 3) {
                panelDadosInactivos.remove(botones[1]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[1] && dos == 4) {
                panelDadosInactivos.remove(botones[1]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();

            } else if (e.getSource() == botones[1] && dos == 5) {
                panelDadosInactivos.remove(botones[1]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[1]);
                panelDadosUsados.repaint();
            }
            //Tercer dado inactivo
            if (e.getSource() == botones[2] && tres == 0) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            } else if (e.getSource() == botones[2] && tres == 1) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            } else if (e.getSource() == botones[2] && tres == 2) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            } else if (e.getSource() == botones[2] && tres == 3) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            } else if (e.getSource() == botones[2] && tres == 4) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            } else if (e.getSource() == botones[2] && tres == 5) {
                panelDadosInactivos.remove(botones[2]);
                panelDadosInactivos.repaint();
                panelDadosUsados.add(botones[2]);
                panelDadosUsados.repaint();
            }

            if (e.getSource() == salir) {
                System.exit(0);
            }
            if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }


        }
    }


}
