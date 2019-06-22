package com.yi.Interact.NetUi;

import javax.swing.*;

public class NetLineUi {
    private JFrame jFrame;
    public NetLineUi(){
        this.jFrame=new JFrame("Net");
        this.jFrame.setSize(600,400);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
