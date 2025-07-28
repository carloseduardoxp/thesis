import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button button = new Button("Click Me");

        // Set button action event
        button.setOnAction(event -> {
            String inputText = textField.getText();
            System.out.println("Text from TextField: " + inputText);
            // You can add more logic here, e.g., validate input or update UI
        });

        VBox root = new VBox(10, textField, button);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TextField and Button Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
