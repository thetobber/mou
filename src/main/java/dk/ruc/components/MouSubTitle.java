package dk.ruc.components;

import javafx.scene.control.Label;

public class MouSubTitle extends Label {
    public MouSubTitle(String text) {
        super(text);
        getStyleClass().clear();
        getStyleClass().add("mou-sub-title");
    }
}
