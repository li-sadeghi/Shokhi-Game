package GuiController;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import classes.* ;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class GameGUI {
    ArrayList<Integer> moves = new ArrayList<>() ;
    static int counter = 0 ;
    static boolean isPlacing = false ;
    Board board = new Board() ;
    Player white = new Player(board ,true);
    Player black = new Player(board ,false) ;
    Game game = new Game(board , white , black) ;
    char piece ;
    Player placingPlayer ;
    int previousPoint = -100 ;

    @FXML
    Label name1;
    @FXML
    Label name2 ;
    @FXML
    Label GameState ;
    @FXML
    Label turnLabel ;

    @FXML
    ImageView P;
    @FXML
    ImageView K;
    @FXML
    ImageView G;
    @FXML
    ImageView S;
    @FXML
    ImageView B;
    @FXML
    ImageView L;

    @FXML
    VBox BoxOfWhitePlayer ;
    @FXML
    VBox BoxOfBlackPlayer ;

    @FXML
    ImageView p;
    @FXML
    ImageView k;
    @FXML
    ImageView g;
    @FXML
    ImageView s;
    @FXML
    ImageView b;
    @FXML
    ImageView l;

    @FXML
    GridPane Board ;



    public void setName1(String name) {
        name1.setText(name);
    }

    public void setName2(String name) {
        name2.setText(name);
    }

    public GridPane getBoard() {
        return Board;
    }

    public void mouseClick(MouseEvent mouseEvent) {
        System.out.println(counter);
        if(isPlacing){
            int xClick = getXClick(mouseEvent.getSceneX()) ;
            int yClick = getYClick(mouseEvent.getSceneY()) ;


            int point = yClick * 10 + xClick ;
            //=====================================================
            System.out.println(point);
            if(xClick == -1 || yClick == -1){
                moves.clear();
                counter = 0 ;
                isPlacing = false ;
                return ;
            }else {
                moves.add(point) ;
                counter ++ ;
                placeAPiece(placingPlayer , moves.get(0) ,moves.get(1) );
                isPlacing = false ;
                moves.clear();
                counter = 0 ;
                return;
            }
        }
        int xClick = getXClick(mouseEvent.getSceneX()) ;
        int yClick = getYClick(mouseEvent.getSceneY()) ;

        int point = yClick * 10 + xClick ;
//=======================================
        System.out.println(point);
        if(xClick == -1 || yClick == -1 || (board.getCell(yClick - 1 , xClick - 1).getPiece() == null && counter %2 == 0 )){
            moves.clear();
            counter = 0 ;
            return ;
        }
        else {
            if(counter % 2 == 1){
                previousPoint = point ;
                moves.add(point) ;
                counter ++ ;
                playGame();


            }else {
                previousPoint = point ;
                moves.add(point) ;
                counter ++ ;
            }
        }

    }
    public int getXClick(double xClick){
        if(xClick > 100 && xClick < 180){
            return 1;
        }else if(xClick > 180 && xClick < 260){
            return 2 ;
        }else if(xClick > 260 && xClick < 340){
            return 3 ;
        }else if(xClick > 340 && xClick < 420){
            return 4 ;
        }else if(xClick > 420 && xClick < 500){
            return 5 ;
        }

        return -1 ;
    }
    public int getYClick(double yClick){
        if(yClick > 0 && yClick < 80){
            return 1;
        }else if(yClick > 80 && yClick < 160){
            return 2 ;
        }else if(yClick > 160 && yClick < 240){
            return 3 ;
        }else if(yClick > 240 && yClick < 320){
            return 4 ;
        }else if(yClick > 320 && yClick < 400){
            return 5 ;
        }

        return -1 ;
    }
    public int getYClickForBox(double yClick){
        if(yClick > 40 && yClick < 90){
            return 1 ;
        }else if(yClick > 90 && yClick < 140){
            return 2 ;
        }else if(yClick > 140 && yClick < 190){
            return 3 ;
        }else if(yClick > 190 && yClick < 240){
            return 4 ;
        }else if(yClick > 240 && yClick < 290){
            return 5 ;
        }
        else if(yClick > 290 && yClick < 340){
            return 6 ;
        }else if(yClick > 340 && yClick < 390){
            return 7 ;
        }else if(yClick > 390 && yClick < 440){
            return 8 ;
        }else if(yClick > 440 && yClick < 490){
            return 9 ;
        }
        else if(yClick > 490 && yClick < 540){
            return 10 ;
        }
        else {
            return -1 ;
        }
    }
    public void placeAPiece(Player player , int start , int end){
        int counter2 = 0 ;
        boolean isExist = false ;
        for (int i = 0; i < player.getPieces().size(); i++) {
            if(player.getPieces().get(i).getReserveCount() != 0){
                isExist = true ;
                break ;
            }
        }
        if(!isExist){
            moves.clear() ;
            counter = 0;
            return ;
        }
        if(start / 10 == -2){
            if(game.isWhiteTurn()){
                for (int i = 0; i < white.getPieces().size(); i++) {
                    if(white.getPieces().get(i).isKilled()){
                        counter2 ++ ;
                    }
                    if(counter2 == (start / 10) * 10 - start){
                        piece = white.getPieces().get(i).getSymbol() ;
                        game.placePiece(piece , white , board , 0  , end);
                        changeTurn();
                        counter = 0 ;
                        moves.clear();
                        break;
                    }
                }
            }else {
                counter = 0 ;
                return;
            }
        }else if(start / 10 == -3){
            if(!game.isWhiteTurn()){
                for (int i = 0; i < black.getPieces().size(); i++) {
                    if(black.getPieces().get(i).isKilled()){
                        counter2 ++ ;
                    }
                    if(counter2 == (start / 10) * 10 - start){
                        piece = black.getPieces().get(i).getSymbol() ;
                        game.placePiece(piece , black , board , 0  , end);
                        changeTurn();
                        counter = 0 ;
                        moves.clear();
                        break;
                    }
                }
            }else {
                counter = 0 ;
                return;
            }
        }else {
            counter = 0 ;
            return;
        }
        setBoard();
        setWBox();
        setBBox();


    }

    public void playGame(){
        if(moves.get(counter-2) == moves.get(counter-1)){
            moves.clear();
            counter = 0 ;
            setBoard();
            setBBox();
            setWBox();
            return;
        }else{
            game.movePiece(board , moves.get(counter-2) , moves.get(counter-1));
            moves.clear();
            counter = 0 ;
            setBoard();
            setBBox();
            setWBox();
            changeTurn();
            if(game.status == Status.WHITE_WIN){
                setWhiteWin();
                return;
            }else if(game.status == Status.BLACK_WIN){
                setBlackWin();
                return;
            }

        }


    }
    public void setBBox(){
        BoxOfBlackPlayer.getChildren().clear();
        boolean isExist = false ;
        for (int i = 0; i < black.getPieces().size(); i++) {
            if(black.getPieces().get(i).isKilled()){
                isExist = true ;
                break ;
            }
        }

        if(!isExist){
            return ;
        }
        for (int i = 0; i < black.getPieces().size(); i++) {
            if(black.getPieces().get(i).isKilled()){
                piece = black.getPieces().get(i).getSymbol() ;
                if(piece == 'k'){
                    Image image = new Image("Images/BlackKing.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("k");
                    BoxOfBlackPlayer.getChildren().add(pic) ;

                }else if(piece == 'K'){
                    Image image = new Image("Images/WhiteKing.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("K");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'P'){
                    Image image = new Image("Images/WhitePawn.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("P");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'p'){
                    Image image = new Image("Images/BlackPawn.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("p");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'G'){
                    Image image = new Image("Images/WhiteQueen.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("G");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'g'){
                    Image image = new Image("Images/BlackQueen.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("g");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'S'){
                    Image image = new Image("Images/WhiteKnight.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("S");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 's'){
                    Image image = new Image("Images/BlackKnight.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("s");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'B'){
                    Image image = new Image("Images/WhiteBishop.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("B");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'b'){
                    Image image = new Image("Images/BlackBishop.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("b");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'L'){
                    Image image = new Image("Images/WhiteRook.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("L");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }else if(piece == 'l'){
                    Image image = new Image("Images/BlackRook.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("l");
                    BoxOfBlackPlayer.getChildren().add(pic) ;
                }
            }
        }

    }
    public void setWBox(){
        BoxOfWhitePlayer.getChildren().clear();
        boolean isExist = false ;
        for (int i = 0; i < white.getPieces().size(); i++) {
            if(white.getPieces().get(i).isKilled() ){
                isExist = true ;
                break ;
            }
        }

        if(!isExist){
            return ;
        }
        for (int i = 0; i < white.getPieces().size(); i++) {
            if(white.getPieces().get(i).isKilled()){
                piece = white.getPieces().get(i).getSymbol() ;
                if(piece == 'k'){
                    Image image = new Image("Images/BlackKing.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("k");
                    BoxOfWhitePlayer.getChildren().add(pic) ;

                }else if(piece == 'K'){
                    Image image = new Image("Images/WhiteKing.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("K");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'P'){
                    Image image = new Image("Images/WhitePawn.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("P");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'p'){
                    Image image = new Image("Images/BlackPawn.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("p");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'G'){
                    Image image = new Image("Images/WhiteQueen.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("G");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'g'){
                    Image image = new Image("Images/BlackQueen.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("g");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'S'){
                    Image image = new Image("Images/WhiteKnight.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("S");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 's'){
                    Image image = new Image("Images/BlackKnight.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("s");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'B'){
                    Image image = new Image("Images/WhiteBishop.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("B");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'b'){
                    Image image = new Image("Images/BlackBishop.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("b");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'L'){
                    Image image = new Image("Images/WhiteRook.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("L");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }else if(piece == 'l'){
                    Image image = new Image("Images/BlackRook.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(50);
                    pic.setFitHeight(50);
                    pic.setImage(image);
                    pic.setId("l");
                    BoxOfWhitePlayer.getChildren().add(pic) ;
                }
            }
        }
    }
    public void setBoard() {
        Spot[][] cells = board.getCells() ;
        String N1 = name1.getText() ;
        String N2 = name2.getText() ;
        Board.getChildren().clear();
        setName1(N1);
        setName2(N2);
        name1.setAlignment(Pos.TOP_CENTER);
        name2.setAlignment(Pos.TOP_CENTER);
        Board.add(name1 , 0 , 1);
        Board.add(name2 , 6 , 1 );

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(cells[j][i].getPiece() != null){
                    if(cells[j][i] != null){
                        piece = cells[j][i].getPiece().getSymbol() ;
                        if(piece == 'k'){
                            Image image = new Image("Images/BlackKing.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("k");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'K'){
                            Image image = new Image("Images/WhiteKing.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("K");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'P'){
                            Image image = new Image("Images/WhitePawn.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("P");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'p'){
                            Image image = new Image("Images/BlackPawn.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("p");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'G'){
                            Image image = new Image("Images/WhiteQueen.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("G");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'g'){
                            Image image = new Image("Images/BlackQueen.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("g");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'S'){
                            Image image = new Image("Images/WhiteKnight.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("S");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 's'){
                            Image image = new Image("Images/BlackKnight.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("s");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'B'){
                            Image image = new Image("Images/WhiteBishop.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("B");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'b'){
                            Image image = new Image("Images/BlackBishop.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("b");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'L'){
                            Image image = new Image("Images/WhiteRook.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("L");
                            Board.add(pic , i+1 , j+1);
                        }else if(piece == 'l'){
                            Image image = new Image("Images/BlackRook.png");
                            ImageView pic = new ImageView();
                            pic.setFitWidth(80);
                            pic.setFitHeight(80);
                            pic.setImage(image);
                            pic.setId("l");
                            Board.add(pic , i+1 , j+1);
                        }
                    }
                }
            }
        }
    }


    public void setBlackWin(){
        GameState.setText("Black Wins!");
        GameState.setVisible(true);
        GameState.setDisable(false);
    }
    public void setWhiteWin(){
        GameState.setText("White Wins!");
        GameState.setVisible(true);
        GameState.setDisable(false);
    }


    public void moseClickForWhiteVBOX(MouseEvent mouseEvent) {
        int xClick = -2 ;
        placingPlayer = white ;
        int yClick = getYClickForBox(mouseEvent.getSceneY());
        int point = xClick * 10 - yClick ;
//======================================
        System.out.println(point);
        if(yClick != -1){
            isPlacing = true ;
            moves.clear();
            moves.add(point) ;
            counter = 1 ;
        }else {
            moves.clear();
            counter = 0 ;
            return;
        }


    }

    public void moseClickForBlackVBOX(MouseEvent mouseEvent) {
        int xClick = -3;
        placingPlayer = black ;
        int yClick = getYClickForBox(mouseEvent.getSceneY());
        int point = xClick * 10 - yClick ;
//====================================
        System.out.println(point);
        if(yClick != -1){
            isPlacing = true ;
            moves.clear();
            moves.add(point) ;
            counter = 1 ;
        }else {
            moves.clear();
            counter = 0 ;
            return;
        }

    }
    public void changeTurn(){
        if(game.status == Status.WHITE_WIN){
            turnLabel.setText("White Wins!");
            return;
        }else if(game.status == Status.BLACK_WIN){
            turnLabel.setText("Black Wins!");
            return;
        }
        if(game.isWhiteTurn()){
            turnLabel.setText("Turn : White");
            return;
        }else{
            turnLabel.setText("Turn : Black");
            return;
        }
    }
}
