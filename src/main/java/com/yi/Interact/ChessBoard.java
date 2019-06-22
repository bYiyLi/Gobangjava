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
    private int W,H;
    private int MouseNowX,MouseNowY;
    volatile private chessPiecs PiecsN[][];
    private Click click;
    private JFrame jFrame;
    Image imageMe=null,imageOther=null,image0=null;
    public ChessBoard(int w,int h,Click click){
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
    private void initjframe(){
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
    public void dowm(int x, int y,chessPiecs tem) {
        if(x<=this.W&&x>=0&&y>=0&&y<=this.H)
        {
            PiecsN[x][y]=tem;
            this.repaint();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int tem = 0; tem <= this.W; tem++) {
            g.drawLine(50 + tem * 40, 50, 50 + tem * 40, 50 + this.H * 40);
        }
        for (int tem = 0; tem <= this.H; tem++) {
            g.drawLine(50, 50 + tem * 40, 50 + this.H * 40, 50 + tem * 40);
        }
        for (int temW = 0; temW <= this.W; temW++) {
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
    public void mouseClicked(MouseEvent e) {
        if(this.MouseNowY>=0&&this.MouseNowY<=this.H&&this.MouseNowX>=0&&this.MouseNowX<=this.W) {
            click.Click(this.MouseNowX, this.MouseNowY);
            System.out.println(this.MouseNowX+"  "+this.MouseNowY);
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) {
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
