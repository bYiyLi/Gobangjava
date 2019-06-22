package com.yi.Mange.Net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NetInitUi extends JPanel implements ActionListener{
    private JFrame jFrame;
    private ButtonGroup InitJoin;
    private JRadioButton Init;
    private JRadioButton Join;
    private String LocalAddress;
    private String networkAddress;
    private JTextField Address;
    private JTextField Port;
    public JButton InitJoinHome;
    public NetInitUi(){
        InitJFame();
    }
    private void InitJFame(){
        this.jFrame=new JFrame("Net");
        this.jFrame.setSize(600,400);
        this.jFrame.setLayout(null);
        this.Address=new JTextField("地址：");
        this.Port=new JTextField("端口：");
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
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
