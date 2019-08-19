package Logic;

public enum ID {
    EMPTY(0,0, true), WKING(0,0, true), WQUEEN(0,0, true), WROOK(0,0, true), WBISHOP(0,0, true), WKNIGHT(0,0, true), WPAWN(0,0, true), BKING(0,0, false), BQUEEN(0,0, false),
    BROOK(0,0, false), BBISHOP(0,0, false), BKNIGHT(0,0, false), BPAWN(0,0, false);

    private int spriteX, spriteY;
    private boolean white;

    ID(int spriteX, int spriteY, boolean white){
        this.spriteX = spriteX;
        this.spriteY = spriteY;
        this.white = white;
    }

    public int getSpriteX() {
        return spriteX;
    }

    public int getSpriteY() {
        return spriteY;
    }

    public boolean isWhite() {
        return white;
    }
}
