
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int value;
    private List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
    
        root.addChild(child1);
        root.addChild(child2);
    
        TreeNode grandchild1 = new TreeNode(4);
        child1.addChild(grandchild1);
    
    }
}

