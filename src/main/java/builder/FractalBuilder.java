package builder;

import fractal.FractalTree;
import fractal.SchrinkingTriangle;
import frame.StandardFrame;

public class FractalBuilder {

    public static void getFractalTreeAllDegrees() {
        for (int i = 0; i <= 500; i++) {
            int angleChange = i;
            StandardFrame standardFrame = new StandardFrame("Fractal Tree angle: " + angleChange, new FractalTree(angleChange, true));
            standardFrame.takeScreenshot("fractal_tree_angle_" + angleChange);
        }
    }

    public static void getFractalTree30Degrees() {
        int angleChange = 30;
        StandardFrame standardFrame = new StandardFrame("Fractal Tree angle: " + angleChange, new FractalTree(angleChange, true));
        standardFrame.takeScreenshot("fractal_tree_angle_" + angleChange);

    }

    public static void getSchrinkingTriangle() {
        StandardFrame standardFrame = new StandardFrame("Schrinking triangle ", new SchrinkingTriangle());
        standardFrame.takeScreenshot("schrinking_triangle");
    }
}
