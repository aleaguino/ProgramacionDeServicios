package Actividad2_2;

/**
 *
 * @author aleag
 */
    public class HiloPin extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.print("PIN ");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
