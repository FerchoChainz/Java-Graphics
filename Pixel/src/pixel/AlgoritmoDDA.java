package pixel;

import java.awt.Color;

public class AlgoritmoDDA{
    private Pixel pixel;
    
    public AlgoritmoDDA(Pixel pixel){
        this.pixel = pixel;
    }
    
    public void drawLineDDA(int x0, int y0, int x1, int y1, Color c) {
        int dx = x1 - x0;
        int dy = y1 - y0;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        double xIncrement = (double) dx / steps;
        double yIncrement = (double) dy / steps;

        double x = x0;
        double y = y0;

        for (int i = 0; i <= steps; i++) {
            pixel.putPixel((int) Math.round(x), (int) Math.round(y), c);
            x += xIncrement;
            y += yIncrement;
        }
    }

    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        AlgoritmoDDA dda = new AlgoritmoDDA(pixel);
        pixel.setVisible(true);
        dda.drawLineDDA(100, 100, 250, 200, Color.red);
        dda.drawLineDDA(100, 100, 100, 200, Color.green);
        dda.drawLineDDA(100, 300, 350, 200, Color.red);
        
    }
    
}
