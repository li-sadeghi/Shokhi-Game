package classes;

public class Lance extends Piece {
    
    public boolean isUpgrade = false ;

    public Lance(int xPosition , int yPosition , boolean white){
        super(xPosition, yPosition, white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if(this.isUpgrade){
            if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()){
                return false ;
            }
            int xStart = start.getxPosition();
            int yStart = start.getyPosition();
            int xEnd = end.getxPosition();
            int yEnd = end.getyPosition();

            if(xEnd == xStart){
                if(yEnd > yStart){
                    for (int i = yStart + 1; i < yEnd; i++) {
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                    }
                    return true ;
                }else{
                    for (int i = yStart - 1; i > yEnd; i--) {
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                    }
                    return true ;
                }
            }else if(yStart == yEnd){
                if(xEnd > xStart){
                    for (int i = xStart + 1; i < xEnd; i++) {
                        if(board.getCell(i , yEnd).getPiece() != null){
                            return false ;
                        }
                    }
                    return true ;
                }else{
                    for (int i = xStart - 1; i > xEnd; i--) {
                        if(board.getCell(i , yEnd).getPiece() != null){
                            return false ;
                        }
                    }
                    return true ;
                }
            }else{
                return false ;
            }
        }else {
            if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()){
                return false ;
            }
            int xStart = start.getxPosition();
            int yStart = start.getyPosition();
            int xEnd = end.getxPosition();
            int yEnd = end.getyPosition();
            
            if(start.getPiece().isWhite() && xEnd == xStart && yEnd > yStart){
                for (int i = yStart + 1; i < yEnd ; i++) {
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                }
                return true ;
            }else if((!start.getPiece().isWhite()) && xEnd == xStart && yStart > yEnd){
                for (int i = yEnd + 1; i < yStart ; i++) {
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                }
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
            this.symbol = 'L';
        }else {
            this.symbol = 'l' ;
        }
    }
}
