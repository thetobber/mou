package dk.ruc.components;

import javafx.scene.control.Label;

public class MouLabel extends Label {
    public MouLabel(String text) {
        super(text);
        getStyleClass().clear();
        getStyleClass().add("mou-label");
    }
}
