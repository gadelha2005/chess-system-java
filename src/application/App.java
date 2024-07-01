package application;
import java.util.Locale;
import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;


public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
	    Scanner sc = new Scanner(System.in);

        Position pos = new Position(8, 2);
        System.out.println(pos);

	}
        
    }

