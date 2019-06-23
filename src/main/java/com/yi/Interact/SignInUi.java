package com.yi.Interact;
import com.yi.Mange.Mange;
import com.yi.base.Schema;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
public class SignInUi implements ActionListener{
    private JRadioButton Simple9;
    private JRadioButton Commonly12;
    private JRadioButton Difficulty18;
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
        this.jFrame.add(this.Simple9);
        this.jFrame.add(this.Commonly12);
        this.jFrame.add(this.Difficulty18);
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
        this.Simple9=new JRadioButton("12X12");
        this.Commonly12=new JRadioButton("16X16",true);
        this.Difficulty18=new JRadioButton("18X18");
        this.Pattern=new ButtonGroup();
        this.Pattern.add(this.Simple9);
        this.Pattern.add(this.Commonly12);
        this.Pattern.add(this.Difficulty18);
        this.Simple9.setBounds(50,300,100,50);
        this.Commonly12.setBounds(250,300,100,50);
        this.Difficulty18.setBounds(450,300,100,50);
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
        int temX=0;
        int temY = 0;
        Schema schema = Schema.PvP;
        Enumeration<AbstractButton> enu1 = Pattern.getElements();
        while (enu1.hasMoreElements()) {
            AbstractButton radioButton = enu1.nextElement();
            if (radioButton.isSelected()){
                if ("12X12".equals(radioButton.getText())) {
                    temX=temY=12;

                }if ("16X16".equals(radioButton.getText())) {
                    temX=temY=16;
                }
                if ("18X18".equals(radioButton.getText())) {
                    temX=temY=18;
                }
            }
        }
        Enumeration<AbstractButton> enu2 = TypeGame.getElements();
        while (enu2.hasMoreElements()) {
            AbstractButton radioButton = enu2.nextElement();
            if (radioButton.isSelected()){
                if ("对战".equals(radioButton.getText())) {
                    schema=Schema.PvP;

                }if ("联机".equals(radioButton.getText())) {
                    schema=Schema.line;
                }
                if ("单机".equals(radioButton.getText())) {
                    schema=Schema.Ai;
                }
            }
        }
        new Mange(temX,temY,schema);
    }
}
