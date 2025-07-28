public class Teste {

    private List myList = new ArrayList();
    private void addItemToList(Object obj){
        if(myList.size()<10){
            myList.add(0,obj);
        }else{
            myList.add(0,obj);
            myList.remove(10);
        }
    }
}