package Actividad2_2;

/**
 *
 * @author aleag
 */
public class Main {
    public static void main(String[] args) {
        HiloPin hiloPin = new HiloPin();
        HiloPon hiloPon = new HiloPon();
        
        hiloPin.start();
        hiloPon.start();
    }
}
