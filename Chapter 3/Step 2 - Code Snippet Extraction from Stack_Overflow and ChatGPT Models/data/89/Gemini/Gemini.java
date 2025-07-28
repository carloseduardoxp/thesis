import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.myTextView); // Assuming you have a TextView with this ID in your layout

        String text = "This is some underlined text.";
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        myTextView.setText(spannableString);

        // Example: Underlining only a part of the text
        TextView partialUnderlineTextView = findViewById(R.id.partialUnderlineTextView); // Another TextView
        String partialText = "Only this part is underlined.";
        SpannableString partialSpannableString = new SpannableString(partialText);
        partialSpannableString.setSpan(new UnderlineSpan(), 5, 9, 0); // Underline "this"
        partialUnderlineTextView.setText(partialSpannableString);
    }
}
