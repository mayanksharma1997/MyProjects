
import java.util.ArrayList;


public class BinaryTree<T> extends Tree {
   
   public BinaryTree() {
      super();
   }

   public void addRoot(T t) throws Exception {
      if (root() != null)
         throw new Exception("The tree is not empty");
      setRoot(new BinaryNode<T>(null, null, null, t));
      size++;
   }

   public void addLeft(BinaryNode<T> node, T t) throws Exception {
      if (node.getLeft() != null)
         throw new Exception("Left child already exists");
      node.setLeft(new BinaryNode<T>(node, null, null, t));
      size++;
   }

   public void addRight(BinaryNode<T> node, T t) throws Exception {
      if (node.getRight() != null)
         throw new Exception("Right child already exists");
      node.setRight(new BinaryNode<T>(node, null, null, t));
      size++;
   }

   // removes a leaf but promotes and removes a descendant otherwise
   // returns the parent of the node that is actually removed
   @SuppressWarnings("unchecked")
   public BinaryNode<T> removeNode(BinaryNode<T> node) {
      if (isLeaf(node)) { // base case
         BinaryNode<T> parent = (BinaryNode<T>) node.getParent();
         if (parent == null)
            setRoot(null);
         else
            parent.removeChild(node);
         size--;
         return parent;
      }
      BinaryNode<T> lower = descendant(node);
      promote(lower, node);
      return removeNode(lower);
   }

   public void promote(BinaryNode<T> lower, BinaryNode<T> node) {
      node.data = lower.data;
   }

   public BinaryNode<T> descendant(BinaryNode<T> node) {
      if (node.left != null) return node.left;
      return node.right;
   }

   @SuppressWarnings("unchecked")
   public ArrayList<BinaryNode<T>> inOrder() {
      ArrayList<BinaryNode<T>> answer = new ArrayList<BinaryNode<T>>();
      inOrder((BinaryNode<T>) root(), answer);
      return answer;
   }

   public void inOrder(BinaryNode<T> node, ArrayList<BinaryNode<T>> order) {
      if (node == null)
         return;
      inOrder(node.getLeft(), order);
      order.add(node);
      inOrder(node.getRight(), order);
   }
}