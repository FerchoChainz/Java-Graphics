package Programs;

import java.awt.Color;
import graphics.*;

public class Figuras {
    private Pixel pixel;

    public Figuras(Pixel pixel) {
        this.pixel = pixel;
    }
    
    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        AlgoritmoDDA a = new AlgoritmoDDA(pixel);
        
        LineaBresenham bresenham = new LineaBresenham(pixel);
        bresenham.dibujarBresenhamLine(100, 100, 200, 200, Color.red);
        a.drawLineDDA(210, 200, 280, 200, Color.red);
        bresenham.dibujarBresenhamLine(290, 200, 390, 100, Color.red);
        
        Rectangulo rect = new Rectangulo(pixel);
        rect.dibujarRectangulo(100, 400, 300, 500, Color.BLACK);
        rect.dibujarRectangulo(120, 430, 280, 470, Color.red);
        
        CirculoPuntoMedio circuloPuntoMedio = new CirculoPuntoMedio(pixel);
        circuloPuntoMedio.drawCircleBasico(450, 350, 100, Color.black);
        circuloPuntoMedio.dibujarCirclePuntoMedio(450, 350, 60, Color.red);
        circuloPuntoMedio.dibujarCirclePuntoMedio(450, 350, 40, Color.red);
        circuloPuntoMedio.dibujarCirclePuntoMedio(450, 350, 20, Color.red);
                
        Elipse e = new Elipse(pixel);
        e.drawEllipse(250, 270, 100, 50, Color.RED);
        e.drawEllipse(250, 270, 80, 40, Color.RED);
        e.drawEllipse(250, 270, 50, 25, Color.RED);
        e.drawEllipse(250, 270, 25, 12, Color.RED);
        
        CirculoPolar circuloPolar = new CirculoPolar(pixel);
        circuloPolar.dibujarCirclePolar(450,350,500,400, Color.black);
        pixel.setVisible(true);
    }
    
}
