import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BoardMouseListener implements MouseListener{
    int startx, starty;

    public void mousePressed (MouseEvent e){
        int pressx= e.getX();
        startx=pressx/Chess.PIECESIZE;
        int pressy= e.getY();
        starty=pressy/Chess.PIECESIZE;

    }

    public void mouseReleased(MouseEvent e){
        int endx=e.getX()/Chess.PIECESIZE;
        int endy=e.getY()/Chess.PIECESIZE;

        if(startx== endx && starty==endy){
            return;
        }
        if(Chess.position[startx][starty].canMove(startx,starty,endx,endy)==false){
            return;
        }

        Chess.position[endx][endy]=Chess.position[startx][starty];
        Chess.position[startx][starty]=null;
        Chess.board.repaint();

        while(true) {
            startx = (int) (Math.random() * 8);
            starty = (int) (Math.random() * 8);
            endx = (int) (Math.random() * 8);
            endy = (int) (Math.random() * 8);

            //Starting point== ending point error
            if (startx == endx && starty == endy) {
                continue;
            }//start point == null error
            else if (Chess.position[startx][starty] == null) {
                continue;
            }
            // start point= white player error
            else if (!Chess.position[startx][starty].isBlackPlayer) {
                continue;
            }
            //Nested If statements begin
            //if end position isn't empty
            else if (Chess.position[endx][endy] != null) {
                //if end ==black player
                if (Chess.position[endx][endy].isBlackPlayer) {
                    continue;
                    //if end is white player
                } else if (!Chess.position[endx][endy].isBlackPlayer) {

                    if (Chess.position[endx][endy].canMove(startx, starty, endx, endy) == false) {
                        continue;
                    }
                    if(Chess.position[startx][starty].canMove(startx,starty,endx,endy)==true){
                        Chess.position[endx][endy] = Chess.position[startx][starty];
                        Chess.position[startx][starty] = null;
                        Chess.board.repaint();
                        break;
                    }
                }
            } else if (Chess.position[endx][endy] == null) {
                if (Chess.position[startx][starty].canMove(startx, starty, endx, endy) == false) {
                    continue;
                }
                if(Chess.position[startx][starty].canMove(startx,starty,endx,endy)==true){
                    Chess.position[endx][endy] = Chess.position[startx][starty];
                    Chess.position[startx][starty] = null;
                    Chess.board.repaint();
                    break;
                }

            }
        }
    }

    //don't need but must have:
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
}