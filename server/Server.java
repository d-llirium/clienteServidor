package server;

import java.net.ServerSocket;
import java.net.Socket;

// aplicação Servidor
public class Server { // cada vez que se roda abre um novo servidor
    public static void main(String[] args) {
        final int PORT = 12345;
        ServerSocket serverSocket;
        Socket clientSocket = null;

        // criar o socket e fazer bind 
        try { // tratar excessão
            serverSocket = new ServerSocket(PORT); 
        } catch (Exception e) {
            System.out.println("porta " + PORT + " já está em uso.");
            return; // para o código
        }

        // aguardar pedido de conexão (listen)
        try {
            System.out.println("Aguardando pedido de conexão...");
            clientSocket = serverSocket.accept(); // para e fica esperando a conexão... RETORNA o client socket
            System.out.println("Conectado com " + clientSocket.getInetAddress().getHostAddress());
        } catch (Exception e) {
            System.out.println("Erro na conexão...");
            System.out.println(e.getMessage());
        }
        // fase da comunicação = troca de dados
        // fase de encerramento da conexão
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}