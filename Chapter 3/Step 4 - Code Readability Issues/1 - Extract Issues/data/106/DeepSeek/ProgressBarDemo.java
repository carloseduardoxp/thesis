import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProgressBarDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a progress bar
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0.5); // Set to 50%
        
        // Create layout and add progress bar
        StackPane root = new StackPane();
        root.getChildren().add(progressBar);
        
        // Set up the scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("JavaFX ProgressBar Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
