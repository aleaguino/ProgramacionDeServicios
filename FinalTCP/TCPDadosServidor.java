package FinalTCP;

/**
 *
 * @author aleag
 */

import java.io.*;
import java.net.*;
import java.util.Random;

public class TCPDadosServidor {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private int maxRounds = 3;
    private int roundsWonByServer = 0;
    private int roundsWonByClient = 0;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando conexiones...");
            clientSocket = serverSocket.accept();
            System.out.println("Conexión establecida con el cliente.");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            for (int i = 0; i < maxRounds; i++) {
                int serverResult = rollDice();
                out.println(serverResult);

                int clientResult = Integer.parseInt(in.readLine());
                System.out.println("Servidor: " + serverResult + ", Cliente: " + clientResult);

                if (serverResult > clientResult) {
                    roundsWonByServer++;
                } else if (clientResult > serverResult) {
                    roundsWonByClient++;
                }
            }

            String finalResults = "Servidor: " + roundsWonByServer + ", Cliente: " + roundsWonByClient;
            out.println(finalResults);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + rand.nextInt(6) + 2; // Suma de dos dados de 1 a 6
    }

    public static void main(String[] args) {
        TCPDadosServidor server = new TCPDadosServidor();
        server.start(65432); // Puerto de conexión
    }
}

