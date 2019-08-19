package Pieces;

import Logic.Engine;
import Logic.ID;

public class WBishop extends Piece{


    public WBishop(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        int difx = x - destX;
        int dify = y - destY;
        if(Math.abs(difx) == Math.abs(dify)){
            return true;
        }
        System.out.println(difx + " aaaaaaaaaa " + dify);
        return false;
    }
}
