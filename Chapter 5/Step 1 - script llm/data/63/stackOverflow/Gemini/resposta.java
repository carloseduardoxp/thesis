import java.util.Iterator;

public class Teste {

    
    public static void main(String[] args) {
        Iterator<JsonNode> itr = rootNode.iterator();

        while(itr.hasNext()){
            JsonNode personNode = itr.next();
            if(personNode instanceof ObjectNode && personNode.has("keyToRemove")){
               itr.remove();
            }
        }
    }
    
}
