import fractal.FractalTree;
import frame.StandardFrame;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        int angleChange = 30;
        StandardFrame standardFrame = new StandardFrame("Fractal Tree", new FractalTree(angleChange,true));
        standardFrame.takeScreenshot("fractal_tree_screen_angle_"+angleChange+"_time_"+ System.currentTimeMillis());
    }
}
