package com.yi.Interact;
import com.yi.base.chessPiecs;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
public class ChessBoard extends JPanel implements ecptoma ,MouseListener, MouseMotionListener {
    private int W,H;//棋盘大小
    private int MouseNowX,MouseNowY;//鼠标所在位置
    volatile private chessPiecs PiecsN[][];//棋子数据
    private Click click;
    private JFrame jFrame;
    Image imageMe=null,imageOther=null,image0=null;//棋子图片
    public ChessBoard(int w,int h,Click click){//初始化对象
        this.click=click;
        this.H=h-1;
        this.W=w-1;
        this.MouseNowX=-1;
        this.MouseNowY=-1;
        PiecsN=new chessPiecs[w][h];
        for (int temW=0;temW<w;temW++){
            for (int temH=0;temH<h;temH++){
                PiecsN[temW][temH]=chessPiecs.no;
            }
        }
        try {
            image0=ImageIO.read(new File("src/main/resources/image.png"));
            imageMe= ImageIO.read(new File("src/main/resources/image1.png"));
            imageOther= ImageIO.read(new File("src/main/resources/image0.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        initjframe();
    }
    private void initjframe(){//初始化窗口
        this.jFrame=new JFrame(" ");
        this.jFrame.setSize(this.W*40+100,this.H*40+100+30);
        this.jFrame.add(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.repaint();
    }
    public void dowm(int x, int y,chessPiecs tem) {//当自己的Mange对象调用这个函数把传进来的棋子位置数据保存下来
        if(x<=this.W&&x>=0&&y>=0&&y<=this.H)
        {
            PiecsN[x][y]=tem;
            this.repaint();
        }
    }
    public void closeWin(){ this.jFrame.dispose(); }//游戏结束关闭窗口
    @Override
    public void paint(Graphics g) {//把棋子数据显示在棋盘上
        super.paint(g);
        for (int tem = 0; tem <= this.W; tem++) {//显示棋盘
            g.drawLine(50 + tem * 40, 50, 50 + tem * 40, 50 + this.H * 40);
        }
        for (int tem = 0; tem <= this.H; tem++) {//显示棋盘
            g.drawLine(50, 50 + tem * 40, 50 + this.H * 40, 50 + tem * 40);
        }
        for (int temW = 0; temW <= this.W; temW++) {//显示棋子
            for (int temH = 0; temH <= this.H; temH++) {
                if (PiecsN[temW][temH] == chessPiecs.no) {
                    if (this.MouseNowX >= 0 && this.MouseNowX <= this.W && this.MouseNowY <= this.H && this.MouseNowY >= 0) {
                        g.drawImage(image0, 50 - 20 + this.MouseNowX * 40, 50 - 20 + this.MouseNowY * 40, 40, 40, null);
                    }
                 }
                if (PiecsN[temW][temH] == chessPiecs.me) {
                    g.drawImage(imageMe, 50 - 20 + temW * 40, 50 - 20 + temH * 40, 40, 40, null);
                }
                if (PiecsN[temW][temH] == chessPiecs.other) {
                    g.drawImage(imageOther, 50 - 20 + temW * 40, 50 - 20 + temH * 40, 40, 40, null);
                }
            }
        }
    }
    public void mouseClicked(MouseEvent e) {//鼠标点击下在那把棋位置数据传给Mange对象
        if(this.MouseNowY>=0&&this.MouseNowY<=this.H&&this.MouseNowX>=0&&this.MouseNowX<=this.W) {
            click.Click(this.MouseNowX, this.MouseNowY);
        }
    }
    public void mousePressed(MouseEvent e) { }//没用，但是不能删除，
    public void mouseReleased(MouseEvent e) { }//没用，但是不能删除，
    public void mouseEntered(MouseEvent e) { }//没用，但是不能删除，
    public void mouseExited(MouseEvent e) { }//没用，但是不能删除，
    public void mouseDragged(MouseEvent e) { }//没用，但是不能删除，
    public void mouseMoved(MouseEvent e) {//鼠标移动时把鼠标的位置传给 private int MouseNowX,MouseNowY;//鼠标所在位置
        int temX=(e.getX()-10)/40;
        if ((e.getX()-10)%40<20){
            temX--;
        }
        int temY=(e.getY()-10)/40;
        if ((e.getY()-10)%40<20) {
            temY--;
        }
        if (temX >= 0 && temX <= this.W && temY <= this.H && temY >= 0) {
            if (this.MouseNowX==temX&&this.MouseNowY==temY){ }else {
                if (this.PiecsN[temX][temY] == chessPiecs.no) {
                    this.MouseNowX = temX;
                    this.MouseNowY = temY;
                    this.repaint();
                } else {
                    this.MouseNowX = -1;
                    this.MouseNowY = -1;
                }
            }
        }
    }
}
