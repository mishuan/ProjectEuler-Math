package utility;

public class ImmutablePair<L, R> {

   private final L left;
   private final R right;

   public ImmutablePair(L left, R right) {
      this.left = left;
      this.right = right;
   }

   public L getLeft() {
      return left;
   }

   public R getRight() {
      return right;
   }

   @Override
   public int hashCode() {
      return left.hashCode() ^ right.hashCode();
   }

   @Override
   public boolean equals(Object other) {
      if (other instanceof ImmutablePair) {
         ImmutablePair<?, ?> otherPair = (ImmutablePair<?, ?>) other;
         return ((this.right == otherPair.right || (this.right != null && otherPair.right != null && this.right
               .equals(otherPair.right))) && (this.left == otherPair.left || (this.left != null && otherPair.left != null && this.left
               .equals(otherPair.left))));
      }
      return false;
   }

   public String toString() {
      return "(" + right + ", " + left + ")";
   }
}

