package pixel;

import java.awt.Color;

public class CirculoPuntoMedio {

    private Pixel pixel;

    public CirculoPuntoMedio(Pixel pixel) {
        this.pixel = pixel;
    }

    private void drawCirclePuntoMedio(int x_centro, int y_centro, int radio, Color c) {
         int x = radio;
        int y = 0;
        int p = 1 - radio;

        // Dibuja el primer punto en cada octante

        while (x >= y) {
            y = y + 1;

            // Comprueba si el punto está dentro del círculo
            if (p <= 0) {
                p = p + 2 * y + 1;
            } else {
                x = x - 1;
                p = p + 2 * y - 2 * x + 1;
            }

            // Dibuja los puntos simétricos en los octantes restantes
            if (x < y) {
                break;
            }
            
            
            pixel.putPixel(x_centro + x, y_centro - y,c);
            pixel.putPixel(x_centro - x, y_centro - y,c);
            pixel.putPixel(x_centro + y, y_centro + x,c);
            pixel.putPixel(x_centro - y, y_centro + x,c);
            pixel.putPixel(x_centro + x, y_centro + y,c);
            pixel.putPixel(x_centro - x, y_centro + y,c);
            pixel.putPixel(x_centro + y, y_centro - x,c);
            pixel.putPixel(x_centro - y, y_centro - x,c);
    }
    }
    
    private void drawCircleBasico(int x_centro, int y_centro, int radio, Color c) {
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
        middlePointCircle.drawCirclePuntoMedio(150, 150, 100, Color.black);
    }
}
