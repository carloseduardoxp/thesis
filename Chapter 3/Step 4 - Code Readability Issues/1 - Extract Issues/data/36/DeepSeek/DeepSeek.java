
import java.util.ArrayList;
import java.util.List;

class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;
    
    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
    
    public void addChild(TreeNode<T> child) {
        children.add(child);
    }
    
    public List<TreeNode<T>> getChildren() {
        return children;
    }
    
    public T getData() {
        return data;
    }
    
    // Recursive method to traverse the tree
    public void traverse() {
        System.out.println(data);
        for (TreeNode<T> child : children) {
            child.traverse();
        }
    }
}
