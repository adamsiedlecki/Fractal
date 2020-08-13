package fractal;

import java.awt.*;

public class FractalTree implements FractalDrawer {

    private final boolean bottomToTop;
    private final int angleChange;

    public FractalTree(int angleChange, boolean bottomToTop) {
        this.bottomToTop = bottomToTop;
        this.angleChange = angleChange;
    }

    @Override
    public void draw(int frameWidth, int frameHeight, Graphics g) {
        int angleStart;
        int posX;
        int posY;

        if(bottomToTop){
            angleStart = 270;
            posX = frameWidth/2;
            posY = frameHeight/6*5;

        }else{
            angleStart = 90;
            posX = frameWidth/2;
            posY = frameHeight/6;
        }
        paintFractal(130,angleStart,posX, posY, g);
    }

    private void paintFractal(int length, int angleStart, int x, int y, Graphics g){
        System.out.println("RADIANS: " + Math.toRadians(angleStart));
        System.out.println("SIN: " + Math.cos(Math.toRadians(angleStart)));
        System.out.println("COS: " + Math.cos(Math.toRadians(angleStart)));

        int xmove = (int) (Math.cos(Math.toRadians(angleStart)) * length);
        int ymove = (int) (Math.sin(Math.toRadians(angleStart)) * length);

        //sleepMillis(1);
        g.setColor(Color.WHITE);
        System.out.println("x: " + x + " y: " + y + " xmove:" + xmove + " ymove: " + ymove);
        g.setFont(new Font("Bungee Inline", Font.BOLD, 20));
        g.drawString("fractal fun", 60, 60);
        g.drawLine(x, y, (x + xmove), (y + ymove));


        if (length >= 1) {
            paintFractal(length - 10, angleStart + angleChange, x + xmove, y + ymove, g);
            paintFractal(length - 10, angleStart - angleChange, x + xmove, y + ymove, g);
        }
    }

    private void sleepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
