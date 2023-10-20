//Lazaro Fernando Estrada Vaca
package Programs;

import java.awt.Color;
import graphics.*;

public class Rectangulo {
    private Pixel pixel;

    public Rectangulo (Pixel pixel){
        this.pixel = pixel;
    }
     
     public void dibujarRectangulo(int x1, int y1, int x2, int y2, Color c) {
        int ancho = Math.abs(x2 - x1);
        int alto = Math.abs(y2 - y1);

        drawLineDDA(x1, y1, x1 + ancho, y1, c);
        drawLineDDA(x1, y1, x1, y1 + alto, c);
        drawLineDDA(x1 + ancho, y1, x1 + ancho, y1 + alto, c);
        drawLineDDA(x1, y1 + alto, x1 + ancho, y1 + alto, c);
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
       Rectangulo rect = new Rectangulo(pixel);
       pixel.setVisible(true);
       rect.dibujarRectangulo(200, 100, 400, 200, Color.BLACK);
    }
    
}
