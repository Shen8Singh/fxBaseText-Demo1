package lk.ZenVeus.javaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/View/SignIn.fxml"));

        stage.setScene(new Scene(rootNode));
        stage.setTitle("Base Test");
        stage.centerOnScreen();
        stage.show();
    }
}
