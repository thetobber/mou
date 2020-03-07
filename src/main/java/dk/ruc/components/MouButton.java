package dk.ruc.components;

import javafx.scene.control.Button;

public class MouButton extends Button {
    public MouButton(String text) {
        super(text);
        getStyleClass().clear();
        getStyleClass().add("mou-button");
    }
}
