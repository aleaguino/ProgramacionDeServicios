// TCPejemplo1Cliente.java

import java.io.*;
import java.net.*;

class TCPejemplo1Cliente {
    public static void main(String argv[]) throws Exception {
        String mensajeAServidor;
        String mensajeDesdeServidor;

        BufferedReader entradaDesdeUsuario = new BufferedReader(new InputStreamReader(System.in));

        Socket clienteSocket = new Socket("localhost", 6789);

        DataOutputStream haciaServidor = new DataOutputStream(clienteSocket.getOutputStream());
        BufferedReader desdeServidor = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

        System.out.println("Escribe un mensaje para el servidor (* para salir):");

        while (true) {
            mensajeAServidor = entradaDesdeUsuario.readLine();

            haciaServidor.writeBytes(mensajeAServidor + '\n');

            if (mensajeAServidor.equals("*")) {
                break;
            }

            mensajeDesdeServidor = desdeServidor.readLine();
            System.out.println("Del Servidor: " + mensajeDesdeServidor);
        }

        clienteSocket.close();
    }
}
