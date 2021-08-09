import javax.swing.*;
public class Pawn extends Piece {
    public Pawn(boolean isBlackPlayer) {
        super(isBlackPlayer);
        this.isBlackPlayer = isBlackPlayer;
        if (isBlackPlayer == true) {
            image = new ImageIcon("bpawn.gif");
        }
        if (isBlackPlayer == false) {
            image = new ImageIcon("wpawn.gif");
        }
    }

    public boolean canMove(int startx, int starty, int endx, int endy) {
        if (Chess.position[endx][endy] == null || Chess.position[endx][endy].isBlackPlayer != Chess.position[startx][starty].isBlackPlayer) {
            //white pawn
            if (!Chess.position[startx][starty].isBlackPlayer) {
                if (endx == startx) {
                    if (starty == 6) {
                        if (Chess.position[startx][starty + 1] == null) {
                            if (starty - endy <= 2) {
                                return true;
                            }
                        }
                        if (Chess.position[endx][endy] == Chess.position[startx][starty + 1]) {
                            return false;
                        }
                        if (Chess.position[startx][starty - 1] == null) {
                            if (starty - endy <= 2) {

                                return true;
                            }
                        }
                    }
                }
                if (endx == startx) {
                    if (starty - endy == 1) {
                        if (Chess.position[endx][endy] == null)
                            return true;
                    }
                } else if (Math.abs(endx - startx) == 1) {
                    if (starty - endy == 1) {
                        if (Chess.position[endx][endy] != null) {
                            if (Chess.position[endx][endy].isBlackPlayer == true) {
                                return true;
                            }
                        }
                    }
                } else if (endy == 0) {
                    Chess.position[endx][endy] = null;
                    Chess.position[endx][endy] = new Queen(false);
                }
            }
            // Black Pawn
            if (Chess.position[startx][starty].isBlackPlayer) {
                if (endx == startx) {
                    if (starty == 1) {
                        if (Chess.position[startx][starty - 1] == null) {
                        }
                        if (Chess.position[startx][starty + 1] == null) {
                            if (endy - starty <= 2 && endy - starty > 0) {
                                return true;
                            }
                        }
                    }
                    if (endy - starty == 1) {
                        if (Chess.position[endx][endy] == null) {
                            return true;

                        } else if (Math.abs(endx - startx) == 1) {
                            if (endy - starty == 1) {
                                if (Chess.position[endx][endy] != null) {
                                    if (Chess.position[endx][endy].isBlackPlayer) {
                                        return true;
                                    }
                                }
                            }
                        } else if (endy - starty > 2) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}