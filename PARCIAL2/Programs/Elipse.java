package Programs;

import java.awt.Color;
import graphics.*;


public class Elipse {
    private Pixel pixel;

    public Elipse(Pixel pixel) {
        this.pixel = pixel;
    }
    
        public void drawEllipse(int x_centro, int y_centro, int semieje_a, int semieje_b, Color color) {
        int x = 0;
        int y = semieje_b;
        int a_cuadrado = semieje_a * semieje_a;
        int b_cuadrado = semieje_b * semieje_b;
        int dos_a_cuadrado = 2 * a_cuadrado;
        int dos_b_cuadrado = 2 * b_cuadrado;
        int p1 = b_cuadrado - a_cuadrado * semieje_b + (a_cuadrado / 4);

        // Región 1
        while (dos_b_cuadrado * x < dos_a_cuadrado * y) {
            pixel.putPixel(x_centro + x, y_centro + y, color);
            pixel.putPixel(x_centro - x, y_centro + y, color);
            pixel.putPixel(x_centro + x, y_centro - y, color);
            pixel.putPixel(x_centro - x, y_centro - y, color);

            x = x + 1;
            if (p1 < 0) {
                p1 = p1 + dos_b_cuadrado * x + b_cuadrado;
            } else {
                y = y - 1;
                p1 = p1 + dos_b_cuadrado * x + b_cuadrado - dos_a_cuadrado * y;
            }
        }
        // Región 2
        int p2 =  (int) (b_cuadrado * (x + 0.5) * (x + 0.5) + a_cuadrado * (y - 1) * (y - 1) - a_cuadrado * b_cuadrado);

        while (y > 0) {
            pixel.putPixel(x_centro + x, y_centro + y, color);
            pixel.putPixel(x_centro - x, y_centro + y, color);
            pixel.putPixel(x_centro + x, y_centro - y, color);
            pixel.putPixel(x_centro - x, y_centro - y, color);

            y = y - 1;

            if (p2 > 0) {
                p2 = p2 + a_cuadrado - dos_a_cuadrado * y;
            } else {
                x = x + 1;
                p2 = p2 + a_cuadrado - dos_a_cuadrado * y + dos_b_cuadrado * x;
            }
        }
    }

    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        Elipse elipse = new Elipse(pixel);
        pixel.setVisible(true);
        elipse.drawEllipse(250, 250, 100, 50, Color.RED);
    }
    
}
