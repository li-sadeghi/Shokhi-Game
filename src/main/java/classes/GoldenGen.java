package classes;

public class GoldenGen extends Piece {
    
    public GoldenGen(int xPosition , int yPosition , boolean white){
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
        if(start.getPiece().isWhite()){
            if((xEnd - xStart == -1 && yEnd - yStart == -1) || (xEnd - xStart == 1 && yEnd - yStart == -1 )){
                return false ;
            }
            return true ;
        }else{
            if((xEnd - xStart == -1 && yEnd - yStart == 1) || (xEnd - xStart == 1 && yEnd - yStart == 1 )){
                return false ;
            }
            return true ;
        }
        
    }
    @Override
    public void setSymbol() {
        if(this.white){
            this.symbol = 'G';
        }else {
            this.symbol = 'g' ;
        }
    }
}
