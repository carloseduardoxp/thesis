import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    T value;
    List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    // Optional: recursive method to print the tree
    public void print(String prefix) {
        System.out.println(prefix + value);
        for (TreeNode<T> child : children) {
            child.print(prefix + "--");
        }
    }
}
