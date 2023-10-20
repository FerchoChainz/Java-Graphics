package Methods;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawCurves extends Logic{
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.initCompsCurves();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackgroundColor(Color.WHITE);
        
//        drawInfinito(400, 300, 80, Color.RED);
//        drawInvertedWideParabola(400, 100, -0.1, 0.0, -50.0, -50.0, 50.0, 0.1, Color.BLACK);
//        drawHumo(2);
//        drawFlor(1000,Color.RED);
        drawSol(2000);
//        
        g.drawImage(getBufferedImage(), 0, 0, null);
    }
}
