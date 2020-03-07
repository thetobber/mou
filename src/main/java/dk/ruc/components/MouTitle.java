package dk.ruc.components;

import javafx.scene.control.Label;

public class MouTitle extends Label {
    public MouTitle(String text) {
        super(text);
        getStyleClass().clear();
        getStyleClass().add("mou-title");
    }
}
