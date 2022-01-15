package GeekOut;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;
public class GUIGeek extends JFrame{
    public static final String MENSAJE_INICIO="PROBANDO";
    private Header headerProject;
   // private JLabel dado_label, dado_label2, dado_label3, dado_label4, dado_label5, dado_label6, dado_label7, dado_label8, dado_label9, dado_label10, dados_activos, dados_inactivos, dados_usados, tarjeton_puntaje;
    private JButton tirar, salir,ayuda,dado,dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10, dadoInactivo, dadoInactivo2, dadoInactivo3;
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




        imageDado = new ImageIcon(getClass().getResource("/resources/"+cuatro+".png"));
        dado = new JButton(imageDado);
        dado.setOpaque(true);
        dado.setBorder(null);
        dado.setContentAreaFilled(false);
        dado.setFocusable(true);

        imageDado2 = new ImageIcon(getClass().getResource("/resources/"+cinco+".png"));
        dado2 = new JButton(imageDado2);
        dado2.setOpaque(true);
        dado2.setBorder(null);
        dado2.setContentAreaFilled(false);
        dado2.setFocusable(true);

        imageDado3 = new ImageIcon(getClass().getResource("/resources/"+seis+".png"));
        dado3 = new JButton(imageDado3);
        dado3.setOpaque(true);
        dado3.setBorder(null);
        dado3.setContentAreaFilled(false);
        dado3.setFocusable(true);

        imageDado4 = new ImageIcon(getClass().getResource("/resources/"+siete+".png"));
        dado4 = new JButton(imageDado4);
        dado4.setOpaque(true);
        dado4.setBorder(null);
        dado4.setContentAreaFilled(false);
        dado4.setFocusable(true);

        imageDado5 = new ImageIcon(getClass().getResource("/resources/"+ocho+".png"));
        dado5 = new JButton(imageDado5);
        dado5.setOpaque(true);
        dado5.setBorder(null);
        dado5.setContentAreaFilled(false);
        dado5.setFocusable(true);

        imageDado6 = new ImageIcon(getClass().getResource("/resources/"+nueve+".png"));
        dado6 = new JButton(imageDado3);
        dado6.setOpaque(true);
        dado6.setBorder(null);
        dado6.setContentAreaFilled(false);
        dado6.setFocusable(true);

        imageDado7 = new ImageIcon(getClass().getResource("/resources/"+diez+".png"));
        dado7 = new JButton(imageDado7);
        dado7.setOpaque(true);
        dado7.setBorder(null);
        dado7.setContentAreaFilled(false);
        dado7.setFocusable(true);






        //Panel dados Activos
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos:"));
        panelDadosActivos.add(dado);
        panelDadosActivos.add(dado2);
        panelDadosActivos.add(dado3);
        panelDadosActivos.add(dado4);
        panelDadosActivos.add(dado5);
        panelDadosActivos.add(dado6);
        panelDadosActivos.add(dado7);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosActivos, constraints);
        //panelDadosActivos.add(dados_activos);


        //inactivos = new ImageIcon(getClass().getResource("/resources/dados_inactivo2s.png"));
        //dados_inactivos = new JLabel(inactivos);





        imageDadoInactivo = new ImageIcon(getClass().getResource("/resources/"+uno+".png"));
        dadoInactivo = new JButton(imageDadoInactivo);
        dadoInactivo.setOpaque(true);
        dadoInactivo.setBorder(null);
        dadoInactivo.setContentAreaFilled(false);
        dadoInactivo.setFocusable(true);

        imageDadoInactivo2 = new ImageIcon(getClass().getResource("/resources/"+dos+".png"));
        dadoInactivo2 = new JButton(imageDadoInactivo2);
        dadoInactivo2.setOpaque(true);
        dadoInactivo2.setBorder(null);
        dadoInactivo2.setContentAreaFilled(false);
        dadoInactivo2.setFocusable(true);

        imageDadoInactivo3 = new ImageIcon(getClass().getResource("/resources/"+tres+".png"));
        dadoInactivo3 = new JButton(imageDadoInactivo3);
        dadoInactivo3.setOpaque(true);
        dadoInactivo3.setBorder(null);
        dadoInactivo3.setContentAreaFilled(false);
        dadoInactivo3.setFocusable(true);





        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos:"));
        panelDadosInactivos.add(dadoInactivo);
        panelDadosInactivos.add(dadoInactivo2);
        panelDadosInactivos.add(dadoInactivo3);
        //panelDadosInactivos.setBackground();
        constraints.gridx=0;
        constraints.gridy=3;
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
