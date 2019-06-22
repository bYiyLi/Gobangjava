package com.yi.Mange;
import com.yi.Interact.ChessBoard;
import com.yi.Interact.Click;
import com.yi.Interact.ecptoma;
import com.yi.Logic.Data;
import com.yi.base.Schema;
import com.yi.base.chessPiecs;
import com.yi.base.who;
public class Mange implements Click {
    private Data data;
    private who whoNew;
    private ecptoma down;
    private Schema schema;
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
    public Mange(int x,int y,Schema tem){
        schema=tem;
        data=new Data(x,y);
        down=new ChessBoard(x,y,this);
        whoNew=who.me;
    }
    private void PvP(int x,int y){
        boolean t=false;
        if (whoNew==who.me){
            t=data.judge(x,y,chessPiecs.me);
            down.dowm(x,y, chessPiecs.me);
            whoNew=who.other;
        }else if (whoNew==who.other){
            t=data.judge(x,y,chessPiecs.other);
            down.dowm(x,y, chessPiecs.other);
            whoNew=who.me;
        }
        System.out.println(t);
    }
    private void Ai(int x,int y){

    }
    private void line(int x,int y){}
}
