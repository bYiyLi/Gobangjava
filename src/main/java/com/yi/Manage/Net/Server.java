package com.yi.Manage.Net;
import com.yi.Interact.ChessBoard;
import com.yi.Logic.Data;
import com.yi.Manage.Mange;
import com.yi.base.who;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server extends Thread implements Write{
    private Mange mange;//管理对象
    private int Port;//端口号
    private InputStream inputStream;//联网模式下输入数据
    private OutputStream outputStream;//联网模式下棋子输出数据
    private ServerSocket serverSocket;
    private Socket socket;
    public Server(int Port,Mange mange){//初始化
        this.Port=Port;
        this.mange=mange;
        this.mange.setWrite(this);
        Listener();
    }
    private void Listener(){//监听输入的端口
        try {
            this.serverSocket=new ServerSocket(this.Port);
            socket = this.serverSocket.accept();//监听端口等待联机
            System.out.println("开始联机");
            inputStream = socket.getInputStream();
            outputStream=socket.getOutputStream();
            byte []tem=(String.valueOf(this.mange.getX())+String.valueOf(this.mange.getY())).getBytes();
            outputStream.write(tem);//发送自己棋盘大小给客服端
            this.mange.setData(new Data(this.mange.getX(),this.mange.getY()));//初始化数据对象
            this.mange.setDown(new ChessBoard(this.mange.getX(),this.mange.getY(),this.mange));//初始化棋盘调用对象
            this.mange.setWhoNew(who.me);//设置谁先下
        } catch (IOException e) { }
        this.start();//开启线程
    }
    @Override
    public void run() {
        super.run();
        while (true){
            if (this.mange.getWhoNew().equals(who.other)){//对面下时读取他给我的数据
                boolean t=false;
                try {
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
    public void write(int x, int y) {//当自己落子时，发送数据给对面
        try {
            String tem=String.valueOf(x)+","+String.valueOf(y)+",";
            this.outputStream.write(tem.getBytes());
        } catch (IOException e) { e.printStackTrace(); }
    }
}
