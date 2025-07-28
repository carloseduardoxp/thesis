public class MyClass {
  // Instance variables
  private int myNumber;
  private String myString;

  // Constructor
  public MyClass(int myNumber, String myString) {
      this.myNumber = myNumber;
      this.myString = myString;
  }

  // Getter methods
  public int getMyNumber() {
      return myNumber;
  }

  public String getMyString() {
      return myString;
  }

  // Setter methods
  public void setMyNumber(int myNumber) {
      this.myNumber = myNumber;
  }

  public void setMyString(String myString) {
      this.myString = myString;
  }

  // Other methods
  public void printMyValues() {
      System.out.println("My number is " + myNumber + " and my string is " + myString);
  }
}
