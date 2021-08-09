import javax.swing.*;
import java.awt.Color;
import java.awt.*;

public class BoardComponent extends JComponent {
    protected void paintComponent(Graphics g) {
        //draw the 64 tiles on the board
        Color LightBrown = new Color(233, 174, 95);
        Color DarkBrown = new Color(177, 113, 24);

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        g.setColor(DarkBrown);
                    } else {
                        g.setColor(LightBrown);
                    }
                    g.fillRect(j * Chess.PIECESIZE, i * Chess.PIECESIZE, Chess.PIECESIZE, Chess.PIECESIZE);
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        g.setColor(LightBrown);
                    } else {
                        g.setColor(DarkBrown);
                    }
                    g.fillRect(j * Chess.PIECESIZE, i * Chess.PIECESIZE, Chess.PIECESIZE, Chess.PIECESIZE);

                }

            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (Chess.position[x][y] != null) {
                    Chess.position[x][y].drawPiece(x, y, g);
                }
            }
        }

    }
}