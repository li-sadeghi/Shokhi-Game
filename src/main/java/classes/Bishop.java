package classes;

public class Bishop extends Piece {

    public boolean isUpgrade = false ;

    public Bishop(int xPosition , int yPosition , boolean white){
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

            if(Math.abs(yEnd - yStart) <= 1 && Math.abs(xEnd - xStart) <= 1){
                return true ;
            }

            if(Math.abs(yEnd - yStart) != Math.abs(xEnd - xStart)){
                return false ;
            }

            
            if(xEnd > xStart && yEnd > yStart){
                for (int i = yStart + 1; i < yEnd ; i++) {
                    xStart ++ ;
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                    
                }
                return true ;
            }else if(xEnd < xStart && yEnd > yStart) {
                for (int i = yStart + 1; i < yEnd ; i++) {
                    xStart -- ;
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                }
                return true ;
            }else if(xEnd > xStart && yEnd < yStart){
                for (int i = yStart - 1; i > yEnd ; i--) {
                    xStart ++ ;
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                }
                return true ;
            }else{
                for (int i = yStart - 1; i > yEnd ; i--) {
                    xStart -- ;
                    if(board.getCell(xStart, i).getPiece() != null){
                        return false ;
                    }
                }
                return true ;
            }
            
            



        }else{
            if(end.getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()){
                return false ;
            }
            int xStart = start.getxPosition();
            int yStart = start.getyPosition();
            int xEnd = end.getxPosition();
            int yEnd = end.getyPosition();
            
            if(Math.abs(yEnd - yStart) != Math.abs(xEnd - xStart)){
                return false ;
            }

            if(start.getPiece().isWhite()){
                if(yStart > yEnd){
                    return false ;
                }
                if(xEnd > xStart){
                    for (int i = yStart + 1; i < yEnd ; i++) {
                        xStart ++ ;
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                        
                    }
                    return true ;
                }else {
                    for (int i = yStart + 1; i < yEnd ; i++) {
                        xStart -- ;
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                    }
                    return true ;
                }
                
            }else {
                if(yStart < yEnd){
                    return false ;
                }
                if(xEnd > xStart){

                    for (int i = yStart - 1; i > yEnd ; i--) {
                        xStart ++ ;
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                        
                    }
                }else {

                    for (int i = yStart - 1; i > yEnd ; i--) {
                        xStart -- ;
                        if(board.getCell(xStart, i).getPiece() != null){
                            return false ;
                        }
                    }
                }
                return true ;
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
            this.symbol = 'B';
        }else {
            this.symbol = 'b' ;
        }
    }
}
