
import javax.swing.text.View;

public class Teste {

    private void displayPopupWindow(View anchorView) {
        PopupWindow popup = new PopupWindow(Pdf.this);
        View layout = getLayoutInflater().inflate(R.layout.popup_content, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(new BitmapDrawable());
        // Show anchored to button
        popup.showAtLocation(anchorView, Gravity.BOTTOM, 0,
                anchorView.getBottom() - 60);

        popup.showAsDropDown(anchorView);
    }
}
