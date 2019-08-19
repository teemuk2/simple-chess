package Visuals;

import Logic.Engine;
import Logic.ID;
import Pieces.BRook;

import java.awt.event.*;

import static Logic.ID.EMPTY;

public class MouseCheck implements MouseListener, MouseMotionListener {

    private Engine engine;
    private Board board;
    private ID[][] squareID;
    private int x = 50;
    private int y = 50;
    private ID selectedSquareID = null;
    private ID draggingOriginSquare = null;


    public MouseCheck(Engine engine, Board board) {
        this.engine = engine;
        this.board = board;
        squareID = engine.getSquareID();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(mouseEvent.getButton() == MouseEvent.BUTTON1){

            x = (int) (Math.floor((double) mouseEvent.getX() / 100));
            y = (int) (Math.floor((double) (mouseEvent.getY() - 26) / 100));
            selectedSquareID = squareID[y][x];

            if(!board.isFirstClick()){
                board.setFirstClick(true);
            }
            board.setX(x);
            board.setY(y);
        }

        if(mouseEvent.getButton() == MouseEvent.BUTTON3){
            // right click to move from left click selected square

            int moveX = (int) (Math.floor((double) mouseEvent.getX() / 100));
            int moveY = (int) (Math.floor((double) (mouseEvent.getY() - 26) / 100));
            ID moveSquareID = squareID[moveY][moveX];
            boolean whiteTurn = engine.isWhiteTurn();

            if(board.isFirstClick() && selectedSquareID != EMPTY && moveSquareID == EMPTY){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
                board.setFirstClick(false);
            }
            else if(engine.isWhiteTurn() && board.isFirstClick() && selectedSquareID != EMPTY && moveSquareID!= ID.BKING && !moveSquareID.isWhite()){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
                board.setFirstClick(false);
                System.out.print("EATING");
            }
            else if(!engine.isWhiteTurn() && board.isFirstClick() && selectedSquareID != EMPTY && moveSquareID!= ID.WKING && moveSquareID.isWhite()){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
                board.setFirstClick(false);
                System.out.print("EATING");
            }
            else{
                System.out.println("not executing right click");
            }
        }
        board.update();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {


        if(mouseEvent.getButton() == MouseEvent.BUTTON1){

            x = (int) (Math.floor((double) mouseEvent.getX() / 100));
            y = (int) (Math.floor((double) (mouseEvent.getY() - 26) / 100));
            draggingOriginSquare= squareID[y][x];
            System.out.print("pressed at " + draggingOriginSquare+ " ");

            System.out.println(x + " - " + y + " \t");

            ID draggedAt = squareID[y][x];
            board.setPieceToDraw(draggedAt);
            board.setDrawing(true);
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        if(mouseEvent.getButton() == MouseEvent.BUTTON1){

            int moveX = (int) (Math.floor((double) mouseEvent.getX() / 100));
            int moveY = (int) (Math.floor((double) (mouseEvent.getY() - 26) / 100));
            ID moveSquareID = squareID[moveY][moveX];

            if(draggingOriginSquare!= EMPTY && moveSquareID == EMPTY){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
            }
            else if(engine.isWhiteTurn() && draggingOriginSquare!= EMPTY && moveSquareID!= ID.BKING && !moveSquareID.isWhite()){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
                board.setFirstClick(false);
                System.out.print(" attempting eat ");
            }
            else if(!engine.isWhiteTurn() && draggingOriginSquare!= EMPTY && moveSquareID!= ID.WKING && moveSquareID.isWhite()){
                boolean legal = engine.movePiece(x, y, moveX, moveY);
                if(legal){
                    engine.setWhiteTurn(!engine.isWhiteTurn());
                }
                board.setFirstClick(false);
                System.out.print("attempting eat ");
            }
        }
        board.setDrawing(false);
        board.update();

    }


    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

        board.setMouseX(mouseEvent.getX());
        board.setMouseY(mouseEvent.getY());
        board.update();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
