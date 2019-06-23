package com.yi.Mange.Net;
import com.yi.Interact.ChessBoard;
import com.yi.Logic.Data;
import com.yi.Mange.Mange;
import com.yi.base.who;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server extends Thread implements Write{
    private Mange mange;
    private int Port;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ServerSocket serverSocket;
    private Socket socket;
    public Server(int Port,Mange mange){
        this.Port=Port;
        this.mange=mange;
        this.mange.setWrite(this);
        Listener();
    }
    private void Listener(){
        try {
            this.serverSocket=new ServerSocket(this.Port);
            socket = this.serverSocket.accept();
            System.out.println("开始联机");
            inputStream = socket.getInputStream();
            outputStream=socket.getOutputStream();
            byte []tem=(String.valueOf(this.mange.getX())+String.valueOf(this.mange.getY())).getBytes();
            outputStream.write(tem);
            this.mange.setData(new Data(this.mange.getX(),this.mange.getY()));
            this.mange.setDown(new ChessBoard(this.mange.getX(),this.mange.getY(),this.mange));
            this.mange.setWhoNew(who.me);
        } catch (IOException e) {
        }
        this.start();
    }
    @Override
    public void run() {
        super.run();
        while (true){
            if (this.mange.getWhoNew().equals(who.other)){
                boolean t=false;
                try {
                    byte []tem = new byte[6];
                    this.inputStream.read(tem);
                    String a[]= new String(tem).split(",");
                    this.mange.Read(Integer.valueOf(a[0]),Integer.valueOf(a[1]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void write(int x, int y) {
        try {
            String tem=String.valueOf(x)+","+String.valueOf(y)+",";
            this.outputStream.write(tem.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
