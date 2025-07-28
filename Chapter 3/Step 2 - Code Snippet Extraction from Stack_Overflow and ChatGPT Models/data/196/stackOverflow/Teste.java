// note code is abbreviated, this is just for explanation
class Shape {
    public int area();  // no implementation, this is abstract
}

class Circle {
    private int radius;
    public Circle(int r){ radius = r ; }
    public int area(){ return Math.PI*radius*radius ; }
}

class Square {
    private int wid;
    public Square(int w){ wid=w; }
    public int area() { return wid*wid; }
}

