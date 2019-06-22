package com.yi.Interact;

import javax.swing.*;

public class WinUi {
    private JFrame jFrame;
    WinUi(){
        this.jFrame=new JFrame(" ");
        this.jFrame.setSize(400,400);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
