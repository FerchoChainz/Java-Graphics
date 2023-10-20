package Methods;

import java.awt.Color;
import java.awt.Graphics;


public class Triangles extends Logic{
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.initCompsTriangles();
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackgroundColor(Color.WHITE);
        

        fillTriangle(100, 300, 200, 300, 150, 200, Color.green);
        fillDiamond(100, 100, 150, 150, 200, 100, 150, 50, Color.yellow);

        g.drawImage(getBufferedImage(), 0, 0, null);
    }
}
