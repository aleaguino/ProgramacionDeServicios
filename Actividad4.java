
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleag
 */
public class Actividad4 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
            Process notepadProcess = processBuilder.start();

            boolean isProcessAlive = notepadProcess.isAlive();
            System.out.println("El proceso del Bloc de notas está en ejecución: " + isProcessAlive);

            Thread.sleep(20000);

            isProcessAlive = notepadProcess.isAlive();
            System.out.println("Después de esperar 20 segundos, el proceso del Bloc de notas está en ejecución: " + isProcessAlive);

            notepadProcess.destroy();

            isProcessAlive = notepadProcess.isAlive();
            System.out.println("Después de destruir el proceso, el proceso del Bloc de notas está en ejecución: " + isProcessAlive);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


