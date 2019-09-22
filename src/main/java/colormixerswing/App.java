package colormixerswing;

import static javax.swing.SwingUtilities.invokeLater;

public class App {
    public static void main(String[] args) {

        ColorMixerModel model = new ColorMixerModel();


        invokeLater(() -> {
            ColorMixerSwing colorMixerSwing = new ColorMixerSwing();
            colorMixerSwing.setVisible(true);
        });
    }
}
