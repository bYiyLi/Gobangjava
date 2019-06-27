package com.yi.Interact;
import com.yi.Manage.Mange;
import com.yi.base.Schema;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
public class SignInUi implements ActionListener{
    private JRadioButton Simple9;//12X12
    private JRadioButton Commonly12;//16X16
    private JRadioButton Difficulty18;//18X18
    private ButtonGroup Pattern;//
    private ButtonGroup TypeGame;//游戏模式管理保证只有点击一个模式
    private JRadioButton standAlone;//ai单机模式
    private JRadioButton PvP;//PVP  模式
    private JRadioButton onLine;//联网模式
    private JFrame jFrame;//窗口
    private JButton SignInButton;//按钮
    public SignInUi(){ initJframe(); }
    private void initJframe(){//初始化选择窗口
        this.jFrame=new JFrame("欢迎界面");
        this.jFrame.setSize(600,400);
        this.jFrame.setLayout(null);
       // ImageIcon imageIconBj=new ImageIcon("src/main/resources/gobangInit.jpg");
       // JLabel jLabel=new JLabel(imageIconBj);
       // jLabel.setBounds(0,0,600,400);
      //  this.jFrame.add(jLabel);
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
    private void initButton(){//初始化窗口里的布局
        this.SignInButton=new JButton("进入游戏");
      //  this.SignInButton.setIcon(new ImageIcon("src/main/resources/gotoGame.jpg"));
        this.SignInButton.addActionListener(this);
        this.SignInButton.setBounds(120,240,320,50);
        this.SignInButton.setBorderPainted(false);
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
    public void actionPerformed(ActionEvent e) {//点击进入游戏后的要new那个对象
        int temX=0,temY = 0;
        Schema schema = Schema.PvP;
        Enumeration<AbstractButton> enu1 = Pattern.getElements();
        while (enu1.hasMoreElements()) {//判断选择那个大小
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
        while (enu2.hasMoreElements()) {//判断选择那种类型
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
        new Mange(temX,temY,schema);//new 管理对象
    }

    public static void main(String[] args) {
        new SignInUi();
    }
}
