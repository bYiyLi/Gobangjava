package com.yi.Logic;
import com.yi.base.chessPiecs;
public class Data {
    private int X;
    private int Y;
    private chessPiecs piecs[][];
    public Data(int x,int y){
        this.X=x;
        this.Y=y;
        piecs=new chessPiecs[x][y];
        for (int temX=0;temX<x;temX++){
            for (int temY=0;temY<y;temY++){
                piecs[temX][temY]=chessPiecs.no;
            }
        }
    }
    public boolean judge(int x, int y, chessPiecs tem) {
        this.piecs[x][y]=tem;
        int temx=x;
        int temy=y;
        int n=0;
        while (temx>=0&&temx<this.X&&piecs[temx][temy]==tem){
            temx++;
            n++;
        }
        temx=x;
        while (temx>=0&&temx<this.X&&piecs[temx][temy]==tem){
            temx--;
            n++;
        }
        if (n>5){
            return true;
        }
        temx=x;
        temy=y;
        n=0;
        while (temy>=0&&temy<this.Y&&piecs[temx][temy]==tem){
            temy++;
            n++;
        }
        temx=x;
        temy=y;
        while (temy>=0&&temy<this.X&&piecs[temx][temy]==tem){
            temy--;
            n++;
        }
        if (n>5){
            System.out.println();
            return true;
        }
        temx=x;
        temy=y;
        n=0;
        while (temx>=0&&temy>=0&&temx<this.X&&temy<this.Y&&piecs[temx][temy]==tem){
            temx++;
            temy++;
            n++;
        }
        temx=x;
        temy=y;
        while (temx>=0&&temy>=0&&temx<this.X&&temy<this.Y&&piecs[temx][temy]==tem){
            temx--;
            temy--;
            n++;
        }
        if (n>5){
            return true;
        }
        temx=x;
        temy=y;
        n=0;
        while (temx>=0&&temy>=0&&temx<this.X&&temy<this.Y&&piecs[temx][temy]==tem){
            temx++;
            temy--;
            n++;
        }
        temx=x;
        temy=y;
        while (temx>=0&&temy>=0&&temx<this.X&&temy<this.Y&&piecs[temx][temy]==tem){
            temx--;
            temy++;
            n++;
        }
        if (n>5){
            return true;
        }
        return false;
    }
}
