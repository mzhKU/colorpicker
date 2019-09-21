package colormixer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.scene.paint.Color;

/**
 * @author Dieter Holz
 */
public class ColorMixerPM {
	private final StringProperty applicationTitle = new SimpleStringProperty("Color Mixer");

	private final IntegerProperty red   = new SimpleIntegerProperty(0);
	private final IntegerProperty green = new SimpleIntegerProperty(0);
	private final IntegerProperty blue  = new SimpleIntegerProperty(0);

	private final ObjectProperty<Color> color = new SimpleObjectProperty<>();

	public ColorMixerPM() {
		color.bind(Bindings.createObjectBinding(() -> Color.rgb(getRed(), getGreen(), getBlue()),
                                                red, green, blue));
	}

	public String getApplicationTitle() {
		return applicationTitle.get();
	}

	public StringProperty applicationTitleProperty() {
		return applicationTitle;
	}

	public void setApplicationTitle(String applicationTitle) {
		this.applicationTitle.set(applicationTitle);
	}

	public int getRed() {
		return red.get();
	}

	public IntegerProperty redProperty() {
		return red;
	}

	public void setRed(int red) {
		this.red.set(red);
	}

	public int getGreen() {
		return green.get();
	}

	public IntegerProperty greenProperty() {
		return green;
	}

	public void setGreen(int green) {
		this.green.set(green);
	}

	public int getBlue() {
		return blue.get();
	}

	public IntegerProperty blueProperty() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue.set(blue);
	}

	public Color getColor() {
		return color.get();
	}

	public ObjectProperty<Color> colorProperty() {
		return color;
	}

	public void setColor(Color color) {
		this.color.set(color);
	}
}
