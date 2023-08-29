package algoritmodda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Pixel extends JFrame{
    JPanel panel = new JPanel();
    private BufferedImage buffer;
    private Graphics graPixel;
    
    
    public Pixel(){
        this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Figura");
        
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
    }
    
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        putPixel(100, 100, Color.red);
    }
    
    
    public static void main(String[] args) {
        Pixel window = new Pixel();
        window.setVisible(true);
    }
    
}
