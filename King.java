import javax.swing.*;
public class King extends Piece {
    public King(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image= new ImageIcon("bking.gif");
        }
        if(isBlackPlayer==false){
            image=new ImageIcon("wking.gif");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy) {
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer != Chess.position[startx][starty].isBlackPlayer) {

            if (Math.abs(startx-endx) == 1 && starty-endy == 0) {
                return true;
            } else if (Math.abs(starty-endy) == 1 && startx-endx == 0) {
                return true;
            } else if (Math.abs(startx-endx) == 1 && Math.abs(starty-endy) == 1) {
                return true;
            }
        }
        return false;
    }
}
