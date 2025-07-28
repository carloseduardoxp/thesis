import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        View myView = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 200);
        myView.setLayoutParams(params);
        myView.setBackgroundColor(Color.RED);

        layout.addView(myView);

        setContentView(layout);

        // Exemplo: alterar cor ao clicar
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setBackgroundColor(Color.BLUE);
            }
        });
    }
}
