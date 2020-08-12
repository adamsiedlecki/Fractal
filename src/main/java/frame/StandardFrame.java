package frame;

import fractal.FractalDrawer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StandardFrame extends JFrame {
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    private final FractalDrawer fractalDrawer;

    public StandardFrame(String title, FractalDrawer fractalDrawer) throws HeadlessException {
        super(title);
        this.fractalDrawer = fractalDrawer;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fractalDrawer.draw(WIDTH, HEIGHT, g);
    }

    public void takeScreenshot(String fileName){
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.paint(img.getGraphics());
        File outputfile = new File("images/"+fileName+".png");
        try {
            ImageIO.write(img, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
