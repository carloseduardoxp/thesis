
public class Chat {

    public static void main(String[] args) {
        TextView textView = findViewById(R.id.textView);
        String text = "This text will be underlined";

        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        textView.setText(content);
    }
}
