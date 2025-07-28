import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldButtonExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {

    // Create a text field
    TextField textField = new TextField();

    // Create a button
    Button button = new Button("Submit");

    // Create an event handler for the button click event
    button.setOnAction(e -> {
      String text = textField.getText();
      System.out.println("Text entered: " + text);
      // Perform action with the text entered in the text field
    });

    // Create a layout and add the text field and button to it
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(10));
    layout.getChildren().addAll(textField, button);

    // Create a scene and add the layout to it
    Scene scene = new Scene(layout, 300, 200);

    // Set the scene on the stage and show the stage
    stage.setScene(scene);
    stage.show();
  }
}
