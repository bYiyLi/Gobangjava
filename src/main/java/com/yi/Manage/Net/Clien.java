package com.yi.Manage.Net;
import com.yi.Interact.ChessBoard;
import com.yi.Logic.Data;
import com.yi.Manage.Mange;
import com.yi.base.who;
import java.io.*;
import java.net.Socket;
public class Clien  extends Thread implements Write{
    private Mange mange;
    private Socket socket;
    private String Address;
    private int Port;
    private InputStream inputStream;
    private OutputStream outputStream;
    public Clien(String Address, int Port, Mange mange){//初始化对象
        this.Address=Address;
        this.Port=Port;
        this.mange=mange;
        this.mange.setWrite(this);
        Connect();
    }
    private void Connect(){//加入房间
        try {
            socket=new Socket(this.Address,this.Port);
            inputStream=socket.getInputStream();
            byte []tem = new byte[4];
            inputStream.read(tem);//读取服务器返回的棋盘大小
            inputStream = socket.getInputStream();
            outputStream=socket.getOutputStream();
            this.mange.setX(Integer.valueOf(new String(tem,0,2)));//设置棋盘大小
            this.mange.setY(Integer.valueOf(new String(tem,2,2)));//设置棋盘大小
            this.mange.setData(new Data(this.mange.getX(),this.mange.getY()));
            this.mange.setDown(new ChessBoard(this.mange.getX(),this.mange.getY(),this.mange));
            this.mange.setWhoNew(who.other);//设置对面先下
        } catch (IOException e) { e.printStackTrace(); }
        this.start();//开始线程
    }
    @Override
    public void run() {
        super.run();
        while (true){
            if (this.mange.getWhoNew().equals(who.other)){//接受对面的数据
                boolean t=false;
                try {
                    System.out.println();
                    byte []tem = new byte[6];
                    this.inputStream.read(tem);
                    String a[]= new String(tem).split(",");
                    this.mange.Read(Integer.valueOf(a[0]),Integer.valueOf(a[1]));
                } catch (IOException e) { e.printStackTrace(); }
            }else {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public void write(int x, int y) {//发送数据
        try {
            String tem=String.valueOf(x)+","+String.valueOf(y)+",";
            this.outputStream.write(tem.getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
