package com.yi.Manage;
import com.yi.Interact.*;
import com.yi.Logic.Ai.AI;
import com.yi.Logic.Data;
import com.yi.Manage.Net.NetInitUi;
import com.yi.Manage.Net.Read;
import com.yi.Manage.Net.Write;
import com.yi.base.Schema;
import com.yi.base.chessPiecs;
import com.yi.base.who;
public class Mange implements Click ,Read{
    private int X,Y;//棋盘大小
    private AI ai;
    private Write write;//联网模式下发送数据到对面棋盘管理对象里
    private Data data;
    private who whoNew;//目前是谁下
    private ecptoma down;//棋盘
    private Schema schema;//游戏模式
    public Mange(int x,int y,Schema tem){//初始化内部对象
        this.Y=y;
        this.X=x;
        schema=tem;
        if (this.schema.equals(Schema.PvP)){//判断游戏模式是不是PVP
            data=new Data(this.X,this.Y);//本地保存棋子数据
            down=new ChessBoard(this.X,this.Y,this);//棋盘
            whoNew=who.me;
        }else if (this.schema.equals(Schema.line)){//判断游戏模式是不是联网模式
            new NetInitUi(this.X,this.Y,this);//进入联网模式配置
        }else if (this.schema.equals(Schema.Ai)){//判断游戏模式是不是Ai模式
            ai=new AI(this.X,this.Y);//Ai  对象
            data=new Data(this.X,this.Y);//本地保存棋子数据
            down=new ChessBoard(this.X,this.Y,this);//棋盘
        }
    }
    public void Click(int x, int y) {//下棋时调用函数，判断进入那个模式函数
        if (schema==Schema.PvP){
            PvP(x, y);
        }
        else if (schema==Schema.Ai){
            Ai(x,y);
        }
        else if (schema==Schema.line){
            line(x,y);
        }
    }
    private void PvP(int x,int y)  {//PVP模式的逻辑处理函数
        boolean t=false;
        if (whoNew==who.me){
            t=data.judge(x,y,chessPiecs.me);
            down.dowm(x,y, chessPiecs.me);
            whoNew=who.other;
            if (t){
                new WinUi(who.me);
                ((ChessBoard) this.down).closeWin();
            }
        }else if (whoNew==who.other){
            System.out.println();
            t=data.judge(x,y,chessPiecs.other);
            down.dowm(x,y, chessPiecs.other);
            whoNew=who.me;
            if (t){
                new WinUi(who.other);
                ((ChessBoard) this.down).closeWin();
            }
        }
    }
    private void Ai(int x,int y){//人机对战函数
        boolean t=data.judge(x,y,chessPiecs.me);
        down.dowm(x,y, chessPiecs.me);
        if (t){
            new WinUi(who.me);
            ((ChessBoard) this.down).closeWin();
        }
        int temAixy[]=ai.getAIdown(x,y);
        t=data.judge(temAixy[0],temAixy[1],chessPiecs.other);
        down.dowm(temAixy[0],temAixy[1], chessPiecs.other);
        if (t){
            new WinUi(who.other);
            ((ChessBoard) this.down).closeWin();
        }
    }
    private void line(int x,int y){//联网对战函数
        boolean t=false;
        if (whoNew.equals(who.me)){
            write.write(x,y);
            t=data.judge(x,y,chessPiecs.me);
            down.dowm(x,y, chessPiecs.me);
            if (t){
                new WinUi(who.me);
                ((ChessBoard) this.down).closeWin();
           }
            whoNew=who.other;
        }
    }
    public void Read(int x,int y) {//联网模式下的将对面的棋显示在自己的棋盘上
        boolean t=false;
        if (whoNew.equals(who.other)){
            t=data.judge(x,y,chessPiecs.other);
            down.dowm(x,y, chessPiecs.other);
            if (t){
                new WinUi(who.other);
                ((ChessBoard) this.down).closeWin();
            }
            whoNew=who.me;
        }
    }

    public int getX() { return X; }
    public int getY() { return Y; }
    public void setX(int x) { X = x; }
    public void setY(int y) { Y = y; }
    public void setData(Data data) { this.data = data; }
    public void setDown(ecptoma down) { this.down = down; }
    public  who getWhoNew() { return this.whoNew; }
    public void setWhoNew(who whoNew) { this.whoNew = whoNew; }
    public void setWrite(Write write) { this.write = write; }
}
