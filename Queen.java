import javax.swing.*;

public class Queen extends Piece {
    public Queen(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image= new ImageIcon("bqueen.gif");
        }
        if(isBlackPlayer==false){
            image=new ImageIcon("wqueen.gif");
        }
    }
    public boolean canMove(int startx, int starty, int endx, int endy) {
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer!=Chess.position[startx][starty].isBlackPlayer) {
            //Rook moves
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
                if (startx > endx) { //Y isn't changing only X is - moving right to left
                    for (int x = startx - 1; x > endx; x = x - 1) {
                        if (Chess.position[x][endy] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //moving right
                else if (startx < endx) {
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
            //bishop moves
            if (Math.abs(starty - endy) == Math.abs(startx - endx)) {
                //move towards top left
                if (startx > endx && starty > endy) {
                    for (int x = startx - 1, y = starty - 1; x > endx && y > endy; x--, y--) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //move bottom right
                else if (startx < endx && starty < endy) {
                    for (int x = startx + 1, y = starty + 1; x < endx && y < endy; x++, y++) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //move towards top right
                else if (startx > endx && starty < endy) {
                    for (int x = startx - 1, y = starty + 1; x > endx && y < endy; x--, y++) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //Move bottom left
                else if (startx < endx && starty > endy) {
                    for (int x = startx + 1, y = starty - 1; x < endx && y > endy; x++, y--) {
                        if (Chess.position[x][y] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }

        }
        //everything else
        return false;
    }
}