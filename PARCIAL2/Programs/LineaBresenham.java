package Programs;

import java.awt.Color;
import graphics.*;

public class LineaBresenham {
    private Pixel pixel;

    public LineaBresenham(Pixel pixel){
        this.pixel = pixel;
    }
    
    public void dibujarBresenhamLine(int x1, int y1, int x2, int y2, Color c){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int error = dx - dy;
        
        while (x1 != x2 || y1 != y2) {
            pixel.putPixel(x1, y1, c);
            int error2 = error * 2;
            if (error2 > -dy) {
                error -= dy;
                x1 += sx;
            }
            if (error2 < dx) {
                error += dx;
                y1 += sy;
            }
        }
    }
    
    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        LineaBresenham bresenham = new LineaBresenham(pixel);
        pixel.setVisible(true);
        
        bresenham.dibujarBresenhamLine(100, 100, 250, 200, Color.BLACK);
    }
    
}
