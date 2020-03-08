package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ChannelView extends VBox {
    private PublishSubject<Object> store = Store.getInstance();

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    public ChannelView() {
        final var loader = new FXMLLoader(getClass().getResource("/ChannelView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException exception) {
            // TODO: Should maybe handle it better
            throw new RuntimeException(exception);
        }

        // Scroll to bottom when a new message is added
        vBox.heightProperty().addListener(observable -> {
            scrollPane.setVvalue(1);
        });

        // Not sure if it is properly disposed??
        store.subscribe(object -> {
            if (object instanceof MessageModel) {
                final var message = (MessageModel) object;

                final var dateTime = LocalDateTime
                    .ofInstant(
                        Instant.ofEpochSecond(
                            message.getTimestamp()
                        ),
                        ZoneId.systemDefault()
                    )
                    .format(
                        DateTimeFormatter.ofLocalizedDateTime(
                            FormatStyle.SHORT,
                            FormatStyle.SHORT
                        )
                    );

                final var messageLabel = new Label(
                    String.format(
                        "%s\t%s\n%s",
                        message.getDisplayName(),
                        dateTime,
                        message.getText()
                    )
                );

                vBox.getChildren().add(messageLabel);
            }
        });
    }

    @FXML
    public void handleSend(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            final var textField = (TextField) event.getTarget();

            if (!textField.getText().isEmpty()) {
                final var message = new MessageModel(
                    "Display name",
                    Instant.now().getEpochSecond(),
                    textField.getText()
                );

                store.onNext(message);
                textField.clear();
            }
        }
    }

    @FXML
    public void handleDisconnect() {
        store.onNext(new RouteModel("ConnectView"));
    }
}
