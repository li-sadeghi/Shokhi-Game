package classes;



public class King extends Piece {
    
    public King(int xPosition , int yPosition , boolean white){
        super(xPosition, yPosition, white);
    }
    
    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()){
            return false ;
        }
        int xStart = start.getxPosition();
        int yStart = start.getyPosition();
        int xEnd = end.getxPosition();
        int yEnd = end.getyPosition();
        if(Math.abs(xEnd - xStart) > 1 || Math.abs(yStart-yEnd) > 1){
            return false ;
        }
        return true;
    }
    @Override
    public void setSymbol() {
        if(this.white){
            this.symbol = 'K';
        }else {
            this.symbol = 'k' ;
        }
    }
}
