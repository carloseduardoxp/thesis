interface ValueChangeListener {
    void onValueChanged(int oldValue, int newValue);
}

public class ObservableInteger {
    private int value;
    private ValueChangeListener listener;

    public void setListener(ValueChangeListener listener) {
        this.listener = listener;
    }

    public void setValue(int newValue) {
        if (this.value != newValue) {
            int oldValue = this.value;
            this.value = newValue;
            if (listener != null) {
                listener.onValueChanged(oldValue, newValue);
            }
        }
    }

    public int getValue() {
        return value;
    }
}
