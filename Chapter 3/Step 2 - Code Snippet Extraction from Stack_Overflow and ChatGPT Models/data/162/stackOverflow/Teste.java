 class Link {
    public Object data;
    public Link next;
}

public class Teste {

    private Link _head;
    private int _listsize;


    public void insert(Object item) {
        Link add = new Link();
        add.data = item;
        add.next = _head;
        _head = add;
        ++_listsize;
    }

    public void insert(Object item, int pos) {
        Link add = new Link();
        add.data = item;

        int ix = pos - 1;
        add.next = _head;

        Link previous = _head;

        for (int i = _listsize - 1; i > ix; --i) {
            previous = previous.next;
        }

        Link position = previous.next;

        previous.next = add;
        add.next = position;
        ++_listsize;
    }

}
