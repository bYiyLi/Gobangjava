package com.yi.Mange.Net;

import javax.swing.*;

public class NetInitUi {
    private JFrame jFrame;
    private String LocalAddress;
    private String networkAddress;
    public NetInitUi(){
        this.jFrame=new JFrame("Net");
        this.jFrame.setSize(600,400);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
