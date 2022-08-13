package classes;

public class Game {
    
    private Board board ;
    private boolean whiteTurn = false ;
    public Status status = Status.ACTIVE ;
    private Player[] players = new Player[2] ;

    public Game(Board board ,Player white , Player black){
        this.setBoard(board);
        this.setPlayers(white , black);
    }

    public void movePiece(char piece ,Board board, int start , int end ){
        
        if(board.getCell(start/10 - 1, start % 10 -1).getPiece() == null || (start <= 10 && start != 0) || end <= 10){
            return ;
        }else if((!this.whiteTurn && board.getCell(start/10 - 1, start % 10 -1).getPiece().isWhite()) ||
                (this.whiteTurn && !board.getCell(start/10 - 1, start % 10 -1).getPiece().isWhite()) ){
            return ;
        }
        else if(board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() != piece){
            return ;
        }else{
            if(!(board.getCell(start/10 - 1, start % 10 -1).getPiece().canMove(board, board.getCell(start/10 - 1, start % 10 -1), board.getCell(end/10 - 1, end % 10 -1)))){
                return ;
            }else{
                if(board.getCell(end/10 - 1, end % 10 -1).getPiece() == null){
                    if(((end % 10 == 4 ||end % 10 == 5) && (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'P' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'L' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'B' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'S') 
                    ||(end % 10 == 1 ||end % 10 == 2)&&
                    (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'p' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'l' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'b' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 's'))){
                        
                        board.getCell(start/10 - 1, start % 10 -1).getPiece().setUpgrade(true);
                    }
                    board.getCell(end/10 - 1, end % 10 -1).setPiece(board.getCell(start/10 - 1, start % 10 -1).getPiece());
                    board.getCell(start/10 - 1, start % 10 -1).setPiece(null);
                    this.changeTurn();
                }else{
                    if(this.whiteTurn){
                        if(board.getCell(end/10 - 1, end % 10 -1).getPiece().getSymbol() == 'k'){
                            this.setStatus(Status.WHITE_WIN);
                        }
                        this.players[1].getPieces().remove(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setKilled(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().changeReserveCount();
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol((char)(piece - 32));
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setWhite(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setUpgrade(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setxBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setyBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol();
                        this.players[0].addPiece(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        
                        this.changeTurn();
                    }else{
                        if(board.getCell(end/10 - 1, end % 10 -1).getPiece().getSymbol() == 'K'){
                            this.setStatus(Status.BLACK_WIN);
                        }
                        this.players[0].getPieces().remove(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setKilled(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().changeReserveCount();
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol((char)(piece + 32));
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setWhite(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setUpgrade(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setxBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setyBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol();
                        this.players[1].addPiece(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        
                        this.changeTurn();
                    }
                    
                    if(((end % 10 == 4 ||end % 10 == 5) && (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'P' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'L' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'B' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'S') 
                    ||(end % 10 == 1 ||end % 10 == 2)&&
                    (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'p' 
                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'l' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'b' 
                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 's'))){
                        
                        board.getCell(start/10 - 1, start % 10 -1).getPiece().setUpgrade(true);
                    }
                    board.getCell(end/10 - 1, end % 10 -1).setPiece(board.getCell(start/10 - 1, start % 10 -1).getPiece());
                    board.getCell(start/10 - 1, start % 10 -1).setPiece(null);
                }
            }
        }
    }

    public void movePiece(Board board, int start , int end ){

        if(board.getCell(start/10 - 1, start % 10 -1).getPiece() == null || (start <= 10 && start != 0) || end <= 10){
            return ;
        }else if((!this.whiteTurn && board.getCell(start/10 - 1, start % 10 -1).getPiece().isWhite()) ||
                (this.whiteTurn && !board.getCell(start/10 - 1, start % 10 -1).getPiece().isWhite()) ){
            return ;
        }else{
            if(!(board.getCell(start/10 - 1, start % 10 -1).getPiece().canMove(board, board.getCell(start/10 - 1, start % 10 -1), board.getCell(end/10 - 1, end % 10 -1)))){
                return ;
            }else{
                if(board.getCell(end/10 - 1, end % 10 -1).getPiece() == null){
                    if(((end % 10 == 4 ||end % 10 == 5) && (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'P'
                            ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'L'
                            ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'B'
                            || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'S')
                            ||(end % 10 == 1 ||end % 10 == 2)&&
                            (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'p'
                                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'l'
                                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'b'
                                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 's'))){

                        board.getCell(start/10 - 1, start % 10 -1).getPiece().setUpgrade(true);
                    }
                    board.getCell(end/10 - 1, end % 10 -1).setPiece(board.getCell(start/10 - 1, start % 10 -1).getPiece());
                    board.getCell(start/10 - 1, start % 10 -1).setPiece(null);
                    this.changeTurn();
                }else{
                    char piece = board.getCell(end/10 - 1, end % 10 -1).getPiece().symbol ;
                    if(this.whiteTurn){
                        if(board.getCell(end/10 - 1, end % 10 -1).getPiece().getSymbol() == 'k'){
                            this.setStatus(Status.WHITE_WIN);
                        }
                        this.players[1].getPieces().remove(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setKilled(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().changeReserveCount();
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol((char)(piece - 32));
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setWhite(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setUpgrade(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setxBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setyBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol();
                        this.players[0].addPiece(board.getCell(end/10 - 1, end % 10 -1).getPiece());

                        this.changeTurn();
                    }else{
                        if(board.getCell(end/10 - 1, end % 10 -1).getPiece().getSymbol() == 'K'){
                            this.setStatus(Status.BLACK_WIN);
                        }
                        this.players[0].getPieces().remove(board.getCell(end/10 - 1, end % 10 -1).getPiece());
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setKilled(true);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().changeReserveCount();
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol((char)(piece + 32));
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setWhite(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setUpgrade(false);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setxBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setyBeginning(-1);
                        board.getCell(end/10 - 1, end % 10 -1).getPiece().setSymbol();
                        this.players[1].addPiece(board.getCell(end/10 - 1, end % 10 -1).getPiece());

                        this.changeTurn();
                    }

                    if(((end % 10 == 4 ||end % 10 == 5) && (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'P'
                            ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'L'
                            ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'B'
                            || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'S')
                            ||(end % 10 == 1 ||end % 10 == 2)&&
                            (board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'p'
                                    ||board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'l'
                                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 'b'
                                    || board.getCell(start/10 - 1, start % 10 -1).getPiece().getSymbol() == 's'))){

                        board.getCell(start/10 - 1, start % 10 -1).getPiece().setUpgrade(true);
                    }
                    board.getCell(end/10 - 1, end % 10 -1).setPiece(board.getCell(start/10 - 1, start % 10 -1).getPiece());
                    board.getCell(start/10 - 1, start % 10 -1).setPiece(null);
                }
            }
        }

    }

    public void placePiece(char piece ,Player player,Board board, int start , int end){

        if(board.getCell(end/10 - 1, end % 10 - 1).getPiece() != null){
            return ;
        }else{
            boolean isExist = false ;
            int index = 0 ;
            for (int i = 0; i < player.getPieces().size(); i++) {
                if(player.getPieces().get(i).getSymbol() == piece){
                    isExist = true ;
                    index = i ;
                    break;
                }
            }
            if(!isExist){
                return ;
            }else{


                if(player.isWhite()){
                    this.players[0].getPieces().get(index).setxBeginning(end / 10 - 1);
                    this.players[0].getPieces().get(index).setyBeginning(end % 10 - 1);
                    this.players[0].getPieces().get(index).setKilled(false);
                    this.players[0].getPieces().get(index).setUpgrade(false);
                    this.players[0].getPieces().get(index).setReserveCount(0);
                    board.getCell(end / 10 - 1, end % 10 - 1).setPiece(this.players[0].getPieces().get(index));
                    this.players[0].getPieces().remove(index) ;
                }else{
                    this.players[1].getPieces().get(index).setxBeginning(end / 10 - 1);
                    this.players[1].getPieces().get(index).setyBeginning(end % 10 - 1);
                    this.players[1].getPieces().get(index).setKilled(false);
                    this.players[1].getPieces().get(index).setUpgrade(false);
                    this.players[1].getPieces().get(index).setReserveCount(0);
                    board.getCell(end / 10 - 1, end % 10 - 1).setPiece(this.players[1].getPieces().get(index));
                    this.players[1].getPieces().remove(index) ;
                }


                this.changeTurn();
            }
        }
    }

    public void setPlayers(Player white , Player black) {
        this.players[0] = white;
        this.players[1] = black ;
    }
    public Player[] getPlayers() {
        return players;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
    public void setWhiteTurn(boolean whiteTurn) {
        this.whiteTurn = whiteTurn;
    }
    public boolean isWhiteTurn() {
        return whiteTurn;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Board getBoard() {
        return board;
    }
    public void changeTurn() {
        this.whiteTurn = !this.whiteTurn;
    }
    


}
