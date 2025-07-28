import java.io.Serializable;

class MyObject implements Serializable {

}

public class Chat {

    public static void main(String[] args) {
        Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
        MyObject myObject = new MyObject();
        intent.putExtra("myObjectKey", myObject);
        startActivity(intent);
    }

}
