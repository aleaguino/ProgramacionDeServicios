/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2_3;

/**
 *
 * @author aleag
 */
public class ContadorVocales{
    public static void main(String[] args) {
        String texto = "Este es un ejemplo de conteo de vocales en un texto";
        
        // Contadores para cada vocal y el total de vocales
        int contadorVocalA = 0;
        int contadorVocalE = 0;
        int contadorVocalI = 0;
        int contadorVocalO = 0;
        int contadorVocalU = 0;
        int cuentaTotalDeVocales = 0;
        
        // Dividir el texto en caracteres
        char[] caracteres = texto.toCharArray();
        
        // Crear 5 hilos para contar cada vocal
        Thread hiloA = new Thread(() -> {
            for (char c : caracteres) {
                if (c == 'a' || c == 'A') {
                    contadorVocalA++;
                    cuentaTotalDeVocales++;
                }
            }
        });
        
        Thread hiloE = new Thread(() -> {
            for (char c : caracteres) {
                if (c == 'e' || c == 'E') {
                    contadorVocalE++;
                    cuentaTotalDeVocales++;
                }
            }
        });
        
        Thread hiloI = new Thread(() -> {
            for (char c : caracteres) {
                if (c == 'i' || c == 'I') {
                    contadorVocalI++;
                    cuentaTotalDeVocales++;
                }
            }
        });
        
        Thread hiloO = new Thread(() -> {
            for (char c : caracteres) {
                if (c == 'o' || c == 'O') {
                    contadorVocalO++;
                    cuentaTotalDeVocales++;
                }
            }
        });
        
        Thread hiloU = new Thread(() -> {
            for (char c : caracteres) {
                if (c == 'u' || c == 'U') {
                    contadorVocalU++;
                    cuentaTotalDeVocales++;
                }
            }
        });
        
        // Iniciar los hilos
        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();
        
        // Esperar a que todos los hilos terminen
        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Mostrar resultados
        System.out.println("Vocal A: " + contadorVocalA);
        System.out.println("Vocal E: " + contadorVocalE);
        System.out.println("Vocal I: " + contadorVocalI);
        System.out.println("Vocal O: " + contadorVocalO);
        System.out.println("Vocal U: " + contadorVocalU);
        System.out.println("Cuenta total de vocales: " + cuentaTotalDeVocales);
    }
}



