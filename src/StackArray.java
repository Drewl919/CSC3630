import java.util.Arrays;

public class StackArray {
   private int top = 3;
   private int[] items;
   private final int DEFAULT_CAPCITY = 3;

    public StackArray() {
           items = new int[DEFAULT_CAPCITY];
    }
    public void push( int newItem ) {
      if ( top == items.length ){
         increaseCapacity();
      }
      items[top++] = newItem;
   }

    public int getSize() {
        return items.length;
    }

   public int pop() throws IllegalAccessException {
      int popItem = -1;
      if ( top > 0 ) {
         popItem = items[--top];
      } else {
          throw new IllegalAccessException("Pop Too Many");
      }
      return popItem;
   }

    public int peek() {
        return items[top-1];
    }

   private void increaseCapacity() {
//       System.out.printf("\nInside increase capacity");
       int newSize = items.length*2;
       System.out.printf("\nInside increase capacity newSize:%s", newSize);
       items  = Arrays.copyOf( items, newSize );
   }
}
