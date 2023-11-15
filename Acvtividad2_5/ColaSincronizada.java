package Acvtividad2_5;

import java.util.ArrayList;
import java.util.Random;

class ColaSincronizada {
    private ArrayList<Integer> contenedor = new ArrayList<>();
    private final int TAMANO_MAXIMO = 10;

    public synchronized void put(int valor) {
        try {
            while (contenedor.size() == TAMANO_MAXIMO) {
                wait();
            }
            contenedor.add(valor);
            System.out.println("Productor produce: " + valor);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized int get() {
        try {
            while (contenedor.isEmpty()) {
                wait();
            }
            int valor = contenedor.remove(0);
            System.out.println("Consumidor consume: " + valor);
            notify();
            return valor;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}

class Productor implements Runnable {
    private ColaSincronizada cola;

    public Productor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            cola.put(i);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumidor implements Runnable {
    private ColaSincronizada cola;

    public Consumidor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            cola.get();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
