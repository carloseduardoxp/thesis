import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }

    // Optional: Helper method to check if a node is a leaf
    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public static void main(String[] args) {
        // Example of creating a tree of Strings
        TreeNode<String> root = new TreeNode<>("Root");

        TreeNode<String> child1 = new TreeNode<>("Child 1");
        TreeNode<String> child2 = new TreeNode<>("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        TreeNode<String> grandchild11 = new TreeNode<>("Grandchild 1.1");
        TreeNode<String> grandchild12 = new TreeNode<>("Grandchild 1.2");
        child1.addChild(grandchild11);
        child1.addChild(grandchild12);

        System.out.println("Root data: " + root.getData());
        System.out.println("First child of root: " + root.getChildren().get(0).getData());
        System.out.println("First grandchild of first child: " + root.getChildren().get(0).getChildren().get(0).getData());
    }
}
