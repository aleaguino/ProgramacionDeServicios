package FinalTCP;

/**
 *
 * @author aleag
 */
import java.io.*;
import java.net.*;

import java.util.Scanner;

public class TCPDadosCliente {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private int maxRounds = 3;

    public void startConnection(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < maxRounds; i++) {
                System.out.print("Ingrese su predicción (suma de dos dados): ");
                int prediction = scanner.nextInt();
                out.println(prediction);

                int serverResult = Integer.parseInt(in.readLine());
                System.out.println("Servidor: " + serverResult);
            }

            String finalResults = in.readLine();
            System.out.println("Resultados finales: " + finalResults);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPDadosCliente client = new TCPDadosCliente();
        client.startConnection("127.0.0.1", 65432); // Dirección IP y puerto del servidor
    }
}
