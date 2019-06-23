package com.yi.Mange;
import com.yi.Interact.*;
import com.yi.Logic.Ai.AI;
import com.yi.Logic.Data;
import com.yi.Mange.Net.NetInitUi;
import com.yi.Mange.Net.Read;
import com.yi.Mange.Net.Write;
import com.yi.base.Schema;
import com.yi.base.chessPiecs;
import com.yi.base.who;
public class Mange implements Click ,Read{
    private int X,Y;
    private AI ai;
    private Write write;
    private Data data;
    private who whoNew;
    private ecptoma down;
    private Schema schema;
    public Mange(int x,int y,Schema tem){
        this.Y=y;
        this.X=x;
        schema=tem;
        if (this.schema.equals(Schema.PvP)){
            data=new Data(this.X,this.Y);
            down=new ChessBoard(this.X,this.Y,this);
            whoNew=who.me;
        }else if (this.schema.equals(Schema.line)){
            new NetInitUi(this.X,this.Y,this);
        }else if (this.schema.equals(Schema.Ai)){
            ai=new AI(this.X,this.Y);
            data=new Data(this.X,this.Y);
            down=new ChessBoard(this.X,this.Y,this);
        }
    }
    public void Click(int x, int y) {
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
    private void PvP(int x,int y)  {
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
    private void Ai(int x,int y){
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
    private void line(int x,int y){
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
    public void Read(int x,int y) {
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
