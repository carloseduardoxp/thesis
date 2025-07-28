import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        DBObject doc1 = new BasicDBObject();
        doc1.put("name", "XXX");
        doc1.put("age", 20);
        DBObject doc = new BasicDBObject();
        doc.add("name", "YYY");    
        List<DBObject> docList = new ArrayList<>();
        docList.add(doc);
        docList.add(doc1);
        collection.insert(docList);
   }
}
