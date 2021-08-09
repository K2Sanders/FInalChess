import javax.swing.*;

//Katie Sanders
//Steps 1 to 7 have been completed

//everything in here is static - most variables are in here
public class Chess { //chess is Main

    public static final int PIECESIZE=44;
    public static final int WIDTH=PIECESIZE*8,HEIGHT=PIECESIZE*8;
    static BoardComponent board;
    public static Piece[][] position = new Piece[8][8]; //2D array
    public static void main(String[] args){

        //White Pieces
        Chess.position[0][0]= new Rook(true);
        Chess.position[7][0]= new Rook(true);
        Chess.position[1][0]= new Knight(true);
        Chess.position[6][0]= new Knight(true);
        Chess.position[2][0]= new Bishop(true);
        Chess.position[5][0]= new Bishop(true);
        Chess.position[3][0]= new Queen(true);
        Chess.position[4][0]= new King(true);
        for(int i=0; i<8;i++){
            Chess.position[i][1]= new Pawn(true);
        }
        //Black Pieces
        Chess.position[0][7]= new Rook(false);
        Chess.position[7][7]= new Rook(false);
        Chess.position[1][7]= new Knight(false);
        Chess.position[6][7]= new Knight(false);
        Chess.position[2][7]= new Bishop(false);
        Chess.position[5][7]= new Bishop(false);
        Chess.position[4][7]= new Queen(false);
        Chess.position[3][7]= new King(false);


        for(int i=0; i<8;i++){
            Chess.position[i][6]= new Pawn(false);
        }

        //make window:
        JFrame window = new JFrame("Chess Game");
        window.setSize(WIDTH+10,HEIGHT+40);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //get mouse location on board
        BoardMouseListener mouse= new BoardMouseListener();
        board = new BoardComponent();
        window.add(board);
        board.addMouseListener(mouse);
        window.setVisible(true);
       // window.setLayout(null);

    }
}
