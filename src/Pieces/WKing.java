package Pieces;

import Logic.Engine;
import Logic.ID;

public class WKing extends Piece{


    public WKing(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        if(destX > x || destY > y){
            if(destX <= x + 1 && destY <= y+1){
                System.out.println("case 1");
                return true;
            }
        }
        else if( destX < x || destY < y){
            if(destX >= x - 1 && destY >= y - 1){
                System.out.println("case 2");
                return true;
            }
        }
        return false;
    }
}
