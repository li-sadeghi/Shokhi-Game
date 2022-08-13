import java.util.Scanner;

import classes.*;

public class Main{
    public static void main(String[] args) {
        
        Board board = new Board() ;
        Player white = new Player(board ,true);
        Player black = new Player(board ,false) ;
        Game game = new Game(board , white , black) ;
        Scanner scanner = new Scanner(System.in) ;
        String scan = new String();
        char piece ;
        int Start, End ;
        
        while (true){

            scan = scanner.nextLine();
            piece = scan.charAt(0) ;
            if(piece == '0' ){
                break;
            }else if(!(piece == 'K' || piece == 'k'||piece == 'P' || piece == 'p'||piece == 'G' || piece == 'g'||piece == 'S' || piece == 's'||piece == 'L' || piece == 'l'|| piece == 'B'||piece == 'b' )){
                printBoard(board);
                printOtherPieces(black);
                printOtherPieces(white);
                continue;
            }
            Start = toNumber(scan.substring(2 , 4)) ;
            End = toNumber(scan.substring(5 , 7)) ;
            if(Start > 0 && Start < 11){
                printBoard(board);
                printOtherPieces(black);
                printOtherPieces(white);
                continue;
            }
            if(End >= 0 && End < 11){
                printBoard(board);
                printOtherPieces(black);
                printOtherPieces(white);
                continue;
            }
            if(!((Start / 10 >=0 && Start / 10 <= 5) && (Start % 10 >=0 && Start % 10 <= 5)&&(End / 10 <= 5 && End / 10 >= 0 )&&(End % 10 <= 5 && End % 10 >= 0))){
                printBoard(board);
                printOtherPieces(black);
                printOtherPieces(white);
                continue;
            }
            if(Start == End){
                printBoard(board);
                printOtherPieces(black);
                printOtherPieces(white);
                continue;
            }
            if(Start == 0){
                if(game.isWhiteTurn()){
                    game.placePiece(piece, white, board, Start, End);
                }else{
                    game.placePiece(piece, black, board, Start, End);
                }
            }else{
                game.movePiece(piece, board, Start, End);
            }

            printBoard(board);
            printOtherPieces(black);
            printOtherPieces(white);
            if(game.status != Status.ACTIVE){
                if(game.status == Status.WHITE_WIN){
                    System.out.println("white wins!");
                    break ;
                }else{
                    System.out.println("black wins!");
                    break ;
                }
            }
        }
        scanner.close();
        
    }
    public static int toNumber(String str) {
        return (str.charAt(0) - '0' )*10 + str.charAt(1) - '0' ;
    }
    public static void printBoard(Board board){
        Spot[][] cells = board.getCells() ;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(cells[j][i].getPiece() != null){
                    printPiece(cells[j][i].getPiece());
                }else{
                    System.out.print("-");
                }
            }
        }
        System.out.println("");
    }
    public static void printOtherPieces(Player player) {
        boolean isExist = false ;
        for (int i = 0; i < player.getPieces().size(); i++) {
            if(player.getPieces().get(i).isKilled()){
                isExist = true ;
                break ;
            }
        }
        
        if(!isExist){
            System.out.println("");
            return ;
        }
        for (int i = 0; i < player.getPieces().size(); i++) {
            if(player.getPieces().get(i).isKilled()){
                printPiece(player.getPieces().get(i));
            }
        }
        System.out.println("");
        
    }
    public static void printPiece(Piece piece) {
        System.out.print(piece.getSymbol());
    
    }

} 