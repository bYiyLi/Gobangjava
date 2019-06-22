package com.yi.Mange.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Clien {
    private String Address;
    private int Port;
    private PrintWriter printWriter;
    private BufferedReader InputReader;
    private BufferedReader  OutputReader;
    private ServerSocket serverSocket;
    private Socket socket;
    public Clien(String Address,int Port){
        this.Address=Address;
        this.Port=Port;
        Connect();
    }
    private void Connect(){
        try {
            socket=new Socket(this.Address,this.Port);
            printWriter.println();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
