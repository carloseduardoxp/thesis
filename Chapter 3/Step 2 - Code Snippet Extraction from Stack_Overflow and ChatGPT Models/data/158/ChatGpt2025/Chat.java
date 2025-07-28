
import java.io.Serializable;

class MyObject implements Serializable {

    private String name;
    private int value;

    // constructor, getters, setters...
}

public class Chat {

    public static void main(String[] args) {
        Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
        MyObject myObject = new MyObject("Example", 123);
        intent.putExtra("myObjectKey", myObject);
        startActivity(intent);
        MyObject receivedObject = (MyObject) getIntent().getSerializableExtra("myObjectKey");

    }

}
