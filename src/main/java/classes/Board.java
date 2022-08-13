package classes;

public class Board {

    Spot[][] cells = new Spot[5][5] ;

    public Board(){
        this.resetBoard();
    }
    public void resetBoard(){
        
        cells[0][0] = new Spot(0, 0, new King(0,0,true));
        cells[1][0] = new Spot(1, 0, new GoldenGen(1,0,true));
        cells[2][0] = new Spot(2, 0, new SilverGen(2,0,true));
        cells[3][0] = new Spot(3, 0, new Bishop(3,0,true));
        cells[4][0] = new Spot(4, 0, new Lance(4,0,true));
        cells[0][1] = new Spot(0, 1, new Pawn(0,1,true));

        cells[4][4] = new Spot(4, 4, new King(4,4,false));
        cells[3][4] = new Spot(3, 4, new GoldenGen(3,4,false));
        cells[2][4] = new Spot(2, 4, new SilverGen(2,4,false));
        cells[1][4] = new Spot(1, 4, new Bishop(1,4,false));
        cells[0][4] = new Spot(0, 4, new Lance(0,4,false));
        cells[4][3] = new Spot(4, 3, new Pawn(4,3,false));

        for (int i = 0; i < 5 ; i++) {
            if(i == 0){
                cells[i][3] = new Spot(i, 3, null);
                cells[i][2] = new Spot(i, 2, null);
            }else if(i == 4){
                cells[i][1] = new Spot(i, 1, null);
                cells[i][2] = new Spot(i, 2, null);
            }else{
                cells[i][3] = new Spot(i, 3, null);
                cells[i][2] = new Spot(i, 2, null);
                cells[i][1] = new Spot(i, 1, null);
            }

        }


    }
    public Spot getCell(int xLoc , int yLoc){
        return cells[xLoc][yLoc];
    }
    public Spot[][] getCells() {
        return cells;
    }
}
