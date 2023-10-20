package Programs;

import java.awt.Color;
import graphics.*;


public class CirculoPuntoMedio {

    private Pixel pixel;

    public CirculoPuntoMedio(Pixel pixel) {
        this.pixel = pixel;
    }

public void dibujarCirclePuntoMedio(int xc, int yc, int radius, Color color) {
        int x = 0;
        int y = radius;
        int d = 1 - radius;

        pixel.putPixel(xc + x, yc + y, color);
        pixel.putPixel(xc + x, yc - y, color);
        pixel.putPixel(xc - x, yc + y, color);
        pixel.putPixel(xc - x, yc - y, color);
        pixel.putPixel(xc + y, yc + x, color);
        pixel.putPixel(xc + y, yc - x, color);
        pixel.putPixel(xc - y, yc + x, color);
        pixel.putPixel(xc - y, yc - x, color);

        while (y > x) {
            if (d < 0) {
                d += 2 * x + 3;
                x++;
            } else {
                d += 2 * (x - y) + 5;
                x++;
                y--;
            }

            pixel.putPixel(xc + x, yc + y, color);
            pixel.putPixel(xc + x, yc - y, color);
            pixel.putPixel(xc - x, yc + y, color);
            pixel.putPixel(xc - x, yc - y, color);
            pixel.putPixel(xc + y, yc + x, color);
            pixel.putPixel(xc + y, yc - x, color);
            pixel.putPixel(xc - y, yc + x, color);
            pixel.putPixel(xc - y, yc - x, color);
        }
    }    
    public void drawCircleBasico(int x_centro, int y_centro, int radio, Color c) {
        for (int i = 0; i <=1; i++){
            for (int x = -radio; x <= radio; x++) {
                int y = (int) Math.sqrt(radio * radio - x * x); // Ecuación del círculo
                pixel.putPixel(x_centro + x, y_centro + y, c);
                pixel.putPixel(x_centro + x, y_centro - y, c);
            }
        }
    }
    
    
    
    

    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        CirculoPuntoMedio middlePointCircle = new CirculoPuntoMedio(pixel);
        pixel.setVisible(true);

        middlePointCircle.drawCircleBasico(250, 250, 100, Color.black);
        middlePointCircle.dibujarCirclePuntoMedio(150, 150, 100, Color.black);
    }
}
