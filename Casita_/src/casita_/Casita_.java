
package casita_;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Casita_ extends JFrame{
    JPanel panel = new JPanel();
    
    
   public Casita_(){
       this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Figura");
        
   }
    public static void main(String[] args) {
        Casita_ ventana = new Casita_();
        ventana.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        g.fillOval(10, 43, 100, 100);
        g.setColor(Color.green);
        g.drawRect(10, 150, 100, 100);
        g.fillRect(10, 150, 100, 100);
        g.setColor(Color.yellow);
        g.drawRect(10, 270 , 100, 50);  
        g.fillRect(10, 270, 100, 50);
    }
    
   
}
