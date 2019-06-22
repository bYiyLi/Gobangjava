package com.yi.Interact;

import javax.swing.*;

public class SignInUi {
    private JFrame jFrame;
    public SignInUi(){
        initJframe();
    }
    private void initJframe(){
        this.jFrame=new JFrame("欢迎界面");
        this.jFrame.setSize(600,400);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
