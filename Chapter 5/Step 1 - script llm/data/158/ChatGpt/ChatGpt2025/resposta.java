public class MyObject implements Parcelable {
    private String name;
    private int age;

    public MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected MyObject(Parcel in) {
        name = in.readString();
        age = in.readInt();
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
        dest.writeInt(age);
    }
}

class Teste {
    private static final String EXTRA_MY_OBJECT = "myObject";

    public static void main(String[] args) {
        MyObject myObject = new MyObject("John Doe", 30);

        Intent intent = new Intent(this, MyActivity.class);
        intent.putExtra(EXTRA_MY_OBJECT, myObject);
        startActivity(intent);

        Intent intent2 = getIntent();
        intent2.getSerializableExtra(EXTRA_MY_OBJECT);

        Intent intent3 = getIntent();
        intent3.getParcelableExtra(EXTRA_MY_OBJECT);
    }
}