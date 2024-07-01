package chess.chessPieces;

import boardgame.Board;
import chess.ChessPiece;
import javafx.scene.paint.Color;

public class Rook extends ChessPiece {
    
    public Rook(){
        super();
    }

    public Rook(Board board , chess.Color color){
        super(board, color);
    }

    public String toString(){
        return "R";
    }
}
