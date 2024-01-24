package TareaIntercambio;

/**
 *
 * @author aleag
 */
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        final String serverHost = "localhost";
        final int serverPort = 12345;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(serverHost);
            Scanner scanner = new Scanner(System.in);

            System.out.println("UDP Client started. Type a message to send, or '*' to exit.");

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();

                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

                clientSocket.send(sendPacket);

                if (message.equals("*")) {
                    break;
                }

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Received from server: " + response);
            }

            System.out.println("Client shutting down.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
