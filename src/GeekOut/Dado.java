package GeekOut;

import javax.swing.*;
import java.util.Random;
import java.util.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class Dado {
    private int dragon;
    private int heroe;
    private int nave;
    private int corazon;
    private int puntos;
    private int meple;
    private int caraDado;

    public Dado() {
    }
    public int getCara() {

        Random aleatorio = new Random();
        this.caraDado = aleatorio.nextInt(6) + 1;

        /** switch (caraDado) {
         case 1:
         System.out.println("En la cara opuesta está el \"héroe\".");
         break;
         case 2:
         System.out.println("En la cara opuesta está el \"cohete\".");
         break;
         case 3:
         System.out.println("En la cara opuesta está el \"corazón\".");
         break;
         default:
         System.out.println("ERROR");
         }
         */
        return this.caraDado;
    }

public void getDragon(){

        JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
    }
/*public void getMeeple(JButton x){

}*/
    /**  public int getCorazon() {
     Random aleatorio = new Random();
     this.corazon = aleatorio.nextInt(2) + 1;
     return this.corazon;
     }
     public int getDragon() {
     Random aleatorio = new Random();
     this.dragon = aleatorio.nextInt(2) + 1;
     return this.dragon;
     }
     public int getHeroe() {
     Random aleatorio = new Random();
     this.dragon = aleatorio.nextInt(2) + 1;
     return this.heroe;
     }
     public int getMeple() {
     Random aleatorio = new Random();
     this.meple = aleatorio.nextInt(2) + 1;
     return this.meple;
     }
     public int getNave() {
     Random aleatorio = new Random();
     this.nave = aleatorio.nextInt(2) + 1;
     return this.nave;
     }
     public int getPuntos() {
     Random aleatorio = new Random();
     this.puntos = aleatorio.nextInt(2) + 1;
     return this.puntos;
     }
     */
}