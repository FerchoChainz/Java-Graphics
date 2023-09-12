package pixel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

//public class Pixel extends JFrame{
//    JPanel panel = new JPanel();
//    private BufferedImage buffer;
//    private Graphics graPixel;
//    
//    
//    public Pixel(){
//        this.setSize(800, 600);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setTitle("Figura");
//        
//        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
//        graPixel = (Graphics2D) buffer.createGraphics();
//    }
//    
//    public void putPixel(int x, int y, Color c){
//        buffer.setRGB(0, 0, c.getRGB());
//        this.getGraphics().drawImage(buffer, x, y, this);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//       // putPixel(100, 100, Color.red);
//    }
//    
//    
//    public static void main(String[] args) {
//        Pixel window = new Pixel();
//        window.setVisible(true);
//        
//    }
//    
//}

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {
    private BufferedImage buffer;
    private int width = 800;
    private int height = 600;

    public Pixel() {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Figura");

        // Ajusta el tamaño del BufferedImage para que coincida con el tamaño de la ventana
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Configura todos los píxeles en negro usando un bucle for
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                buffer.setRGB(x, y, Color.WHITE.getRGB());
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(x, y, c.getRGB());
        repaint(); // Vuelve a dibujar la ventana para mostrar el píxel
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(buffer, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pixel window = new Pixel();
            window.setVisible(true);
        });
    }
}
