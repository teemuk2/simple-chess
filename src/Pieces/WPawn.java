package Pieces;

import Logic.Engine;
import Logic.ID;

import java.awt.*;


public class WPawn extends Piece{

    private boolean firstMove;

    public WPawn(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
        this.firstMove = true;
    }

    @Override
    public boolean canMove(int destX, int destY) {

        ID[][] squareID = engine.getSquareID();
        ID firstSquare = squareID[y-1][x];
        //causes bug at edge but irrelevant due to upgrading
        ID secSquare = null;
        if(firstMove){
            secSquare = squareID[y-2][x];
        }
        ID northWest = null;
        if(x != 0){
            northWest = squareID[y-1][x-1];
        }
        ID northEast = null;
        if(x != 7){
            northEast = squareID[y-1][x+1];
        }

        //double move

        if(firstMove){
            if(destY == y-2 && destX == x){
                if(firstSquare != ID.EMPTY || secSquare != ID.EMPTY){
                    return false;
                }
                firstMove = false;
                return true;
            }
        }

        //standard

        if(destY == y-1 && destX == x){
            if(firstSquare == ID.EMPTY){
                firstMove = false;
                return true;
            }
            return false;
        }

        // eating
        else if(destY == y-1 && (destX == x - 1 || destX == x + 1)){
            if(destY ==y-1 && destX == x-1){
                if(northWest != ID.EMPTY){
                    firstMove = false;
                    return true;
                }
                return false;
            }
            if(destY == y-1 && destX == x+1){
                if(northEast != ID.EMPTY){
                    firstMove = false;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

}
