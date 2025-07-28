import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarExample extends Application {

    private double progress = 0.0;

    @Override
    public void start(Stage primaryStage) {
        // Create a ProgressBar
        ProgressBar progressBar = new ProgressBar(0); // 0 means 0%, 1 means 100%

        // Create a Button to simulate progress
        Button button = new Button("Increase Progress");

        button.setOnAction(e -> {
            if (progress < 1.0) {
                progress += 0.1;
                progressBar.setProgress(progress);
            }
        });

        // Add components to the layout
        VBox root = new VBox(10, progressBar, button);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Create the Scene and show the Stage
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("JavaFX ProgressBar Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
