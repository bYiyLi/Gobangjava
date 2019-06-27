package com.yi.Manage.Net;
import com.yi.Manage.Mange;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
public class NetInitUi  extends Thread implements ActionListener{//联网模式下才会创建的对象
    private Mange mange;
    private JFrame jFrame;
    private ButtonGroup InitJoin;
    private JRadioButton Init;
    private JRadioButton Join;
    private JTextField Address;
    private JTextField Port;
    private JButton InitJoinHome;
    private int X;
    private int Y;
    public NetInitUi(int x, int y, Mange tem){//初始化对象
        this.X=x;
        this.Y=y;
        this.mange=tem;
        InitJFame();
    }
    private void InitJFame(){//初始化联网模式下的选择窗口和里面的布局
        this.jFrame=new JFrame("Net");
        this.jFrame.setSize(600,400);
        this.jFrame.setLayout(null);
        this.Address=new JTextField("网络地址");
        this.Port=new JTextField("端口");
        this.Address.setBounds(200,100,200,40);
        this.Port.setBounds(200,160,200,40);
        this.jFrame.add(this.Address);
        this.jFrame.add(this.Port);
        this.InitJoinHome=new JButton("确认");
        this.InitJoinHome.addActionListener(this);
        this.InitJoinHome.setBounds(200,250,200,40);
        this.InitJoin=new ButtonGroup();
        this.Init=new JRadioButton("创建房间",true);
        this.Join=new JRadioButton("加入房间");
        this.InitJoin.add(this.Init);
        this.InitJoin.add(this.Join);
        this.Init.setBounds(150,200,100,40);
        this.Join.setBounds(400,200,100,40);
        this.jFrame.add(this.Init);
        this.jFrame.add(this.Join);
        this.jFrame.add(this.InitJoinHome);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {//点击开始时调用对象
        this.start();//线程开始
        this.jFrame.dispose();
    }
    @Override
    public void run() {
        super.run();
        Enumeration<AbstractButton> tem = InitJoin.getElements();
        while (tem.hasMoreElements()) {//获取联网模式下本机创建房间还是加入
            AbstractButton radioButton = tem.nextElement();
            if (radioButton.isSelected()){
                if (radioButton.getText().equals("创建房间")){
                    new Server(Integer.valueOf(this.Port.getText()),this.mange);//创建房间时new Server（服务器对象）
                }else if(radioButton.getText().equals("加入房间")){
                    new Clien(this.Address.getText(),Integer.valueOf(this.Port.getText()),this.mange);//加入房间new Clien（客服端）对象
                }
            }
        }
    }
}
