package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// aplicação Cliente
public class Client {
    public static void main(String[] args) {
        final String IP = "127.0.0.1"; //IP que se refere a proópria máquina, como o THIS
        final int PORT = 12345; // precisa ser o mesmo número da porta do servidor
        Socket socket;
        PrintStream output = null;
        Scanner input = null;

        // criação do socket a pedido de conexão
        try {
            socket = new Socket(IP, PORT);
        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao servidor");
            return;
        }

        // fase de comunicação , troca de dados
        try {
            output = new PrintStream(socket.getOutputStream()); // para escrever para o servidor
            input = new Scanner(socket.getInputStream()); // para ler a mensagem do servidor
            output.println("Boa noite SERVIDOR <3");
            String msg = input.nextLine(); // recebe a msg do input
            System.out.println("Recebido: " + msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // fase de encerramento da conexão
        try {
            output.close();
            socket.close();
            System.out.println("Acabou a conexão do CLIENTE");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
