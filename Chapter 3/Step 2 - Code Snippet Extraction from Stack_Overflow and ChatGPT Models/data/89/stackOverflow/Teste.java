public class Teste {

    
    public static void main(String[] args) {
        // setting span

        SpannableString tagSpan = new SpannableString("#clickMe");
        ClickableSpan clickSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                //code to swtich  to new fragment
            }
            @Override
            public void updateDrawState(TextPaint paint) {
                super.updateDrawState(paint);
                paint.setUnderlineText(true); // set underline if you want to underline
                paint.setColor(Color.BLUE); // set the color to blue
            }
        };
        tagSpan.setSpan(clickSpan, startPosition, endPosition, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView txtHashtag = (TextView) findViewById(R.id.txtHashtag);
        txtHashtag.setText(tagSpan);
        txtHashtag.setMovementMethod(LinkMovementMethod.getInstance());
    }
    
}