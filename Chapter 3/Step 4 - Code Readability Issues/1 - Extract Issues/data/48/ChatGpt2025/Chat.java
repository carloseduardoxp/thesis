import java.awt.Button;

public class Chat {

    public static void main(String[] args) {

        // Example with interface
        Button button = new Button();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked!");
            }
        });

        // Example with abstract class
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running");
            }
        });
        thread.start();

    }
}
