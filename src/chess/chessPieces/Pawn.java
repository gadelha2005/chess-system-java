package chess.chessPieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    
    private ChessMatch chessMatch;

    public Pawn(Board board , Color color , ChessMatch chessMatch){
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves(){
        boolean[][] mat = new boolean[getBoard().GetRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);

        if(getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1 , position.getColumn());
            if(getBoard().positonExists(p) && ! getBoard().threIsApiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2 , position.getColumn());
            Position p2 = new Position(position.getRow() - 1 , position.getColumn());
            if(getBoard().positonExists(p) && ! getBoard().threIsApiece(p) && getBoard().positonExists(p2) && ! getBoard().threIsApiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1 , position.getColumn() - 1);
            if(getBoard().positonExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1 , position.getColumn() + 1);
            if(getBoard().positonExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // #especialmove en passant white
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positonExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnpassantVulnerable()){
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positonExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnpassantVulnerable()){
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }
        else{
            p.setValues(position.getRow() + 1 , position.getColumn());
            if(getBoard().positonExists(p) && ! getBoard().threIsApiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2 , position.getColumn());
            Position p2 = new Position(position.getRow() + 1 , position.getColumn());
            if(getBoard().positonExists(p) && ! getBoard().threIsApiece(p) && getBoard().positonExists(p2) && ! getBoard().threIsApiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1 , position.getColumn() - 1);
            if(getBoard().positonExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1 , position.getColumn() + 1);
            if(getBoard().positonExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

             // #especialmove en passant black
             if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positonExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnpassantVulnerable()){
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positonExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnpassantVulnerable()){
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }



        return mat;
    }

    @Override
    public String toString(){
        return "P";
    }

}
