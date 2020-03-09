package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private PublishSubject<Object> store = Store.getInstance();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Mou");

        final var connectView = new ConnectView();
        final var channelView = new ChannelView();

        final var scene = new Scene(connectView, 840, 680);

        // Not sure if it is properly disposed??
        store.subscribe(object -> {
            if (object instanceof RouteModel) {
                final var route = (RouteModel) object;

                if (route.getRouteName().equals("ChannelView")) {
                    scene.setRoot(channelView);
                }
                else {
                    scene.setRoot(connectView);
                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}