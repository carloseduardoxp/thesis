class Parent {
    String color = "Parent's color";
}

class Child extends Parent {
    String color = "Child's color";
    
    void printColors() {
        System.out.println(color);        // Child's color
        System.out.println(super.color);  // Parent's color
    }
}
