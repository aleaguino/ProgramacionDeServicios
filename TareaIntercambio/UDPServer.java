package TareaIntercambio;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        final int serverPort = 12345;

        try (DatagramSocket serverSocket = new DatagramSocket(serverPort)) {
            System.out.println("Server listening on port " + serverPort);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Received from client: " + message);

                if (message.equals("*")) {
                    break;
                }

                String response = message.toUpperCase();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                serverSocket.send(sendPacket);
            }

            System.out.println("Server shutting down.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
