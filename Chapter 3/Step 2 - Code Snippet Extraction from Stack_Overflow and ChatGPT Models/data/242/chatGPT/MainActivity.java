import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private CountDownTimer countdownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTextView = findViewById(R.id.countdownTextView);

        countdownTimer = new CountDownTimer(60000, 1000) {
            // 60000 is the total time in milliseconds, and 1000 is the interval time in milliseconds
            public void onTick(long millisUntilFinished) {
                // This method is called every interval time (1000ms) until the countdown is finished
                countdownTextView.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                // This method is called when the countdown is finished
                countdownTextView.setText("Countdown finished!");
            }
        }.start(); // Start the countdown timer
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countdownTimer.cancel(); // Cancel the countdown timer to avoid memory leaks
    }
}
