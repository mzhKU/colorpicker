package colormixer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;

public class ColorMixerUI extends GridPane {
    private final ColorMixerPM model;

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private Label redValue;
    private Label blueValue;
    private Label greenValue;

    private Rectangle display;

    public ColorMixerUI(ColorMixerPM model) {
        this.model = model;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        // String stylesheet = getClass().getResource("style.css").toExternalForm();
        // getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        redSlider   = new Slider(0.0, 255, 0);
        greenSlider = new Slider(0.0, 255, 0);
        blueSlider  = new Slider(0.0, 255, 0);

        redValue   = new Label();
        greenValue = new Label();
        blueValue  = new Label();

        display = new Rectangle();
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        ColumnConstraints sliderColumn = new ColumnConstraints();
        sliderColumn.setHgrow(Priority.ALWAYS);

        ColumnConstraints valueColumn = new ColumnConstraints(30);
        valueColumn.setHalignment(HPos.RIGHT);

        getColumnConstraints().addAll(sliderColumn, valueColumn);

        addRow(0, redSlider  , redValue);
        addRow(1, greenSlider, greenValue);
        addRow(2, blueSlider , blueValue);

        add(display, 0, 3, 2, 1);

        setPrefHeight(getPrefHeight() + 200);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
        redSlider.valueProperty().bindBidirectional(model.redProperty());
        redValue.textProperty().bind(model.redProperty().asString());

        greenSlider.valueProperty().bindBidirectional(model.greenProperty());
        greenValue.textProperty().bind(model.greenProperty().asString());

        blueSlider.valueProperty().bindBidirectional(model.blueProperty());
        blueValue.textProperty().bind(model.blueProperty().asString());

        display.fillProperty().bind(model.colorProperty());

        display.widthProperty().bind(widthProperty().subtract(20));
        display.heightProperty()
               .bind(heightProperty().subtract(redSlider.heightProperty())
                                     .subtract(greenSlider.heightProperty())
                                     .subtract(blueSlider.heightProperty())
                                     .subtract(50));
    }
}
