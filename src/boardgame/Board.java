package boardgame;

public class Board {
    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(){
    }

    public Board(int rows , int columns){
        if( rows < 1 || columns < 1){
            throw new BoardExeception("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int GetRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Piece piece(int row , int column){
        if(!postionExists(row, column)){
            throw new BoardExeception("Position not ond the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
       if(!positonExists(position)){
            throw new BoardExeception("Position not ond the board");
       }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece , Position position){
        if(threIsApiece(position)){
            throw new BoardExeception("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positonExists(position)){
            throw new BoardExeception("Position not ond the board");
       }
       if(piece(position) == null){
        return null;
       }
       Piece aux = piece(position);
       aux.position = null;
       pieces[position.getRow()][position.getColumn()] = null;
       return aux;
    }

    private boolean postionExists(int row , int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public Boolean positonExists(Position position){
        return postionExists(position.getRow(), position.getColumn());
    }

    public boolean threIsApiece(Position position){
        if(!positonExists(position)){
            throw new BoardExeception("Position not ond the board");
       }
        return piece(position) != null;
    }

    




}
