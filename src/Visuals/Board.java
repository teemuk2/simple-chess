package Visuals;

import Logic.Engine;
import Logic.ID;
import Pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel {

    private Engine engine;
    private boolean firstClick;
    private int x;
    private int y;
    BufferedImage img;
    private int mouseX = 0;
    private int mouseY = 0;
    private boolean drawing = false;
    private ID pieceToDraw;

    public Board(Engine engine){
        this.engine = engine;

        try {
            img = ImageIO.read(this.getClass().getResource("/res/sprites.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g){

        Color lightSquare = new Color(100,155,240);
        Color darkSquare = new Color(0,120, 255);

        for(int y=0; y<8; y++){
            for(int x=0; x<8; x++){
                if(x%2 == 0){
                    if(y%2 == 0){
                        g.setColor(lightSquare);
                        g.fillRect(x*100,y*100, 100, 100);
                    }
                    else{
                        g.setColor(darkSquare);
                        g.fillRect(x*100,y*100, 100, 100);
                    }
                }
                else{
                    if(y%2 == 0){
                        g.setColor(darkSquare);
                        g.fillRect(x*100,y*100, 100, 100);
                    }
                    else{
                        g.setColor(lightSquare);
                        g.fillRect(x*100,y*100, 100, 100);
                    }
                }
            }
        }

        Piece[][] pieceArray = engine.getPieceArray();

        for(int y=0; y<pieceArray.length; y++){
            for(int x=0; x<pieceArray[y].length; x++){
                if(pieceArray[y][x] != null){
                    Piece piece = pieceArray[y][x];
                    ID id = piece.getId();
                    drawID(g, id, x * 100 + 18, y * 100 + 18);
                }
            }
        }

        if(firstClick){
            g.setColor(Color.GREEN);
            g.drawRect(x*100, y*100, 99, 99);
        }

        if(drawing){
            drawID(g, pieceToDraw, mouseX-32, mouseY-64);
        }

        g.setColor(Color.gray);
        g.fillRect(800, 0, 190, 790);

        if(engine.isWhiteTurn()){
            g.setColor(Color.white);
            g.fillRect(850, 200, 100, 50);
            g.setColor(Color.red);
            g.drawString("white to move",860, 230);
        }
        else{
            g.setColor(Color.black);
            g.fillRect(850, 200, 100, 50);
            g.setColor(Color.red);
            g.drawString("black to move", 860, 230);
        }

    }

    private void autoDraw(Graphics g, int imgX, int imgY, int x, int y){
        g.drawImage(img.getSubimage( imgX, imgY, 16, 16), x, y, 64, 64, null);
    }

    private void drawID(Graphics g, ID id, int x, int y){
        if(id == ID.BPAWN){
            autoDraw(g, 0, 0, x, y);
        }
        if(id == ID.WPAWN){
            autoDraw(g, 0, 16, x, y);
        }
        if(id == ID.BROOK){
            autoDraw(g, 16, 0, x, y);
        }
        if(id == ID.WROOK){
            autoDraw(g, 16, 16, x, y);
        }
        if(id == ID.BKNIGHT){
            autoDraw(g, 32, 0, x, y);
        }
        if(id == ID.WKNIGHT){
            autoDraw(g, 32, 16, x, y);
        }
        if(id == ID.BBISHOP){
            autoDraw(g, 48, 0, x, y);
        }
        if(id == ID.WBISHOP){
            autoDraw(g, 48, 16, x, y);
        }
        if(id == ID.BQUEEN){
            autoDraw(g, 64, 0, x, y);
        }
        if(id == ID.WQUEEN){
            autoDraw(g, 64, 16, x, y);
        }
        if(id == ID.BKING){
            autoDraw(g, 80, 0, x, y);
        }
        if(id == ID.WKING){
            autoDraw(g, 80, 16, x, y);
        }
    }

    public void update(){
        repaint();
    }

    public boolean isFirstClick() {
        return firstClick;
    }

    public void setFirstClick(boolean firstClick) {
        this.firstClick = firstClick;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }

    public void setPieceToDraw(ID pieceToDraw) {
        this.pieceToDraw = pieceToDraw;
    }
}
