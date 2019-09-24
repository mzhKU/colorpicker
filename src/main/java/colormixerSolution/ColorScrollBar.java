package colormixerSolution;

import javax.swing.JScrollBar;
import java.awt.*;

public class ColorScrollBar extends JScrollBar implements ColorListener {

    private ColorModel model;

    public ColorScrollBar(ColorModel model, ColorChannel channel, int orientation, int val) {
        super(orientation, val, 0, 0, 255);
        this.model = model;
        setBackground(channel.getColor());

        model.addColorListener(this);
    }

    @Override
    public void colorValueChanged(Color c) {
        model.setColor(c);
    }
}
