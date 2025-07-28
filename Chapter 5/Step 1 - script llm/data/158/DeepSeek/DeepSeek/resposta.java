class MyObject implements Parcelable {

    private String name;
    private int value;

    // Constructor, getters, setters
    // Parcelable implementation
    protected MyObject(Parcel in) {
        name = in.readString();
        value = in.readInt();
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(value);
    }
}

public class DeepSeek {

    public static void main(String[] args) {
        MyObject obj = new MyObject("Test", 123);
        Intent intent = new Intent(this, TargetActivity.class);
        intent.putExtra("my_object", obj);
        startActivity(intent);

        getIntent().getParcelableExtra("my_object");
    }
}
