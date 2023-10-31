package Actividad2_1;

public class Fibonacci extends Thread {
    private int N;

    public Fibonacci(int N) {
        this.N = N;
    }

    @Override
    public void run() {
        int a = 1, b = 1;
        System.out.print("Sucesión de Fibonacci (primeros " + N + " números): ");
        for (int i = 0; i < N; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 10;
        Thread hilo = new Fibonacci(N);
        hilo.start();
    }
}
