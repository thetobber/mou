package dk.ruc.views;

import dk.ruc.components.MouButton;
import dk.ruc.components.MouLabel;
import dk.ruc.components.MouLogo;
import dk.ruc.components.MouTextField;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class MouConnect extends VBox {
    public MouConnect() {
        super();
        getStyleClass().clear();
        getStyleClass().add("mou-connect");

        final var displayName = new MouTextField(){{
            VBox.setMargin(this, new Insets(0, 0, 16, 0));
            setPromptText("An alphanumeric display name");
        }};

        final var channelAddress = new MouTextField(){{
            VBox.setMargin(this, new Insets(0, 0, 16, 0));
            setPromptText("A valid IP address");
        }};

        final var channelPassword = new MouTextField(){{
            VBox.setMargin(this, new Insets(0, 0, 32, 0));
            setPromptText("Leave blank for no password");
        }};

        final var mouButton = new MouButton("Connect"){{
            setOnMouseClicked(event -> {
                final var details = String.format(
                    "Display name:\t\t%s\nChannel IP address:\t%s\nChannel password:\t%s",
                    displayName.getText(),
                    channelAddress.getText(),
                    channelPassword.getText()
                );

                System.out.println(details);
            });
        }};

        getChildren().addAll(
            new MouLogo(){{
                VBox.setMargin(this, new Insets(0, 0, 40, 0));
            }},
            new MouLabel("DISPLAY NAME"){{
                VBox.setMargin(this, new Insets(0, 0, 8, 0));
            }},
            displayName,
            new MouLabel("CHANNEL IP ADDRESS"){{
                VBox.setMargin(this, new Insets(0, 0, 8, 0));
            }},
            channelAddress,
            new MouLabel("CHANNEL PASSWORD"){{
                VBox.setMargin(this, new Insets(0, 0, 8, 0));
            }},
            channelPassword,
            mouButton
        );
    }
}
