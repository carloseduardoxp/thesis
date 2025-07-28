class A{
    int n;
    public A(int x){
        n = x;
    }
}

class B extends A{
    int m;
    public B(int x, int y){
        super(x);
        m = y;
    }
}