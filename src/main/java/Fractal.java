import javax.swing.*;
import java.awt.*;

public class Fractal extends JFrame {

    private final int WIDTH = 1500;
    private final int HEIGHT = 800;

    public Fractal() {
        super("Fractal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setBackground(Color.BLACK);
        setSize(WIDTH, HEIGHT);
    }



    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        paintFractal(130,10,WIDTH/3, HEIGHT/5, g);
    }

    private void paintFractal(int length, int angle, int x, int y, Graphics g){
        System.out.println("RADIANS: "+Math.toRadians(angle));
        System.out.println("SIN: "+Math.cos(Math.toRadians(angle)));
        System.out.println("COS: "+Math.cos(Math.toRadians(angle)));

        int xmove = (int) (Math.cos(Math.toRadians(angle))*length);
        int ymove = (int) (Math.sin(Math.toRadians(angle))*length);

        sleepMillis(1);
        g.setColor(Color.WHITE);
        System.out.println("x: "+x+" y: "+y+" xmove:"+xmove+" ymove: "+ymove);
        g.drawLine(x,y,(x+xmove), (y+ymove));

        if(length>=1){
            paintFractal(length-10,angle+30,x+xmove, y+ymove, g);
            paintFractal(length-10,angle-30,x+xmove, y+ymove, g);
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
