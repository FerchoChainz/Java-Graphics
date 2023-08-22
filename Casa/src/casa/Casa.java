package casa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;


public class Casa extends JFrame implements MouseMotionListener{
    
    private JPanel panel;
    private int x, y;
    private JLabel status;
    
    public Casa(){
        this.setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Casita de tarea");
        setResizable(false);
        
        panel = new JPanel();
        panel.addMouseMotionListener(this);
        status = new JLabel("Status", JLabel.LEFT);
        getContentPane().add(status, BorderLayout.SOUTH);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //banqueta
        GradientPaint concrete = new GradientPaint(80, 80, Color.BLACK,
                100, 400, Color.LIGHT_GRAY);
        
        super.paint(g); 
        panel.setBackground(Color.WHITE);
        //banqueta
        g2.setPaint(concrete);
        g.fillRect(0, 510, 900, 400);
        g.setColor(Color.black);
        g.drawRect(0, 513, 300, 400);
        g.drawRect(308, 513, 300, 400);
        g.drawRect(616, 513, 300, 400);
        
        
        //techo
        g.setColor(new Color(222, 127, 91));
        int [] x = {150 ,250 ,250};
        int [] y = {200,100,200};
        g.fillPolygon(x, y, 3);
        
        g.fillRect(250, 100, 300, 100);
        
        int a[] = {550,650,550};
        int b[] = {200,200,100};
        g.fillPolygon(a, b, 3);
        
        //cuerpo de la casa
        g.setColor(new Color(255, 243, 183));
        g.fillRect(180, 200, 440, 300);
        g.setColor(Color.black);
        g.drawRect(180, 200, 440, 300);
        
        //Ventanas superiores Izquierda
        g.setColor(new Color(233, 250, 254));
        g.fillRect(200, 220, 60, 80);
        g.fillRect(280, 220, 60, 80);
        
        //Ventanas superiores Derecha 
        g.fillRect(470, 220, 60, 80);
        g.fillRect(550, 220, 60, 80);
        
        //Ventanas inferiores Izquierda
        g.fillRect(200, 390, 100, 80);
        
        
        //ventanas inferiores derecha
        g.fillRect(490, 390, 100, 80);
        
        g.setColor(Color.black);
        g.drawRect(200, 220, 60, 80);
        g.drawRect(280, 220, 60, 80);
        g.drawRect(470, 220, 60, 80);
        g.drawRect(550, 220, 60, 80);
        g.drawRect(200, 390, 100, 80);
        g.drawRect(490, 390, 100, 80);
        
        //Triangulos de la casa
        g.setColor(new Color(222, 127, 91));
        int xTriangleBack [] = {310, 410, 510};
        int yTriengleBack [] = {320, 300, 320};
        g.fillPolygon(xTriangleBack, yTriengleBack, 3);
        g.setColor(Color.black);
        g.drawPolygon(xTriangleBack, yTriengleBack, 3);
        
        
        g.setColor(new Color(185, 133, 58));
        int xTriangle [] = {310, 410, 510};
        int yTriengle [] = {320, 305, 320};
        g.fillPolygon(xTriangle, yTriengle, 3);
        g.setColor(Color.black);
        g.drawPolygon(xTriangle, yTriengle, 3);
        
        //columnas de la puerta
        g.setColor(new Color(190, 175, 133));
        g.fillRect(325, 320, 10, 180);
        g.fillRect(465, 320, 10, 180);
        g.setColor(Color.black);
        g.drawRect(325, 320, 10, 180);
        g.drawRect(465, 320, 10, 180);
        
        //escalones de la puerta
        g.setColor(new Color(208, 208, 209));
        g.fillRect(335, 495, 130, 5);
        g.fillRect(340, 505, 120, 5);
        g.fillRect(340, 490, 120, 5);
        g.setColor(Color.black);
        g.drawRect(340, 505, 120, 5);
        g.drawRect(340, 490, 120, 5);
        g.drawRect(335, 495, 130, 5);
        
        //puerta
        g.setColor(new Color(147,108,71));
        g.fillRect(345, 380, 110, 110);
        g.setColor(Color.black);
        g.drawRect(345, 380, 110, 110);
        g.drawRect(348, 382, 50, 106);
        g.drawRect(401, 382, 50, 106);
       
       
        
        //separador de la casa 
        g.setColor(new Color(185, 133, 58));
        g.fillRect(180, 320, 440, 10);
        g.setColor(Color.black);
        g.drawRect(180, 320, 440, 10);
        
    }
    
    
    
    public static void main(String[] args) {
        Casa casa = new Casa();
        casa.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        status.setText("x= " + e.getX() + ",y= " + e.getY());
    }

}