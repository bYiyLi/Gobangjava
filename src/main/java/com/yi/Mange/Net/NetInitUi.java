package com.yi.Mange.Net;
import com.yi.Mange.Mange;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
public class NetInitUi  extends Thread implements ActionListener{
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
    public NetInitUi(int x, int y, Mange tem){
        this.X=x;
        this.Y=y;
        this.mange=tem;
        InitJFame();
    }
    private void InitJFame(){
        this.jFrame=new JFrame("Net");
        this.jFrame.setSize(600,400);
        this.jFrame.setLayout(null);
        this.Address=new JTextField();
        this.Port=new JTextField();
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
    public void actionPerformed(ActionEvent e) {
        this.start();
        this.jFrame.dispose();
    }
    @Override
    public void run() {
        super.run();
        Enumeration<AbstractButton> tem = InitJoin.getElements();
        while (tem.hasMoreElements()) {
            AbstractButton radioButton = tem.nextElement();
            if (radioButton.isSelected()){
                if (radioButton.getText().equals("创建房间")){
                    new Server(Integer.valueOf(this.Port.getText()),this.mange);
                }
                if(radioButton.getText().equals("加入房间")){
                    new Clien(this.Address.getText(),Integer.valueOf(this.Port.getText()),this.mange);
                }
            }
        }
    }
}
