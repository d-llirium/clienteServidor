package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// aplicação Servidor
public class Server { // cada vez que se roda abre um novo servidor
    public static void main(String[] args) {
        final int PORT = 12345;
        ServerSocket serverSocket;
        Socket clientSocket = null;
        Scanner input = null;
        PrintStream output = null;

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
        try {
            input = new Scanner(clientSocket.getInputStream()); // para ler a mensagem do cliente
            output = new PrintStream(clientSocket.getOutputStream()); // para escrever mensagem para o cliente
            
            String msg = input.nextLine(); // recebe a msg do input
            System.out.println("Recebido: " + msg);
            output.println("Boa noite CLIENTE!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // fase de encerramento da conexão
        try {
            input.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Acabou a conexão do SERVIDOR");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}