package Actividad2;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author aleag
 */
public class cadenas {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de cadenas a generar: ");
        int cantidadCadenas = scanner.nextInt();
        Random rand = new Random();

        for (int i = 0; i < cantidadCadenas; i++) {
            int longitud = rand.nextInt(20) + 1; // Generar una longitud aleatoria entre 1 y 20
            StringBuilder cadena = new StringBuilder();

            for (int j = 0; j < longitud; j++) {
                char letra = (char) (rand.nextInt(26) + 'a'); // Generar una letra aleatoria
                cadena.append(letra);
            }

            System.out.println(cadena.toString());
        }

        scanner.close();
    }
}


