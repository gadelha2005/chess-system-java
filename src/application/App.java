package application;
import java.util.Locale;
import java.util.Scanner;

import boardgame.Position;


public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
	    Scanner sc = new Scanner(System.in);

        Position position = new Position(3, 5);

        System.out.println(position);


	    sc.close();
	}
        
    }
