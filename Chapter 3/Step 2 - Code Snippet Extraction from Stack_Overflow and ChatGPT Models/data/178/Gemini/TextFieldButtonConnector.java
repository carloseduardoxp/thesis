import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldButtonConnector extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TextField and Button Connector");

        // 1. Create UI elements
        Label instructionsLabel = new Label("Enter something:");
        TextField inputTextField = new TextField();
        inputTextField.setPromptText("Type here..."); // Placeholder text

        Button submitButton = new Button("Process Text");

        Label outputLabel = new Label("Output will appear here.");

        // 2. Set action for the button
        submitButton.setOnAction(event -> {
            String enteredText = inputTextField.getText();

            if (enteredText != null && !enteredText.trim().isEmpty()) {
                outputLabel.setText("You entered: " + enteredText);
                inputTextField.clear(); // Clear the text field after submission
            } else {
                outputLabel.setText("Please enter some text!");
            }
        });

        // 3. Arrange elements in a layout
        VBox root = new VBox(10); // Spacing of 10 pixels between children
        root.setPadding(new Insets(20)); // Padding around the VBox
        root.getChildren().addAll(instructionsLabel, inputTextField, submitButton, outputLabel);

        // 4. Create a Scene and set it on the Stage
        Scene scene = new Scene(root, 300, 200); // Width, Height
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
