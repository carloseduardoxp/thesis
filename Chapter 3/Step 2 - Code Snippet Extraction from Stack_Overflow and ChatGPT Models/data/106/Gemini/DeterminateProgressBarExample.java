import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeterminateProgressBarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar(0); // Initial progress is 0.0

        Button startButton = new Button("Start Progress");
        startButton.setOnAction(e -> {
            // Simulate progress
            double progress = 0.0;
            for (int i = 0; i <= 10; i++) {
                final double currentProgress = progress;
                // Update on JavaFX Application Thread
                javafx.application.Platform.runLater(() -> progressBar.setProgress(currentProgress));
                progress += 0.1;
                try {
                    Thread.sleep(200); // Simulate some work
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(progressBar, startButton);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setTitle("Determinate ProgressBar Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
