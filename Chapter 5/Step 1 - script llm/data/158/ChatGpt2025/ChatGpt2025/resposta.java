import java.io.Serializable;

class MyObject implements Serializable {
    // constructor, getters, setters...
}

public class Chat {

    public static void main(String[] args) {
        Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
        MyObject myObject = new MyObject("Example", 123);
        intent.putExtra("myObjectKey", myObject);
        startActivity(intent);
    }

}