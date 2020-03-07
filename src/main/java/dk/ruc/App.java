package dk.ruc;

import dk.ruc.views.MouConnect;
import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Mou");

        final PublishSubject<String> store = PublishSubject.create();

        stage.setIconified(false);

        final var scene = new Scene(
            new BorderPane(
                new MouConnect()
            ),
            800,
            400
        );

        scene.getStylesheets().clear();
        scene.getStylesheets().add("Style.css");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}