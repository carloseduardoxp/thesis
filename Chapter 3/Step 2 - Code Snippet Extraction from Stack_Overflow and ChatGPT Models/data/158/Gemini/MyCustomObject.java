import android.os.Parcel;
import android.os.Parcelable;

public class MyCustomObject implements Parcelable {
    private String name;
    private int age;

    // Constructor
    public MyCustomObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Parcelable implementation
    protected MyCustomObject(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<MyCustomObject> CREATOR = new Creator<MyCustomObject>() {
        @Override
        public MyCustomObject createFromParcel(Parcel in) {
            return new MyCustomObject(in);
        }

        @Override
        public MyCustomObject[] newArray(int size) {
            return new MyCustomObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0; // Indicate no special objects
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
