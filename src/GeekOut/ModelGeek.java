package GeekOut;

public class ModelGeek {
    private Dado dado,dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10, dadoInactivo, dadoInactivo2, dadoInactivo3;
    private final int[] caras;
    private GUIGeek guiGeek;
    int puntos;

    public ModelGeek() {
        dado = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new  Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        dadoInactivo = new Dado();
        dadoInactivo2 = new Dado();
        dadoInactivo3 = new Dado();
        caras = new int[2];

    }
   /* public void determinarJuego(){
        if(guiGeek.)
    } */

    public void calcularTiro(){


    }


    public int[] getCaras() {
        return caras;
    }
}
