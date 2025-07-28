 class Link {
    public Object data;
    public Link next;
}

public class Teste {

    private Link head;
    private int listSize;


    public void insert(Object item) {
        Link add = new Link();
        add.data = item;
        add.next = head;
        head = add;
        ++listSize;
    }

    public void insert(Object item, int pos) {
        Link add = new Link();
        add.data = item;

        int ix = pos - 1;
        add.next = head;

        Link previous = head;

        for (int i = listSize - 1; i > ix; --i) {
            previous = previous.next;
        }

        Link position = previous.next;

        previous.next = add;
        add.next = position;
        ++listSize;
    }

}
