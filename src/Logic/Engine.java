package Logic;

import Pieces.*;


public class Engine {

    private int[][] locations;
    private ID[][] squareID;
    private Piece[][] pieceArray;
    boolean whiteTurn = true;
    private Engine engine;

    public Engine(){
        locations = new int[8][8];
        squareID = new ID[8][8];
        pieceArray = new Piece[8][8];
        this.engine = this;
        PopulateBoard();
        printBoard();
    }

    private void PopulateBoard() {

        for(int y=0; y<locations.length; y++){
            for(int x=0; x<locations[y].length; x++){
                if(y == 1){
                    locations[y][x] = 6;
                    squareID[y][x] = ID.BPAWN;
                    Piece tempPiece = new BPawn(engine, ID.BPAWN, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if(y == 6){
                    locations[y][x] = 6;
                    squareID[y][x] = ID.WPAWN;
                    Piece tempPiece = new WPawn(engine, ID.WPAWN, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if(y == 0 && (x == 0 || x == 7)){
                    locations[y][x] = 3;
                    squareID[y][x] = ID.BROOK;
                    Piece tempPiece = new BRook(engine, ID.BROOK, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if (y == 7 && (x == 0 || x == 7)){
                    locations[y][x] = 3;
                    squareID[y][x] = ID.WROOK;
                    Piece tempPiece = new WRook(engine, ID.WROOK, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if ((y == 0) && (x == 1 || x == 6)) {
                    locations[y][x] = 5;
                    squareID[y][x] = ID.BKNIGHT;
                    Piece tempPiece = new BKnight(engine, ID.BKNIGHT, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if ((y == 7) && (x == 1 || x == 6)) {
                    locations[y][x] = 5;
                    squareID[y][x] = ID.WKNIGHT;
                    Piece tempPiece = new WKnight(engine, ID.WKNIGHT, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if ((y == 0 ) && (x == 2 || x == 5)) {
                    locations[y][x] = 4;
                    squareID[y][x] = ID.BBISHOP;
                    Piece tempPiece = new BBishop(engine, ID.BBISHOP, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if (( y == 7) && (x == 2 || x == 5)) {
                    locations[y][x] = 4;
                    squareID[y][x] = ID.WBISHOP;
                    Piece tempPiece = new WBishop(engine, ID.WBISHOP, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if ((y == 0 ) && x == 3) {
                    locations[y][x] = 2;
                    squareID[y][x] = ID.BQUEEN;
                    Piece tempPiece = new BQueen(engine, ID.BQUEEN, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if (( y == 7) && x == 3) {
                    locations[y][x] = 2;
                    squareID[y][x] = ID.WQUEEN;
                    Piece tempPiece = new WQueen(engine, ID.WQUEEN, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if ((y == 0 ) && x == 4) {
                    locations[y][x] = 1;
                    squareID[y][x] = ID.BKING;
                    Piece tempPiece = new BKing(engine, ID.BKING, x, y);
                    pieceArray[y][x] = tempPiece;
                } else if (( y == 7) && x == 4) {
                    locations[y][x] = 1;
                    squareID[y][x] = ID.WKING;
                    Piece tempPiece = new WKing(engine, ID.WKING, x, y);
                    pieceArray[y][x] = tempPiece;
                } else {
                    locations[y][x] = 0;
                    squareID[y][x] = ID.EMPTY;
                    pieceArray[y][x] = null;
                }
            }
        }


    }

    public boolean movePiece(int oldx, int oldy, int newX, int newY){
        Piece piece = pieceArray[oldy][oldx];
        ID pieceID = piece.getId();
        if((whiteTurn && pieceID.isWhite()) || (!whiteTurn && !pieceID.isWhite())){
            if(!piece.canMove(newX, newY)){
                return false;
            }
            piece.setX(newX);
            piece.setY(newY);
            pieceArray[newY][newX] = piece;
            pieceArray[oldy][oldx] = null;
            squareID[oldy][oldx] = ID.EMPTY;
            squareID[newY][newX] = piece.getId();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean canEatPiece(int oldx, int oldy, int newX, int newY){
        Piece piece = pieceArray[oldy][oldx];
        Piece attackedPiece = pieceArray[newX][newY];
        return false;
    }

    private void printBoard() {

        for(int i=0; i<locations.length; i++){
            for(int a=0; a<locations[i].length; a++){
                System.out.print(locations[i][a]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

    public boolean diagonalCollisionCheck(){
        return false;
    }

    public ID[][] getSquareID() {
        return squareID;
    }

    public Piece[][] getPieceArray() {
        return pieceArray;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        this.whiteTurn = whiteTurn;
    }
}

