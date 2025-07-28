import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the TextField and Button
        TextField textField = new TextField();
        Button button = new Button("Click Me");
        
        // Set action for the button
        button.setOnAction(event -> {
            String text = textField.getText(); // Get text from TextField
            System.out.println("Text entered: " + text);
            // You can perform any action with the text here
        });
        
        // Create layout and add controls
        VBox root = new VBox(10, textField, button);
        
        // Set up the scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("TextField and Button Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
