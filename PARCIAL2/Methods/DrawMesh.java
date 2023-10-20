package Methods;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawMesh extends Logic{
    
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.initCompsMesh();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        setBackgroundColor(Color.white);
        int gridSize = 9; // Tamaño de la malla (10x10)
        int meshSpacing = 73; // Tamaño de la malla

        int[] array1 = new int[gridSize];
        int[] array2 = new int[gridSize];

        for (int i = 0; i < gridSize; i++) {
            array1[i] = i;
            array2[i] = i;
        }
        DibujarMalla(array1, array2, meshSpacing, Color.BLACK);
        fillRectangle(1, 1, 73, 73, Color.black);

        g.drawImage(getBufferedImage(), 0, 0, null);
    }
    
}
