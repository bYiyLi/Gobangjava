package com.yi.Interact;
import com.yi.base.who;
import javax.swing.*;
import java.awt.event.*;
public class WinUi implements ActionListener{
    private JFrame jFrame;
    ImageIcon image=null;
    JButton jbutton;
    public WinUi(who winner){
        if (winner==who.me){
            image= new ImageIcon("src/main/resources/image1.png");
        }else if (winner==who.other) {
            image = new ImageIcon("src/main/resources/image0.png");
        }
        this.jFrame=new JFrame("赢家是：");
        this.jFrame.setSize(200,200);
        jbutton=new JButton();
        jbutton.setIcon(image);
        jbutton.setBounds(0,0,200,200);
        jbutton.addActionListener(this);
        this.jFrame.setLayout(null);
        this.jFrame.add(jbutton);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {

        try {
            this.jFrame.setTitle("游戏结束");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.jFrame.dispose();
    }
}
