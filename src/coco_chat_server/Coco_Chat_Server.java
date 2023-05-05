package coco_chat_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coco_Chat_Server {

    public static void main(String[] args){
        try {
            Socket c;
            ServerSocket ss = new ServerSocket(1234);

            System.out.println("Esperando...");
            c = ss.accept();
            System.out.println("Conexion recibida");

            BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(c.getOutputStream(), "UTF-8"), true);
            String mensaje = reader.readLine();

            writer.println(mensaje);
            System.out.println("El mensaje del cliente es: " + mensaje);

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}