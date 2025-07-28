import java.util.*;
import java.lang.annotation.ElementType;

class Tree {
   private Node root;

   public boolean containsSubTree(Tree other) {
      return root.containsSubTree(other.root);
   }
}

public class Node {
  private ElementType elementType;
  private List<Node> children = new ArrayList<>();

  public Node(Node parent, ElementType elementType) {
     
  }

  public void addChild(Node child) {
     children.add(child);
  }

  protected boolean equalsIgnoreParent(Node other) {
     if (elementType != other.elementType) return false;
     if (children.size() != other.children.size()) return false;
     for (int i = 0; i < children.size(); ++ i) {
        // recursive step
        if (!children.get(i).equalsIgnoreParent(other.children.get(i))) {
           return false;
        }
     }
     return true;
  }

  public boolean containsSubTree(Node other) {
     if (equalsIgnoreParent(other)) return true;
     for (Node child : children) {
        // recursive step
        if (child.containsSubTree(other)) return true;
     }
     return false;
  }
}