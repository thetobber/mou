package dk.ruc;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import java.io.IOException;

public class Message extends Label {
    public Message(String text) {
        final var loader = new FXMLLoader(Message.class.getClassLoader().getResource("Message.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        setText(text);
    }
}
