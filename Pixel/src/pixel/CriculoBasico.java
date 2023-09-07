package pixel;

import java.awt.Color;

public class CriculoBasico {
    
    private Pixel pixel;

    public CriculoBasico(Pixel pixel ) {
        this.pixel = pixel;
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
        CriculoBasico circuloBasico = new CriculoBasico(pixel);
        pixel.setVisible(true);
        circuloBasico.drawCircleBasico(150, 150, 50,Color.black);

    }
    
}
