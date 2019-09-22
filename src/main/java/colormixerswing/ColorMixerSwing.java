package colormixerswing;

import javax.swing.*;
import java.awt.*;

public class ColorMixerSwing extends JFrame {

    public ColorMixerSwing() { initUI(); }

    private void initUI() {
        /*
        var quitButton = new JButton("Quit");
        var sliderR    = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        var sliderG    = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        var sliderB    = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        Rectangle box = new Rectangle();
        box.setSize(200, 200);

        quitButton.addActionListener((event) -> System.exit(0));

        createLayout(sliderR, sliderG, sliderB, box, quitButton);

        setTitle("Color Mixer");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

         */
    }

    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
        );
    }

}

