package ucr.laboratory5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(HelloApplication.class.getResource("stylesheet.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Laboratory 4\nDaniel Sánchez Vargas\nAndreé Murillo Sojo\nAidan Murillo Corrales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}