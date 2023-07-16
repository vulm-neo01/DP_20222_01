package views.screen.textError;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;

public class TextErrorScreen extends BaseScreenHandler {

    @FXML
    ImageView icon;

    @FXML
    Label message;

    protected TextErrorScreen(Stage stage) throws IOException {
        super(stage, ViewsConfig.TEXT_ERROR);
    }

    private static TextErrorScreen textError(String message, String imagePath, Boolean undecorated) throws IOException{
        TextErrorScreen textError = new TextErrorScreen(new Stage());
        if (undecorated) textError.stage.initStyle(StageStyle.UNDECORATED);
        textError.message.setText(message);
        textError.setImage(imagePath);
        return textError;
    }

    public static void success(String message) throws IOException{
        textError(message, ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png", true)
                .show(true);
    }

    public static void error(String message) throws IOException{
        textError(message, ViewsConfig.IMAGE_PATH + "/" + "tickerror.png", false)
                .show(false);
    }

    public static TextErrorScreen loading(String message) throws IOException{
        return textError(message, ViewsConfig.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void show(Boolean autoClose) {
        super.show();
        if (autoClose) close(0.8);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    protected void setupData(Object dto) throws Exception {
    }

    protected void setupFunctionality() throws Exception {
    }

}
