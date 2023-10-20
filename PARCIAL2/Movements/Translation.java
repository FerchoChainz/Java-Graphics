package Movements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Translation extends JPanel {
    private BufferedImage buffer;
    private Graphics2D graPixel;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int RECT_WIDTH = 80;
    private static final int RECT_HEIGHT = 40;
    private double translateX = 0;
    private double translateY = 0;
    private double[][] rectangleVertices;
    private AnimationThread animationThread;

    public Translation() {
        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        graPixel = buffer.createGraphics();

        rectangleVertices = new double[][] {
            {-RECT_WIDTH / 2, -RECT_HEIGHT / 2, 1}, // P1
            {RECT_WIDTH / 2, -RECT_HEIGHT / 2, 1},  // P2
            {RECT_WIDTH / 2, RECT_HEIGHT / 2, 1},   // P3
            {-RECT_WIDTH / 2, RECT_HEIGHT / 2, 1}   // P4
        };

        animationThread = new AnimationThread(this);
        animationThread.start();
    }

    //aqui cambiamos las coordenadas 
private boolean moveRight = true; // Variable para controlar la dirección del movimiento
private final int stopX = 200; // Coordenada X donde se detendrá

public void updatePosition() {
    if (translateY < HEIGHT / 2) {
        // Mueve verticalmente hacia abajo hasta la mitad de la pantalla
        translateY += 1;
    } else {
        if (moveRight) {
            // Mueve horizontalmente hacia la derecha
            translateX += 1;
            if (translateX >= stopX) {
                moveRight = false;
            }
        } else {
            // Mueve horizontalmente hacia la izquierda
            translateX -= 1;
            if (translateX <= -WIDTH / 2) {
                moveRight = true;
            }
        }
    }
}




    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(x, y, c.getRGB());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        graPixel.setColor(Color.WHITE);
        graPixel.fillRect(0, 0, WIDTH, HEIGHT);

        double[][] translationMatrix = {
            {1, 0, translateX},
            {0, 1, translateY},
            {0, 0, 1}
        };

        int[] xPoints = new int[rectangleVertices.length];
        int[] yPoints = new int[rectangleVertices.length];

        for (int i = 0; i < rectangleVertices.length; i++) {
            double[] transformedVertex = multiplyMatrixAndPoint(translationMatrix, rectangleVertices[i]);
            xPoints[i] = (int) (transformedVertex[0] + (WIDTH / 2));
            yPoints[i] = (int) (transformedVertex[1]);
        }

        fillPolygon(xPoints, yPoints, Color.RED);

        g.drawImage(buffer, 0, 0, this);
    }

    private double[] multiplyMatrixAndPoint(double[][] matrix, double[] point) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            double sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j] * point[j];
            }
            result[i] = sum;
        }

        return result;
    }

    private void fillPolygon(int[] xPoints, int[] yPoints, Color fillColor) {
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int y : yPoints) {
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        for (int y = minY; y <= maxY; y++) {
            int x1 = Integer.MAX_VALUE;
            int x2 = Integer.MIN_VALUE;

            for (int i = 0; i < xPoints.length; i++) {
                int j = (i + 1) % xPoints.length;
                int xi = xPoints[i];
                int xj = xPoints[j];
                int yi = yPoints[i];
                int yj = yPoints[j];

                if ((yi <= y && yj > y) || (yj <= y && yi > y)) {
                    int x = (int) (xi + (double) (y - yi) / (double) (yj - yi) * (xj - xi));
                    if (x < x1) x1 = x;
                    if (x > x2) x2 = x;
                }
            }

            if (x1 <= x2) {
                for (int x = x1; x <= x2; x++) {
                    putPixel(x, y, fillColor);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Translation Animation Diagonal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        Translation animation = new Translation();
        frame.add(animation);

        frame.setVisible(true);
    }
}

class AnimationThread extends Thread {
    private Translation animation;

    public AnimationThread(Translation animation) {
        this.animation = animation;
    }

    @Override
    public void run() {
        while (true) {
            animation.updatePosition();
            animation.repaint();
            try {
                Thread.sleep(16); // Controla la velocidad de la animación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
