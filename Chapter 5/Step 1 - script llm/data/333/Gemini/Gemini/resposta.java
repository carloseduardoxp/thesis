import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Create a LinearLayout as the root container
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL); // Arrange children vertically
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)); // Fill parent width and height

        // 2. Create a TextView
        TextView textView = new TextView(this);
        textView.setText("Hello from Java View!");
        textView.setTextSize(24); // Set text size
        textView.setPadding(30, 30, 30, 30); // Add padding
        // You can also set LayoutParams for individual views if needed

        // 3. Create a Button
        Button button = new Button(this);
        button.setText("Click Me!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define what happens when the button is clicked
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        // 4. Add the TextView and Button to the LinearLayout
        layout.addView(textView);
        layout.addView(button);

        // 5. Set the LinearLayout as the content view for the Activity
        setContentView(layout);
    }
}
