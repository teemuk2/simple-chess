package Pieces;

import Logic.Engine;
import Logic.ID;

public class BQueen extends Piece{


    public BQueen(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        int difx = x - destX;
        int dify = y - destY;
        if(Math.abs(difx) == Math.abs(dify)){
            return true;
        }
        else if(destX == x || destY == y){
            return true;
        }
        return false;
    }
}
