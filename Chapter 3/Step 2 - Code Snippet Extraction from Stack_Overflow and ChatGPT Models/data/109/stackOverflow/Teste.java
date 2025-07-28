public class Teste {

    public static void main(String[] args) {        
        String searchFor = "a";
        String base = "aaaab";
        int count=0;
        int index =base.indexOf(searchFor);
  
        while(index!=-1){
            ++count;
            index = base.indexOf(searchFor, index+searchFor.length());
        }
  
        System.out.println(count);
    }
}