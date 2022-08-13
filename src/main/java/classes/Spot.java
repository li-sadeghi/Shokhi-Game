package classes;

public class Spot {
    private Piece piece ;
    private int xPosition ;
    private int yPosition ;

    public Spot(int xPosition , int yPosition , Piece piece){
        this.setPiece(piece);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public Piece getPiece() {
        return piece;
    }
    public int getxPosition() {
        return xPosition;
    }
    public int getyPosition() {
        return yPosition;
    }
    
}
