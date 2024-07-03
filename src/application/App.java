package application;
import java.util.Locale;
import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;


public class App {
    public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        int n = 1;

        while (n == 1) {
            UI.printBoard(chessMatch.getPieces());
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            sc.nextLine();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);
    
            ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
        }
    
        sc.close();
    }
    }

