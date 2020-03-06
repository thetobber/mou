package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import java.io.IOException;

public class MessageInput extends TextField {
    public MessageInput(PublishSubject<String> subject) {
        final var loader = new FXMLLoader(MessageInput.class.getClassLoader().getResource("MessageInput.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                final var text = getText();

                if (!text.isEmpty() && !text.matches("^\\s+$")) {
                    subject.onNext(getText());
                    setText("");
                }
            }
        });
    }
}
