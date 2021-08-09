import javax.swing.*;

public class Knight extends Piece {
         public Knight(boolean isBlackPlayer){
             super(isBlackPlayer);
             this.isBlackPlayer = isBlackPlayer;
             if (isBlackPlayer == true) {
                 image= new ImageIcon("bknight.gif");
             }
             if(isBlackPlayer==false){
                 image=new ImageIcon("wknight.gif");
             }
         }
    public  boolean canMove(int startx, int starty, int endx, int endy){
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer!=Chess.position[startx][starty].isBlackPlayer) {
            if (Math.abs(startx-endx) == 2 && Math.abs(starty-endy) == 1) {
                return true;
            } else if (Math.abs(startx-endx) == 1 && Math.abs(starty-endy) == 2) {
                return true;
            }
        }
        return false;
    }
}



