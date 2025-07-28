import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleProgressBar extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    // Create a progress bar with an initial progress of 0.0
    ProgressBar progressBar = new ProgressBar(0.0);
    
    // Create a layout and add the progress bar to it
    VBox layout = new VBox();
    layout.getChildren().add(progressBar);
    
    // Create a scene and add the layout to it
    Scene scene = new Scene(layout, 300, 200);
    
    // Set the stage title and scene, and show the stage
    primaryStage.setTitle("Progress Bar Example");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    // Update the progress bar periodically
    Thread thread = new Thread(() -> {
      for (double progress = 0.0; progress < 1.0; progress += 0.1) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        progressBar.setProgress(progress);
      }
    });
    thread.start();
  }
}
