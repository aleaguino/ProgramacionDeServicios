package Acvtividad2_5;

/**
 *
 * @author aleag
 */
public class Main {
    public static void main(String[] args) {
        ColaSincronizada cola = new ColaSincronizada();

        Thread productorThread = new Thread(new Productor(cola));
        Thread consumidorThread = new Thread(new Consumidor(cola));

        productorThread.start();
        consumidorThread.start();
    }
}
