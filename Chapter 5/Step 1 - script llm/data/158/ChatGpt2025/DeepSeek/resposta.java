import java.io.Serializable;

class MyObject implements Serializable {
    // Fields removed as they were unused
}

public class Chat {
    public static void main(String[] args) {
        Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
        MyObject myObject = new MyObject("Example", 123);
        intent.putExtra("myObjectKey", myObject);
        startActivity(intent);
        // Removed unused variable assignment
    }
}
