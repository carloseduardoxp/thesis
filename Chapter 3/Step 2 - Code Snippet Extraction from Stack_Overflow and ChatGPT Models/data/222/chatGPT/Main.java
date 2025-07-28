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

public class Main {
  public static void main(String[] args) {
      Person person = new Person("John", 30);
      System.out.println("Before method call: " + person.getName() + " " + person.getAge());
      updatePerson(person);
      System.out.println("After method call: " + person.getName() + " " + person.getAge());
  }

  public static void updatePerson(Person p) {
      p.setName("Jane");
      p.setAge(25);
  }
}
