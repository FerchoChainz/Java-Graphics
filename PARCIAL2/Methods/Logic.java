package Methods;
import Chess.ChessBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Logic extends JComponent {

    private final BufferedImage bufferedPixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    private BufferedImage bufferedImage;

    private void putPixel(int x, int y, Color color) {
        bufferedPixel.setRGB(0, 0, color.getRGB());
        if (bufferedImage != null) {
            bufferedImage.getGraphics().drawImage(bufferedPixel, x, y, this);
        } else {
            getGraphics().drawImage(bufferedPixel, x, y, this);
        }
    }
    
    public void initCompsFill(){
        JFrame frame = new JFrame("Fill");
        Fill canvas = new Fill();
        frame.add(canvas);

        frame.setSize(510, 510);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    
    public void initCompsChessBoard(){
        JFrame frame = new JFrame("Prueba");

        ChessBoard canvas = new ChessBoard();
        frame.add(canvas);

        frame.setSize(605, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    
    public void initCompsCurves(){
        JFrame frame = new JFrame("Curvas");

        DrawCurves canvas = new DrawCurves();
        frame.add(canvas);

        frame.setSize(610, 610);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    
    public void initCompsMesh(){
        JFrame frame = new JFrame("Malla");

        DrawMesh canvas = new DrawMesh();
        frame.add(canvas);

        frame.setSize(605, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    
    public void initCompsCut(){
        JFrame frame = new JFrame("Cut");

        Cut canvas = new Cut();
        frame.add(canvas);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    
    public void initCompsTriangles(){
        JFrame frame = new JFrame("Triangulos y rombos");

        Triangles canvas = new Triangles();
        frame.add(canvas);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    //Figuras
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            putPixel(Math.round(x), Math.round(y), color);
            x += xInc;
            y += yInc;
        }
    }

    //Curvas
    public void drawInfinito(int centerX, int centerY, int size, Color color) {
    int numPoints = 100;
    double angleStep = 2 * Math.PI / numPoints;

    for (int i = 0; i < numPoints; i++) {
        double theta = i * angleStep;
        double nextTheta = (i + 1) * angleStep;

        double x1 = centerX + size * Math.cos(theta);
        double y1 = centerY + size * Math.sin(2 * theta) / 2;
        double x2 = centerX + size * Math.cos(nextTheta);
        double y2 = centerY + size * Math.sin(2 * nextTheta) / 2;

        drawLine((int) x1, (int) y1, (int) x2, (int) y2, color);
    }
}


    public void drawWideParabola(int centerX, int centerY, double a, double b, double c, double startX, double endX, double stepSize, Color color) {
        for (double x = startX; x <= endX; x += stepSize) {
            double y = a * x * x + b * x + c;
            putPixel(centerX + (int) x, centerY - (int) y, color);
        }
    }

    public void drawInvertedWideParabola(int centerX, int centerY, double a, double b, double c, double startX, double endX, double stepSize, Color color) {
        for (double x = startX; x <= endX; x += stepSize) {
            double y = -a * x * x - b * x - c;
            putPixel(centerX + (int) x, centerY + (int) y, color);
        }
    }


    public void drawHumo(double scaleFactor) {
    int numSegments = 1000; // Número de segmentos para subdividir la curva

    for (int i = 0; i < numSegments; i++) {
        double y1 = (2.0 * Math.PI * i) / numSegments;
        double y2 = (2.0 * Math.PI * (i + 1)) / numSegments;

        double x1 = y1 * Math.cos(4 * y1) * scaleFactor;
        double x2 = y2 * Math.cos(4 * y2) * scaleFactor;

        int pixelX1 = (int) (x1 * 10) + getWidth() / 2;
        int pixelY1 = (int) (y1 * 10) + 300;
        int pixelX2 = (int) (x2 * 10) + getWidth() / 2;
        int pixelY2 = (int) (y2 * 10) + 300;

        // Invierte pixelY para dibujar de arriba hacia abajo
        pixelY1 = getHeight() - pixelY1;
        pixelY2 = getHeight() - pixelY2;

        drawLine(pixelX1, pixelY1, pixelX2, pixelY2, Color.RED); // Puedes cambiar el color si lo deseas
    }
}



    public void drawFlor(int points, Color color) {
    int numSegments = points;
    double tStep = 2 * Math.PI / numSegments;
    double deltaT = 0.01; // Incremento más pequeño para una curva más suave

    int prevPixelX = 0;
    int prevPixelY = 0;
    boolean firstPoint = true;

    for (int i = 0; i < numSegments; i++) {
        double t1 = i * tStep;
        double t2 = (i + 1) * tStep;

        for (double t = t1; t < t2; t += deltaT) {
            double x = Math.cos(t) + (1.0 / 2.0) * Math.cos(7 * t) + (1.0 / 3.0) * Math.sin(17 * t);
            double y = Math.sin(t) + (1.0 / 2.0) * Math.sin(7 * t) + (1.0 / 3.0) * Math.cos(17 * t);

            int pixelX = (int) (x * 100) + getWidth() / 2;
            int pixelY = (int) (y * 100) + getHeight() / 2;

            if (!firstPoint) {
                drawLine(prevPixelX, prevPixelY, pixelX, pixelY, color);
            } else {
                firstPoint = false;
            }

            prevPixelX = pixelX;
            prevPixelY = pixelY;
        }
    }
}



    public void drawSol(int points) {
        int numPoints = points;
        double tStep = 14 * Math.PI / numPoints;

        int prevPixelX = 0;
        int prevPixelY = 0;
        boolean firstPoint = true;

        for (int i = 0; i < numPoints; i++) {
            double t = i * tStep;
            double x = 17 * Math.cos(t) + 7 * Math.cos((17.0 / 7.0) * t);
            double y = 17 * Math.sin(t) - 7 * Math.sin((17.0 / 7.0) * t);

            int pixelX = (int) (x * 10) + getWidth() / 2;
            int pixelY = (int) (y * 10) + getHeight() / 2;

            putPixel(pixelX, pixelY, Color.BLUE);

            if (!firstPoint) {
                drawLine(prevPixelX, prevPixelY, pixelX, pixelY, Color.BLUE);
            } else {
                firstPoint = false;
            }

            prevPixelX = pixelX;
            prevPixelY = pixelY;
        }
    }

    //Mallado
    public void DibujarMalla(int[] array1, int[] array2, int meshSpacing, Color color) {
    int maxX1 = Arrays.stream(array1).max().orElse(0);
    int maxY2 = Arrays.stream(array2).max().orElse(0);

    for (int x : array1) {
        int pixelX = x * meshSpacing;
        int pixelY1 = 0;
        int pixelY2 = maxY2 * meshSpacing;

        drawLine(pixelX, pixelY1, pixelX, pixelY2, color);
    }

    for (int y : array2) {
        int pixelY = y * meshSpacing;
        int pixelX1 = 0;
        int pixelX2 = maxX1 * meshSpacing;

        drawLine(pixelX1, pixelY, pixelX2, pixelY, color);
    }
}

    
    //Rellenos
    public void fillCircle(int x, int y, int radius, Color color) {
        int d = 1 - radius;
        int x1 = 0;
        int y1 = radius;

        while (x1 <= y1) {
            drawLine(x + x1, y + y1, x - x1, y + y1, color);
            drawLine(x + x1, y - y1, x - x1, y - y1, color);
            drawLine(x + y1, y + x1, x - y1, y + x1, color);
            drawLine(x + y1, y - x1, x - y1, y - x1, color);

            if (d < 0) {
                d += 2 * x1 + 3;
            } else {
                d += 2 * (x1 - y1) + 5;
                y1--;
            }
            x1++;
        }
    }

    public void fillRectangle(int x0, int y0, int x1, int y1, Color color) {
        for (int i = y0; i < y1; i++) {
            drawLine(x0, i, x1, i, color);
        }
    }
    

    public void fillEllipse(int xc, int yc, int radiusX, int radiusY, Color fillColor) {
        int radiusX2 = radiusX * radiusX;
        int radiusY2 = radiusY * radiusY;

        for (int y = yc - radiusY; y <= yc + radiusY; y++) {
            int dy = yc - y;
            int dx = (int) Math.sqrt(radiusX2 - (radiusX2 * dy * dy) / radiusY2);
            drawLine(xc - dx, y, xc + dx, y, fillColor);
        }
    }

    public void fillTriangle(int x0, int y0, int x1, int y1, int x2, int y2, Color fillColor) {
    var pixelsToFill = new ArrayList<Point>();

    // Encuentra las coordenadas mínimas y máximas
    int minX = Math.min(Math.min(x0, x1), x2);
    int maxX = Math.max(Math.max(x0, x1), x2);
    int minY = Math.min(Math.min(y0, y1), y2);
    int maxY = Math.max(Math.max(y0, y1), y2);

    // Verifica cada píxel dentro del rectángulo delimitado por las coordenadas mínimas y máximas
    for (int y = minY; y <= maxY; y++) {
        for (int x = minX; x <= maxX; x++) {
            if (pointInTriangle(x, y, x0, y0, x1, y1, x2, y2)) {
                pixelsToFill.add(new Point(x, y));
            }
        }
    }

    // Rellena los píxeles determinados en la lista
    for (var pixel : pixelsToFill) {
        putPixel(pixel.x, pixel.y, fillColor);
    }
}

    private boolean pointInTriangle(int x, int y, int x0, int y0, int x1, int y1, int x2, int y2) {
    double d0 = sign(x, y, x0, y0, x1, y1);
    double d1 = sign(x, y, x1, y1, x2, y2);
    double d2 = sign(x, y, x2, y2, x0, y0);

    return (d0 >= 0 && d1 >= 0 && d2 >= 0) || (d0 <= 0 && d1 <= 0 && d2 <= 0);
}

    private double sign(int x, int y, int x0, int y0, int x1, int y1) {
    return (x - x1) * (y0 - y1) - (x0 - x1) * (y - y1);
}


    public void fillDiamond(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3, Color fillColor) {
        int minX = Math.min(x0, Math.min(x1, Math.min(x2, x3)));
        int minY = Math.min(y0, Math.min(y1, Math.min(y2, y3)));
        int maxX = Math.max(x0, Math.max(x1, Math.max(x2, x3)));
        int maxY = Math.max(y0, Math.max(y1, Math.max(y2, y3)));

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (pointInDiamond(x, y, x0, y0, x1, y1, x2, y2, x3, y3)) {
                    putPixel(x, y, fillColor);
                }
            }
        }
    }

    private boolean pointInDiamond(int x, int y, int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3) {
        int d0 = (x - x0) * (y1 - y0) - (x1 - x0) * (y - y0);
        int d1 = (x - x1) * (y2 - y1) - (x2 - x1) * (y - y1);
        int d2 = (x - x2) * (y3 - y2) - (x3 - x2) * (y - y2);
        int d3 = (x - x3) * (y0 - y3) - (x0 - x3) * (y - y3);

        return (d0 >= 0 && d1 >= 0 && d2 >= 0 && d3 >= 0) || (d0 <= 0 && d1 <= 0 && d2 <= 0 && d3 <= 0);
    }

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
}
