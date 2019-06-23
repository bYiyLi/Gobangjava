package com.yi.Logic.Ai;
import com.yi.base.chessPiecs;
public class AI extends Thread{
    private int X;
    private int Y;
    private chessPiecs piecs[][];
    public AI(int x, int y){
        this.X=x;
        this.Y=y;
        this.piecs=new chessPiecs[this.X][this.Y];
        for (int temX=0;temX<x;temX++){
            for (int temY=0;temY<y;temY++){
                piecs[temX][temY]=chessPiecs.no;
            }
        }
    }
    public int[] getAIdown(int x,int y){
        this.piecs[x][y]=chessPiecs.other;
        int temXY[]=new int[2];
        temXY[0]=0;
        temXY[1]=0;
        return temXY;
    }
    @Override
    public void run() {
        super.run();

    }
}
