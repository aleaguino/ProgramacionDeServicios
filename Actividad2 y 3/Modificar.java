package Actividad2;

/**
 *
 * @author aleag
 */
public class Modificar {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String cadenaGenerada = cadenas.generarCadena();

            int recuentoVocales = frecuencia.frecuenciaVocales(cadenaGenerada);

            System.out.println("Cadena generada: " + cadenaGenerada);
            System.out.println("Recuento de vocales: " + recuentoVocales);
        }
    }
}

}
