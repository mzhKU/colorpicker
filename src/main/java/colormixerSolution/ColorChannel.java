package colormixerSolution;

import java.awt.Color;

public enum ColorChannel {
    RED(Color.RED) {
        @Override
        public int getValue(Color color) { return color.getRed(); }

        @Override
        public Color modifiedColor(Color color, int value) {
            return new Color(value, color.getGreen(), color.getBlue());
        }
    };


    ColorChannel(Color color) { this.color = color; }

    private Color color;
    public Color getColor() { return color; }

    public abstract int getValue(Color color);
    public abstract Color modifiedColor(Color color, int value);
}
