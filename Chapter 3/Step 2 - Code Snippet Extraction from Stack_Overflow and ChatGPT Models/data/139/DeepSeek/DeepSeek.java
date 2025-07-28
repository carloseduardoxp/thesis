
public class DeepSeek {

    public static void main(String[] args) {

// Create a PopupWindow
        PopupWindow popupWindow = new PopupWindow(context);

// Inflate your custom layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);
        popupWindow.setContentView(popupView);

// Set width and height
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

// Set focusable (important for touch outside behavior)
        popupWindow.setFocusable(true);

// Show the popup window
        popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);

    }

}
