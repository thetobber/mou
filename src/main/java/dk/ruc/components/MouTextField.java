package dk.ruc.components;

import javafx.scene.control.TextField;

public class MouTextField extends TextField {
    public MouTextField() {
        super();
        getStyleClass().clear();
        getStyleClass().add("mou-text-field");
    }
}
