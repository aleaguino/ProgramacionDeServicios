package Actividad2_0;

/**
 *
 * @author aleag
 */
public class HolaMundoHilos extends Thread{

    public void run() {
        System.out.println("Hola Mundo desde el hilo " + Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        // Creamos y ejecutamos 5 hilos
        for (int i = 0; i < 5; i++) {
            HolaMundoHilos hilo = new HolaMundoHilos();
            hilo.start();
        }
    }
    
}
