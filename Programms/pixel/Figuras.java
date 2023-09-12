package pixel;

import java.awt.Color;

public class Figuras {
    private Pixel pixel;
    private AlgoritmoDDA algoritmoDDA;

    public Figuras(Pixel pixel) {
        this.pixel = pixel;
    }
    
    public void Lineas(AlgoritmoDDA algoritmoDDA){
        algoritmoDDA.drawLineDDA(100, 100, 100, 200, Color.green);
    }
    
    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        Figuras figuras = new Figuras(pixel);
        figuras.
        pixel.setVisible(true);
    }
    
}
