interface I {

    public <T> T doI(T t);

}

class Teste {
    
    public <T> T doI(T t){
        return (T) t.getClass().newInstance();
    }

    public static void main(String[] args) {
        I obj = getIImplementer();
        String a = obj.doI("ssssssss");
    }
}