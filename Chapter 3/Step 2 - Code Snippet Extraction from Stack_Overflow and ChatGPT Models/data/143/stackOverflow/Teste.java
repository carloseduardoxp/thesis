import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        List<String> mainList = new ArrayList<String>();

        mainList.addAll(getList());

    }

    private static List<String> getList() {
        List<String> listName = new ArrayList<String>();
        listName.add("String");
        return listName;
    }
}
