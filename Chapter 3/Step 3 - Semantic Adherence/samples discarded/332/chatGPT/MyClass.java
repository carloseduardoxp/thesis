public class MyClass {
  private String name;
  private int age;

  // constructor, getters, and setters

  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
  }
}
