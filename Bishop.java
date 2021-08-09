import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image = new ImageIcon("bbishop.gif");
        }
        if (isBlackPlayer == false) {
            image = new ImageIcon("wbishop.gif");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy) {
        //Make sure the end position isn't you're own color
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer != Chess.position[startx][starty].isBlackPlayer) {
            //make sure it moves diagonally
            if (Math.abs(starty - endy) == Math.abs(startx - endx)) {
                //move towards top left
                if (startx > endx && starty > endy) {
                    for (int x = startx - 1, y = starty - 1; x > endx && y > endy; x--, y--) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                    //move bottom right
                } else if (startx < endx && starty < endy) {
                    for (int x = startx + 1, y = starty + 1; x < endx && y < endy; x++, y++) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }//move towards top right
                else if (startx > endx && starty < endy) {
                    for (int x = startx - 1, y = starty + 1; x > endx && y < endy; x--, y++) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //move bottom left
                else if (startx < endx && starty > endy) {
                    for (int x = startx + 1, y = starty - 1; x < endx && y > endy; x++, y--) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            //same spot
            if (starty == endy || startx == endx) {
                return false;
            }

        }
        //everything else
        return false;
    }
}