package colormixerSolution;

import javax.swing.*;
import java.awt.*;

public class ColorApplication extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new ColorApplication();
            frame.pack();
            frame.setVisible(true);
        });
    }

    private ColorModel model = new ColorModel();

    ColorApplication() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(1, 2, 5, 5));
        c.add(top, BorderLayout.NORTH);
        JPanel bottom = new JPanel(new FlowLayout());
        c.add(bottom, BorderLayout.CENTER);
        JPanel p;

        p = new JPanel(new GridLayout(3, 1, 3, 3));
        top.add(p);
        p.add(new ColorScrollBar(model, ColorChannel.RED, Scrollbar.HORIZONTAL, 0));

    }
}
