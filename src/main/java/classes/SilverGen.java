package classes;

public class SilverGen extends Piece {

    public boolean isUpgrade = false ;
    
    public SilverGen(int xPosition , int yPosition , boolean white){
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

            if(Math.abs(xEnd - xStart) > 2 || Math.abs(yStart-yEnd) > 2){
                return false ;
            }
            if(Math.abs(xStart - xEnd) <= 1 && Math.abs(yEnd - yStart) <= 1){
                return true ;
            }
            if(xEnd - xStart == 1){
                if(yEnd - yStart == 2){
                    return false ;
                }
                if (yEnd - yStart == -2){
                    return false ;
                }

            }if(xEnd - xStart == 2){
                if(yEnd - yStart == 1){
                    return false ;
                }if(yEnd - yStart == -1){
                    return false ;
                }

            }if(xEnd - xStart == -1){
                if(yEnd - yStart == 2){
                    return false ;
                }if(yEnd - yStart == -2){
                    return false ;
                }

            }if(xEnd - xStart == -2){
                if(yEnd - yStart == 1){
                    return false ;
                }if(yEnd - yStart == -1){
                    return false ;
                }

            }


            if(Math.abs(xEnd - xStart) <= 1 && Math.abs(yEnd - yStart) <= 1){
                return true ;
            }else{
                if(xStart == xEnd){
                    if(yEnd - yStart == 2 && board.getCell(xEnd, yEnd - 1).getPiece() != null){
                        return false ;
                    }else if(yEnd - yStart == -2 && board.getCell(xEnd, yEnd + 1).getPiece() != null){
                        return false ;
                    }
                    return true ;
                }else if(xEnd > xStart){
                    if(yEnd - yStart == 2 && board.getCell(xEnd-1, yEnd - 1).getPiece() != null){
                        return false ;
                    }else if(yEnd == yStart && board.getCell(xEnd - 1, yEnd).getPiece() != null){
                        return false ;
                    }else if(yEnd - yStart == -2 && board.getCell(xEnd-1, yEnd+1).getPiece() != null) {
                        return false ;
                    }
                    return true ;
                }else{
                    if(yEnd - yStart == 2 && board.getCell(xEnd+1, yEnd - 1).getPiece() != null){
                        return false ;
                    }else if(yEnd == yStart && board.getCell(xEnd + 1, yEnd).getPiece() != null){
                        return false ;
                    }else if(yEnd - yStart == -2 && board.getCell(xEnd+1, yEnd+1).getPiece() != null) {
                        return false ;
                    }
                    return true ;
                }
            }

        }else{
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
                if((xEnd - xStart == -1 && yEnd == yStart ) || (xEnd - xStart == 1 && yEnd == yStart  ) || (xEnd == xStart && yEnd - yStart == -1)){
                    return false ;
                }
                return true ;
            }else{
                if((xEnd - xStart == -1 && yEnd == yStart ) || (xEnd - xStart == 1 && yEnd == yStart  ) || (xEnd == xStart && yEnd - yStart == 1)){
                    return false ;
                }
                return true ;
            }
        }
        
    }
    public boolean isUpgrade() {
        return isUpgrade;
    }
    public void setUpgrade(boolean isUpgrade) {
        this.isUpgrade = isUpgrade;
    }
    @Override
    public void setSymbol() {
        if(this.white){
            this.symbol = 'S';
        }else {
            this.symbol = 's' ;
        }
    }
}
