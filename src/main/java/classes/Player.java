package classes;

import java.util.ArrayList;


public class Player {
    private boolean white ;
    private ArrayList<Piece> Pieces ;

    public Player(Board board,boolean white){
        this.setWhite(white);
        Spot[][] cells = board.getCells();
        ArrayList<Piece> arrOfPiece = new ArrayList<>() ;

        this.setPieces(arrOfPiece);

    }
    public boolean isWhite() {
        return white;
    }
    public ArrayList<Piece> getPieces() {
        return Pieces;
    }
    public void setPieces(ArrayList<Piece> pieces) {
        Pieces = pieces;
    }
    public void setWhite(boolean white) {
        this.white = white;
    }
    public void addPiece(Piece piece){
        this.getPieces().add(piece);
    }
    
}
