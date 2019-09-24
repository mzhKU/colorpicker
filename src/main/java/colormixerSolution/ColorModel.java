package colormixerSolution;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorModel {
    private Color color;
    private final List<ColorListener> listeners = new ArrayList();

    public void addColorListener(ColorListener l) {
        listeners.add(l);
    }

    public void setColor(Color c) {
        this.color = c;
        for(ColorListener l : listeners) {
            l.colorValueChanged(c);
        }
    }
}
