class Parent {
    String color = "Parent's color";
}

class Child extends Parent {
    String childColor = "Child's color";
    
    void printColors() {
        System.out.println(childColor);   // Child's color
        System.out.println(super.color);  // Parent's color
    }
}
