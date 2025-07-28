public class Person {
  private String name;
  private int age;
  
  public Person(String name, int age) {
      this.name = name;
      this.age = age;
  }
  
  // Override hashCode() method
  @Override
  public int hashCode() {
      int result = 17; // choose a non-zero initial value
      result = 31 * result + name.hashCode(); // use name's hashcode to calculate hash code
      result = 31 * result + age; // use age to calculate hash code
      return result;
  }
  
  // Override equals() method
  @Override
  public boolean equals(Object obj) {
      if (obj == this) {
          return true;
      }
      if (!(obj instanceof Person)) {
          return false;
      }
      Person other = (Person) obj;
      return name.equals(other.name) && age == other.age;
  }
}
