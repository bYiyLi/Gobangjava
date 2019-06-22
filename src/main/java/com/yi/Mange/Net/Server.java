package com.yi.Mange.Net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private String Address;
    private int Port;
    private BufferedReader InputReader;
    private BufferedReader  OutputReader;
    private ServerSocket serverSocket;
    private Socket socket;
    public Server(int Port){
        this.Port=Port;
        Listener();
    }
    private void Listener()  {
        try {
            serverSocket=new ServerSocket(this.Port);
            System.out.println("++++++++++++++++");
            socket=serverSocket.accept();
            InputReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(InputReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
