package pl.marcin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5000)){

            while(true){
                //code for multiuser managed by Threads:new Thread for every connection:
                new Echoer(serverSocket.accept()).start();
//                Another way of doing the same:
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();

                //code for one user only without Threads:
//                Socket socket = serverSocket.accept();
//                System.out.println("Client Connected");
//                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//                String echoString = input.readLine();
//                try{
//                    Thread.sleep(5000);
//                }catch (InterruptedException e){
//                    System.out.println("Thread interrupted");
//                }
//                if(echoString.equals("exit")){
//                    break;
//                }
//                output.println("Echo from server: " + echoString);
//                System.out.println(echoString);
            }
        }catch(IOException e){
            System.out.println("Server exception " + e.getMessage());

        }
    }
}