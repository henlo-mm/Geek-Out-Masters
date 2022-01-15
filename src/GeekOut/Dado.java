package GeekOut;

import java.util.Random;

public class Dado {
    private int dragon;
    private int heroe;
    private int nave;
    private int corazon;
    private int puntos;
    private int meple;


        public int getCorazon(){
            Random aleatorio = new Random();
            this.corazon = aleatorio.nextInt(2) + 1;
            return this.corazon;
        }

        public int getDragon () {
            Random aleatorio = new Random();
            this.dragon = aleatorio.nextInt(2) + 1;
            return this.dragon;
        }

        public int getHeroe () {
            Random aleatorio = new Random();
            this.dragon = aleatorio.nextInt(2) + 1;
            return this.heroe;
        }

        public int getMeple () {
            Random aleatorio = new Random();
            this.meple = aleatorio.nextInt(2) + 1;
            return this.meple;
        }

        public int getNave () {
            Random aleatorio = new Random();
            this.nave = aleatorio.nextInt(2) + 1;
            return this.nave;
        }

        public int getPuntos () {
            Random aleatorio = new Random();
            this.puntos = aleatorio.nextInt(2) + 1;
            return this.puntos;

    }


}
