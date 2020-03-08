module dk.ruc {
    requires javafx.fxml;
    requires javafx.controls;
    requires io.reactivex.rxjava3;

    opens dk.ruc to javafx.fxml;

    exports dk.ruc;
}