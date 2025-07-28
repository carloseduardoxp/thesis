import java.util.*;


public class Teste {

    public static void main(String[] args) {        
        List <String> list = new ArrayList();  
        list.add("behold"); 
        list.add("bend"); 
        list.add("bet"); 
        list.add("bear"); 
        list.add("beat"); 
        list.add("become"); 
        list.add("begin");

        List <String> listClone = new ArrayList<String>(); 
        for (String string : list) {
            if(string.matches("(?i)(bea).*")){
                listClone.add(string);
            }
        }
        System.out.println(listClone);
    }
}