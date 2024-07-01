package chess;

import boardgame.Board;
import boardgame.Position;
import chess.chessPieces.King;
import chess.chessPieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8, 8);
        initalSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.GetRows()][board.getColumns()];
        for(int i = 0 ; i < board.GetRows() ; i++){
            for(int j = 0 ; j < board.getColumns() ; j++){
                mat[i][j] = (ChessPiece) board.piece(i , j);
            }
        }
        return mat;
    }
    private void initalSetup(){
        board.pleacePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.pleacePiece(new King(board , Color.BLACK), new Position(0, 4));
        board.pleacePiece(new King(board , Color.WHITE), new Position(7, 4));
    }

}
