package client;

import java.net.Socket;

// aplicação Cliente
public class Client {
    public static void main(String[] args) {
        final String IP = "127.0.0.1"; //IP que se refere a proópria máquina, como o THIS
        final int PORT = 12345; // precisa ser o mesmo número da porta do servidor
        Socket socket;

        // criação do socket a pedido de conexão
        try {
            socket = new Socket(IP, PORT);
        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao servidor");
            return;
        }

        // fase de comunicação , troca de dados

        // fase de encerramento da conexão
        try {
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
