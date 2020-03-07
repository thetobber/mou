package dk.ruc.components;

import javafx.scene.shape.SVGPath;

public class MouLogo extends SVGPath {
    public MouLogo() {
        super();
        getStyleClass().clear();
        getStyleClass().add("mou-logo");
        setContent("M45.406,54l0,-38.865l-16.048,29.434l-4.716,0l-16.124,-29.434l0,38.865l-8.518,0l0,-54l9.127,0l17.873,33.008l17.873,-33.008l9.127,0l0,54l-8.594,0Z");
    }
}
