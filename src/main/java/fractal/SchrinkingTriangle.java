package fractal;

import java.awt.*;

public class SchrinkingTriangle implements FractalDrawer {

    private static int counter = 0;

    public SchrinkingTriangle() {
    }

    @Override
    public void draw(int frameWidth, int frameHeight, Graphics g) {
        // h = a * sqrt3 /2
        // a = 2h/ sqrt3

        int x1 = frameWidth / 2;
        int y1 = frameHeight / 6;
        int x2 = 0;
        int y2 = frameHeight / 6 * 5;
        int x3 = 0;
        int y3 = frameHeight / 6 * 5;

        int h = y2 - y1;
        int a = (int) (2 * h / Math.sqrt(3));
        int xDifference = a / 2;
        x2 = x1 - xDifference;
        x3 = x1 + xDifference;

        paintTriangle(x1, y1, x2, y2, x3, y3, g);
    }

    private void paintTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) {
        int numOfTriangles = 3 ^ counter;

        //sleepMillis(1);
        g.setColor(Color.WHITE);
        //System.out.println("x: "+x+" y: "+y+" xmove:"+xmove+" ymove: "+ymove);
        g.setFont(new Font("Bungee Inline", Font.BOLD, 20));
        g.drawString("fractal fun", 60, 60);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

        int next_x1;
        int next_y1;
        int next_x2;
        int next_y2;
        int next_x3;
        int next_y3;

        if (counter % 2 == 0) {
            next_x1 = x3 + (x1 - x3) / 2;
            next_y1 = y1 + (y3 - y1) / 2;
            next_x2 = x1 + (x2 - x1) / 2;
            next_y2 = next_y1;
            next_x3 = x3 + (x2 - x3) / 2;
            next_y3 = y3;
        } else {
            next_x1 = x1 + (x2 - x1) / 2;
            next_y1 = y1;
            next_x2 = x3 + (x2 - x3) / 2;
            next_y2 = y2 + (y3 - y2) / 2;
            next_x3 = x1 + (x3 - x1) / 2;
            next_y3 = next_y2;
        }

        counter++;
        if (x3 - x2 < 10) {
            // STOP
        } else {
            paintTriangle(next_x1, next_y1, next_x2, next_y2, next_x3, next_y3, g);
        }
    }

    private void sleepMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
