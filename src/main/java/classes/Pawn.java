package classes;

public class Pawn extends Piece {

    public boolean isUpgrade = false ;

    public Pawn(int xPosition , int yPosition , boolean white){
        super(xPosition, yPosition, white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(this.isUpgrade){
            int xStart = start.getxPosition();
            int yStart = start.getyPosition();
            GoldenGen goldenGen = new GoldenGen(xStart, yStart, board.getCell(xStart,yStart).getPiece().white);
            return goldenGen.canMove(board, start, end);
            
        }else {
            if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()){
                return false ;
            }
            int xStart = start.getxPosition();
            int yStart = start.getyPosition();
            int xEnd = end.getxPosition();
            int yEnd = end.getyPosition();
    
            if(xStart == xEnd && yEnd - yStart == 1 && start.getPiece().isWhite()){
                return true ;
            }else if((!start.getPiece().isWhite()) && xStart == xEnd && yStart - yEnd == 1){
                return true ;
            }else{
                return false ;
            }
        }
    }
    //getters and setters
    public boolean isUpgrade() {
        return isUpgrade;
    }
    public void setUpgrade(boolean isUpgrade) {
        this.isUpgrade = isUpgrade;
    }
    @Override
    public void setSymbol() {
        if(this.white){
            this.symbol = 'P';
        }else {
            this.symbol = 'p' ;
        }
    }
}
