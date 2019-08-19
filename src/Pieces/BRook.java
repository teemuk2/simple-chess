package Pieces;

import Logic.Engine;
import Logic.ID;

import java.awt.*;

public class BRook extends Piece{


    public BRook(Engine engine, ID id, int x, int y) {
        super(engine, id, x, y);
    }

    @Override
    public void draw (Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect( x * 100 + 35, y * 100 + 35, 30, 30);
    }

    @Override
    public boolean canMove(int destX, int destY) {
        if(destX == x || destY == y){
            return true;
        }
        return false;
    }
}
