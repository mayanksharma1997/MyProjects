
public class AVLNode<K extends Comparable<K>> extends BinaryNode<K> {
   public int ht;

   public int setHt() {
      AVLNode<K> l = (AVLNode<K>) getLeft();
      AVLNode<K> r = (AVLNode<K>) getRight();
      ht = 0;
      if (l != null) ht = 1 + l.ht;
      if (r != null && r.ht >= ht) ht = 1 + r.ht;
      return ht;
   }

   public AVLNode(AVLNode<K> parent, AVLNode<K> leftChild, AVLNode<K> rightChild, K d) {
      super(parent, leftChild, rightChild, d);
      setHt();
   }
   
   public int leftChildHt() {
      if (getLeft() != null) return ((AVLNode<K>) getLeft()).ht;
      return -1;
   }
   public int rightChildHt() {
      if (getRight() != null) return ((AVLNode<K>) getRight()).ht;
      return -1;
   }
   
   public boolean isLeftHeavy() {
      return leftChildHt() > rightChildHt() + 1;
   }
   
   public boolean isRightHeavy() {
      return rightChildHt() > leftChildHt() + 1;
   }
}