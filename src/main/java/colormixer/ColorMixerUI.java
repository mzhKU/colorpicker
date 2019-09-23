package colormixer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class ColorMixerUI extends GridPane {
    private final ColorMixerPM model;
    private final ToggleGroup group = new ToggleGroup();

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private Label redValue;
    private Label blueValue;
    private Label greenValue;

    private TextField redTextValue;
    private TextField greenTextValue;
    private TextField blueTextValue;

    private Rectangle display;

    private RadioButton redRadio;
    private RadioButton blueRadio;
    private RadioButton greenRadio;

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
        // Stylesheet needs to be in 'resources' directory
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

        redTextValue = new TextField("0");
        greenTextValue = new TextField("0");
        blueTextValue = new TextField("0");

        redRadio = new RadioButton("Red");
        redRadio.setUserData("red");
        redRadio.setSelected(true);

        blueRadio = new RadioButton("Blue");
        blueRadio.setUserData("blue");
        blueRadio.setSelected(false);

        greenRadio = new RadioButton("Green");
        greenRadio.setUserData("green");
        greenRadio.setSelected(false);

        redRadio.setToggleGroup(group);
        blueRadio.setToggleGroup(group);
        greenRadio.setToggleGroup(group);
    }

    private void layoutControls() {
        setPrefHeight(400);
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        ColumnConstraints sliderColumn = new ColumnConstraints();
        sliderColumn.setHgrow(Priority.ALWAYS);

        ColumnConstraints valueColumn = new ColumnConstraints(30);
        valueColumn.setHalignment(HPos.RIGHT);

        getColumnConstraints().addAll(sliderColumn, valueColumn);

        addRow(0, redSlider  , redValue,   redTextValue,   redRadio);
        addRow(1, greenSlider, greenValue, greenTextValue, greenRadio);
        addRow(2, blueSlider , blueValue,  blueTextValue,  blueRadio);

        add(display, 0, 3, 2, 1);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(group.getSelectedToggle().getUserData().toString());
            if("red".equals(group.getSelectedToggle().getUserData().toString())) {
                model.setRed(255);
                model.setGreen(0);
                model.setBlue(0);
            }
            if("blue".equals(group.getSelectedToggle().getUserData().toString())) {
                model.setRed(0);
                model.setGreen(0);
                model.setBlue(255);
            }
            if("green".equals(group.getSelectedToggle().getUserData().toString())) {
                model.setRed(0);
                model.setGreen(255);
                model.setBlue(0);
            }
        });
    }

    private void setupBindings() {
        redSlider.valueProperty().bindBidirectional(model.redProperty());
        redValue.textProperty().bind(model.redProperty().asString());
        redTextValue.textProperty().bindBidirectional(model.redProperty(), new NumberStringConverter());

        greenSlider.valueProperty().bindBidirectional(model.greenProperty());
        greenValue.textProperty().bind(model.greenProperty().asString());
        greenTextValue.textProperty().bindBidirectional(model.greenProperty(), new NumberStringConverter());

        blueSlider.valueProperty().bindBidirectional(model.blueProperty());
        blueValue.textProperty().bind(model.blueProperty().asString());
        blueTextValue.textProperty().bindBidirectional(model.blueProperty(), new NumberStringConverter());

        display.fillProperty().bind(model.colorProperty());

        display.widthProperty().bind(widthProperty().subtract(20));
        display.heightProperty().setValue(200);
    }
}
