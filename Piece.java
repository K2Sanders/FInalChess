import javax.swing.*;
import java.awt.*;

abstract class Piece {
    boolean isBlackPlayer;
    ImageIcon image;
    public Piece(boolean isBlackPlayer) {}
    public abstract boolean canMove (int startx, int starty, int endx, int endy);


    public void drawPiece (int x, int y, Graphics g){
        g.drawImage(image.getImage(), x * Chess.PIECESIZE, y * Chess.PIECESIZE, null);
    }
}