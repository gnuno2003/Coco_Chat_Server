/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coco_chat_server;

import java.io.IOException;
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

            c.getOutputStream().write('0');
            int dato = c.getInputStream().read();
            
            System.out.println(dato);
        } catch (IOException ex) {
            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}