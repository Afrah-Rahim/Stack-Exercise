public class StackTest {
  public static final int MAX_ITEMS = 10;
  public static void main(String[] args) {
    System.out.println("Testing Stack Implemented Using Array:");
    StackArrayBased stack = new StackArrayBased();
    Integer items[] = new Integer[MAX_ITEMS];
    for (int i=0; i<MAX_ITEMS; i++) {
      items[i] = new Integer(i);
      if (!stack.isFull()) {
        stack.push(items[i]);
      }  // end if
    }  // end for
    while (!stack.isEmpty()) {
      // cast result of pop to Integer
      System.out.println((Integer)(stack.pop()));
    }  // end while
    
    System.out.println("Testing Stack Implemented Using Reference:");
    StackReferenceBased stack2 = new StackReferenceBased();
    Integer items2[] = new Integer[MAX_ITEMS/2];
    for (int i=0; i<MAX_ITEMS/2; i++) {
      items2[i] = new Integer(i*i);
      //if (!stack2.isFull()) {
        stack2.push(items2[i]);
      //}  // end if
    }  // end for
    while (!stack2.isEmpty()) {
      // cast result of pop to Integer
      System.out.println((Integer)(stack2.pop()));
    }  // end while

  }  // end main
}