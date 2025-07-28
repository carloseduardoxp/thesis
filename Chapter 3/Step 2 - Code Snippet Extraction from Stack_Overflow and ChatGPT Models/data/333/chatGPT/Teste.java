public class Teste {
  public static void main(String[] args) {
    // create a new TextView
    TextView textView = new TextView(context);
    textView.setText("Hello, world!");

    // get a reference to the LinearLayout
    LinearLayout linearLayout = findViewById(R.id.linear_layout);

    // add the TextView to the LinearLayout
    linearLayout.addView(textView);
        
  }
}
