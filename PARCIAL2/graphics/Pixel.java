package graphics;

import static java.awt.Color.blue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Pixel extends javax.swing.JFrame{
    JFrame panel = new JFrame();
     private final BufferedImage bufferedPixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    private BufferedImage bufferedImage;

    
    public Pixel() {
        init();
        
    }

    public void init(){
        
        setTitle("Pixel");
        setSize(500,600);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);    }

    public void putPixel(int x, int y, Color color) {
        bufferedPixel.setRGB(0, 0, color.getRGB());
        if (bufferedImage != null) {
            bufferedImage.getGraphics().drawImage(bufferedPixel, x, y, this);
        } else {
            getGraphics().drawImage(bufferedPixel, x, y, this);
        }
    }

    
//    public void paint(Graphics g){
//        paint(g);
//        putPixel(10,10, Color.RED);
//    }
//
//    public Color getPixelColor(int x, int y) {
//        // Obtén el color del píxel en la ubicación (x, y) del buffer de la imagen
//        if (x >= 0 && x < buffer.getWidth() && y >= 0 && y < buffer.getHeight()) {
//            int rgb = buffer.getRGB(x, y);
//            return new Color(rgb);
//        } else {
//            // Devuelve un valor predeterminado (por ejemplo, Color.BLACK) o maneja el error de tu elección
//            return Color.BLACK;
//        }
//    }
    
    public void clear() {
        bufferedImage = null;
        repaint();
    }

    public void setBackgroundColor(Color color) {
        BufferedImage bufferedImg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImg.getGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.dispose();
        this.bufferedImage = bufferedImg;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public static void main(String[] args) {
        
        new Pixel();
    }


}