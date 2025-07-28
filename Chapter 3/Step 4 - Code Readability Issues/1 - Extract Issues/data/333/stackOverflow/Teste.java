
public class Teste {

    public static void main(String[] args) {
        LinearLayout containerLayout = (LinearLayout) findViewById(R.id.mainContainerLayout);
        int marginTopBottom = dpToPx((int) ((dpHeight * 8) / 100), (int) density); //8%
        int marginLeftRight = dpToPx((int) ((dpWidth * 6) / 100), (int) density); //6%

        FrameLayout.LayoutParams languageContainerLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        languageContainerLayoutParams.setMargins(marginLeftRight, marginTopBottom, marginLeftRight, marginTopBottom);
        containerLayout.setLayoutParams(languageContainerLayoutParams);
    }
}
