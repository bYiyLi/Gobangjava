package com.yi;

import com.yi.Interact.ChessBoard;
import com.yi.Interact.Click;
import com.yi.Mange.Mange;

public class Factory {
    private Click click;
    private ChessBoard chessBoard;
    private Mange mange;
    public  ChessBoard getChessBoard(int x,int y){
        if(this.chessBoard==null){
            synchronized (Factory.class){
                if (this.chessBoard==null){
                    this.chessBoard=new ChessBoard(x,y,click);
                }
            }
        }
        return this.chessBoard;
    }

    public Click getClick(){
        return this.click;



    }
}
