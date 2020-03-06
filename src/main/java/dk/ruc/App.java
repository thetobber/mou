package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mou");

        final PublishSubject<String> subject = PublishSubject.create();

        final var layout = new AnchorPane(){{
            final var channel = new Channel(subject);
            setTopAnchor(channel, 0.0);
            setRightAnchor(channel, 0.0);
            setBottomAnchor(channel, 40.0);
            setLeftAnchor(channel, 0.0);

            final var messageInput = new MessageInput(subject);
            setRightAnchor(messageInput, 0.0);
            setBottomAnchor(messageInput, 0.0);
            setLeftAnchor(messageInput, 0.0);

            getChildren().addAll(channel, messageInput);
        }};

        final var scene = new Scene(layout, 800, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}