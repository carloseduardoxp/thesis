public class MyUtils {
    public static void doSomethingThatNeedsContext(Context context, String data) {
        if (context != null) {
            // Use the context here, e.g., to access resources, SharedPreferences, etc.
            Toast.makeText(context, "Context received: " + data, Toast.LENGTH_SHORT).show();
            Log.d("MyUtils", "Application name: " + context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
        } else {
            Log.e("MyUtils", "Context is null!");
        }
    }
}

// How to call it from an Activity:
public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        MyUtils.doSomethingThatNeedsContext(this, "Hello from Activity!"); // 'this' is the Activity context
    }
}
