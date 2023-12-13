// TCPejemplo1Servidor.java

import java.io.*;
import java.net.*;

class TCPejemplo1Servidor {
    public static void main(String argv[]) throws Exception {
        String mensajeCliente;
        String mensajeMayusculas;

        ServerSocket socketServidor = new ServerSocket(6789);

        while (true) {
            Socket conexionSocket = socketServidor.accept();

            BufferedReader desdeCliente = new BufferedReader(new InputStreamReader(conexionSocket.getInputStream()));
            DataOutputStream haciaCliente = new DataOutputStream(conexionSocket.getOutputStream());

            mensajeCliente = desdeCliente.readLine();

            if (mensajeCliente.equals("*")) {
                conexionSocket.close();
                break;
            }

            mensajeMayusculas = mensajeCliente.toUpperCase() + '\n';
            haciaCliente.writeBytes(mensajeMayusculas);
        }
    }
}
