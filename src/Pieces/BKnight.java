package Pieces;

import Logic.Engine;
import Logic.ID;

public class BKnight extends Piece{


    public BKnight(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        if(destX == x + 2 && (destY == y+1 || destY == y-1)){
            return true;
        }
        else if(destX == x -2 && (destY == y + 1 || destY == y -1)){
            return true;
        }
        else if((destX == x+1 || destX == x-1) && destY == y+2){
            return true;
        }
        else if((destX == x+1 || destX == x-1) && destY == y-2){
            return true;
        }
        return false;
    }
}
