package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class ConnectView extends VBox {
    private PublishSubject<Object> store = Store.getInstance();

    public ConnectView() {
        final var loader = new FXMLLoader(getClass().getResource("/ConnectView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException exception) {
            // TODO: Should maybe handle it better
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void handleConnect() {
        store.onNext(new RouteModel("ChannelView"));
    }
}
