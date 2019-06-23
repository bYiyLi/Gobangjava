package com.yi.Mange.Net;
import com.yi.Interact.ChessBoard;
import com.yi.Logic.Data;
import com.yi.Mange.Mange;
import com.yi.base.who;
import java.io.*;
import java.net.Socket;
public class Clien  extends Thread implements Write{
    private Mange mange;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    public Clien(String Address, int Port, Mange mange){
        this.mange=mange;
        this.mange.setWrite(this);
        Connect();
    }
    private void Connect(){
        try {
            socket=new Socket("127.0.1.1",1472);
            inputStream=socket.getInputStream();
            byte []tem = new byte[4];
            inputStream.read(tem);
            inputStream = socket.getInputStream();
            outputStream=socket.getOutputStream();
            this.mange.setX(Integer.valueOf(new String(tem,0,2)));
            this.mange.setY(Integer.valueOf(new String(tem,2,2)));
            this.mange.setData(new Data(this.mange.getX(),this.mange.getY()));
            this.mange.setDown(new ChessBoard(this.mange.getX(),this.mange.getY(),this.mange));
            this.mange.setWhoNew(who.other);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("------------------------");
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
                    System.out.println();
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
