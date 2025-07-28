class MyObject {
    int value;
    
    MyObject(int val) {
        this.value = val;
    }
}

public class ReferenceTest {
    
    public static void modifyObject(MyObject obj) {
        // This change will be visible outside the method
        obj.value = 100;
        
        // This reassignment won't affect the original reference
        obj = new MyObject(50);
    }
    
    public static void main(String[] args) {
        MyObject myObj = new MyObject(10);
        System.out.println("Before: " + myObj.value); // Output: 10
        
        modifyObject(myObj);
        
        System.out.println("After: " + myObj.value);  // Output: 100 (not 50)
    }
}
