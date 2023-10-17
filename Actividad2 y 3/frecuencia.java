
package Actividad2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author aleag
 */ 
public class frecuencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un texto: ");
        String texto = scanner.nextLine().toLowerCase();

        Map<Character, Integer> frecuenciaVocales = new HashMap<>();
        frecuenciaVocales.put('a', 0);
        frecuenciaVocales.put('e', 0);
        frecuenciaVocales.put('i', 0);
        frecuenciaVocales.put('o', 0);
        frecuenciaVocales.put('u', 0);

        for (char letra : texto.toCharArray()) {
            if (frecuenciaVocales.containsKey(letra)) {
                frecuenciaVocales.put(letra, frecuenciaVocales.get(letra) + 1);
            }
        }

        for (char vocal : "aeiou".toCharArray()) {
            System.out.print(frecuenciaVocales.get(vocal) + " ");
        }

        scanner.close();
    }
}


