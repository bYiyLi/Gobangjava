package com.yi.Interact;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class SignInUi implements ActionListener{
    private JRadioButton Simple;
    private JRadioButton Commonly;
    private JRadioButton Difficulty;
    private ButtonGroup Pattern;
    private ButtonGroup TypeGame;
    private JRadioButton standAlone;
    private JRadioButton PvP;
    private JRadioButton onLine;
    private JFrame jFrame;
    private JButton SignInButton;
    public SignInUi(){
        initJframe();
    }
    private void initJframe(){
        this.jFrame=new JFrame("欢迎界面");
        this.jFrame.setSize(600,400);
        this.jFrame.setLayout(null);
        initButton();
        this.jFrame.add(this.Simple);
        this.jFrame.add(this.Commonly);
        this.jFrame.add(this.Difficulty);
        this.jFrame.add(this.PvP);
        this.jFrame.add(this.onLine);
        this.jFrame.add(this.standAlone);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initButton(){
        this.SignInButton=new JButton("进入游戏");
        this.SignInButton.addActionListener(this);
        this.SignInButton.setBounds(120,240,320,50);
        this.jFrame.add(this.SignInButton);
        this.Simple=new JRadioButton("9X9");
        this.Commonly=new JRadioButton("12X12",true);
        this.Difficulty=new JRadioButton("18X18");
        this.Pattern=new ButtonGroup();
        this.Pattern.add(this.Simple);
        this.Pattern.add(this.Commonly);
        this.Pattern.add(this.Difficulty);
        this.Simple.setBounds(50,300,100,50);
        this.Commonly.setBounds(250,300,100,50);
        this.Difficulty.setBounds(450,300,100,50);
        this.TypeGame=new ButtonGroup();
        this.onLine=new JRadioButton("联机");
        this.PvP=new JRadioButton("对战",true);
        this.standAlone=new JRadioButton("单机");
        this.TypeGame.add(this.PvP);
        this.TypeGame.add(this.onLine);
        this.TypeGame.add(this.standAlone);
        this.standAlone.setBounds(100,180,100,50);
        this.PvP.setBounds(250,180,100,50);
        this.onLine.setBounds(400,180,100,50);
    }
    public void actionPerformed(ActionEvent e) {
        Enumeration<AbstractButton> enu1 = Pattern.getElements();
        while (enu1.hasMoreElements()) {
            AbstractButton radioButton = enu1.nextElement();
            System.out.println(radioButton.getText()+ " : "
                    + radioButton.isSelected());
        }
        Enumeration<AbstractButton> enu2 = TypeGame.getElements();
        while (enu2.hasMoreElements()) {
            AbstractButton radioButton = enu2.nextElement();
            System.out.println(radioButton.getText()+ " : "
                    + radioButton.isSelected());
        }
        System.out.println(this.TypeGame.getElements()+"++++++++++++");
    }
}
