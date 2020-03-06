package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class Channel extends ScrollPane {
    @FXML
    public VBox feed;

    public Channel(PublishSubject<String> subject) {
        final var loader = new FXMLLoader(Channel.class.getClassLoader().getResource("Channel.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        // setStyle("-fx-background: #fff");

        final var d = subject.subscribe(text -> {
            feed.getChildren().add(new Message(text));
        });

        feed.heightProperty().addListener(height -> {
            setVvalue(1.0);
        });
    }
}
