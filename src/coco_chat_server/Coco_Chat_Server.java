package coco_chat_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import db_conection_package.Db_Conection;

public class Coco_Chat_Server {

    public static void main(String[] args){  
        try {
            ServerSocket ss = new ServerSocket(1234);
            
            System.out.println("Esperando...");
            while (true) {
                Socket c = ss.accept();
                
                System.out.println("Conexion recibida");
                System.out.println("Client connected: " + c.getInetAddress().getHostAddress());

                //Leer datos enviados por el cliente

                c.getOutputStream().write('0');
                int dato = c.getInputStream().read();

                System.out.println(dato);
            }
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}