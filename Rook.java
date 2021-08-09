import javax.swing.*;
public class Rook extends Piece {
    public Rook(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image = new ImageIcon("brook.gif");
        }
        if (isBlackPlayer == false) {
            image = new ImageIcon("wrook.gif");
        }
    }
    public boolean canMove(int startx, int starty, int endx, int endy) {
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer != Chess.position[startx][starty].isBlackPlayer) {

            if (startx == endx) {
                //moving up
                if (starty > endy) {
                    for (int y = starty - 1; y > endy ; y = y - 1) {
                        if (Chess.position[startx][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //Check downwards
                else if (starty < endy) {
                    for (int y = starty + 1; y < endy; y = y + 1) {
                        if (Chess.position[startx][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            if (starty == endy) {
                if (startx > endx) { //Y isn't changing only X is - moving left
                    for (int x = startx - 1; x > endx; x = x - 1) {
                        if (Chess.position[x][endy] != null) {
                            return false;
                        }
                    }
                    return true;
                    //moving right
                } else if (startx < endx) {
                    for (int x = startx + 1; x < endx; x = x + 1) {
                        if (Chess.position[x][endy] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            //same spot
            else if (starty == endy || startx == endx) {
                return false;
            }
        }
        //everything else
        return false;
    }
}