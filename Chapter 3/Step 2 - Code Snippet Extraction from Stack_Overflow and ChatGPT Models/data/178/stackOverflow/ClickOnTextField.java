import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClickOnTextField extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setOnMouseClicked(e -> {
            System.out.println("Clicked");
        });

        StackPane root = new StackPane(textField);
        Scene scene = new Scene(root, 350, 120);
        primaryStage.setScene(scene);;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}