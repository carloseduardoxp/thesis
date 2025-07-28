
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        DBObject doc_1 = new BasicDBObject();
        doc_1.put("name", "XXX");
        doc_1.put("age", 20);
        DBObject doc = new BasicDBObject():
        doc.add("name", "YYY");    
        List<DBObject> doc_List = new ArrayList<>();
        doc_List .add(doc);
        doc_List .add(doc_1);
        collection.insert(doc_List );
   }
}