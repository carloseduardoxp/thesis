interface I{

    public <T> T doI(T t);

}

class Teste {
    
    public <T> T doI(T t){
        Object a = t.getClass().newInstance();
        return (T) a;
    }

    public static void main(String[] args) {
        I obj = getIImplementer ();
        obj.doI ("ssssssss");
    }
}
