public class Teste {
    public static void main(String[] args) {
        TextView textView = findViewById(R.id.myTextView);
        textView.setText("Underlined text");

        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }
}
