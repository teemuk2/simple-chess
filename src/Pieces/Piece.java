package Pieces;

import Logic.Engine;
import Logic.ID;

import java.awt.*;

public abstract class Piece {

    Engine engine;
    ID id;
    int x;
    int y;

    Piece(Engine engine, ID id, int x, int y) {
        this.engine = engine;
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void draw (Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect( x * 100 + 35, y * 100 + 35, 30, 30);
    }

    public abstract boolean canMove(int destX, int destY);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }
}
