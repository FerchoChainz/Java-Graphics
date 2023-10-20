package Programs;

import java.awt.Color;
import graphics.*;

public class CirculoPolar {

    private Pixel pixel;
    
    public CirculoPolar(Pixel pixel){
        this.pixel = pixel;
    }
    
    public void dibujarCirclePolar(int xcenter, int ycenter, int x, int y, Color color) {
        int teta;
        int Segments = 360;
        int radio = (int) Math.sqrt(Math.pow((x - xcenter), 2) + Math.pow((y - ycenter), 2));


        for (int i = 0; i <= 1; i++) {
            for (teta = 0; teta < Segments; teta++) {
                x = (int) (xcenter + (radio * Math.cos(teta)));
                y = (int) (ycenter + (radio * Math.sin(teta)));
                pixel.putPixel(x, y, color);
            }
        }
    }
    
    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        CirculoPolar circuloPolar = new CirculoPolar(pixel);
        pixel.setVisible(true);
        
        circuloPolar.dibujarCirclePolar(300,250,350,300, Color.black);
    }
    
}
