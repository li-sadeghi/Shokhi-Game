package classes;


public abstract class Piece {
    protected boolean killed = false ;
    public boolean isUpgrade = false ;
    protected boolean white  ;
    protected char symbol;
    protected int reserveCount ;
    public static int counter = 0;
    int xBeginning ;
    int yBeginning ;
    


    public Piece( int xPosition , int yPosition, boolean white){
        this.setWhite(white);
        this.setxBeginning(xBeginning);
        this.setyBeginning(yBeginning);
        this.setReserveCount(0);
        this.setSymbol();
        
    }

    

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
    public void setWhite(boolean white) {
        this.white = white;
    }
    public void setxBeginning(int xBeginning) {
        this.xBeginning = xBeginning;
    }
    public void setyBeginning(int yBeginning) {
        this.yBeginning = yBeginning;
    }
    public boolean isKilled() {
        return killed;
    }
    public boolean isWhite() {
        return white;
    }
    public int getxBeginning() {
        return xBeginning;
    }
    public int getyBeginning() {
        return yBeginning;
    }
    
    public void setReserveCount(int reserveCount) {
        this.reserveCount = reserveCount;
    }
    public void changeReserveCount() {
        counter ++ ;
        this.reserveCount = counter;
    }
    public int getReserveCount() {
        return reserveCount;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public abstract void setSymbol();
    public char getSymbol() {
        return symbol;
    }
    public void setUpgrade(boolean isUpgrade) {
        this.isUpgrade = isUpgrade;
    }
    public boolean isUpgrade() {
        return isUpgrade;
    }

    public abstract boolean canMove(Board board  , Spot start , Spot end ) ;

}

