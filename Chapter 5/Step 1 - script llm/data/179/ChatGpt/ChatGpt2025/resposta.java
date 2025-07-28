class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}

public class Teste {

  public static void main(String[] args) {
    Person person1 = new Person("John Doe", 30);
    Person person2 = new Person("Jane Smith", 25);
    person1.setName("John Smith");
    person2.setAge(26);
  }
}