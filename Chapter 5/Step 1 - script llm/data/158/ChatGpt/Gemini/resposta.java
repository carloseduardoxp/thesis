import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class MyObject implements Parcelable {
  public static final String EXTRA_MY_OBJECT = "myObject";

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
  // The following is a conceptual demonstration of sending and receiving a Parcelable object.
  // In a real Android application, these two parts would be in separate components (e.g., Activities).
  public void demonstrateParcelablePassing(Context context, Class<?> targetActivity, Intent receivedIntent) {
    // --- Part 1: Sending the object ---
    MyObject myObjectToSend = new MyObject("John Doe", 30);

    Intent intentToSend = new Intent(context, targetActivity);
    intentToSend.putExtra(MyObject.EXTRA_MY_OBJECT, myObjectToSend);
    context.startActivity(intentToSend);


    // --- Part 2: Receiving the object (Corrected) ---
    MyObject receivedObject = receivedIntent.getParcelableExtra(MyObject.EXTRA_MY_OBJECT);

    // The variable is now used, resolving the "unused variable" and "useless assignment" issues.
    if (receivedObject != null) {
        // Do something with the received object.
        System.out.println("Received object name: " + receivedObject.getName());
    }
  }
}
