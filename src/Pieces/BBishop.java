package Pieces;

import Logic.Engine;
import Logic.ID;

public class BBishop extends Piece{


    public BBishop(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        int difx = x - (destX);
        int dify = y - (destY);
        if(Math.abs(difx) == Math.abs(dify)){
            return true;
        }
        return false;
    }
}
