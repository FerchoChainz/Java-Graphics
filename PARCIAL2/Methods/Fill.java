package Methods;
import java.awt.*;

public class Fill extends Logic {
    public static void main(String[] args) {
       Logic logic = new Logic();
       logic.initCompsFill();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        setBackgroundColor(Color.WHITE);
        fillCircle(250, 250, 50, Color.GREEN);
//        fillEllipse(250, 250, 20, 30, Color.RED);
        fillCircle(350, 250, 50, Color.GREEN);
//        fillEllipse(350, 250, 20, 30, Color.RED);
//        fillDiamond(100, 150, 200, 100, 300, 150, 200, 200, Color.yellow);
        fillRectangle(0, 0, 100, 100, Color.yellow);
        g.drawImage(getBufferedImage(), 0, 0, null);
    }

   
}
