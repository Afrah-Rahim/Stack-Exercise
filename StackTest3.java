/*
 * Given two stacks containing Integer objects in increasing order from the bottom up, 
 * create a third stack such that the Integer objects are in decreasing order from the bottom up.
 */ 

public class StackTest3 {
  public static final int MAX_ITEMS = 10;
  
  /**
   * merge: Given two stacks containing Integer objects in increasing order from the bottom up, 
   * create a third stack such that the Integer objects are in decreasing order from the bottom up.
   * If an item appears n times in the two given stacks, it will appear n times in the new stack.
   *
   * @param s1  the first stack
   * @param s2  the second stack
   * @return    the new stack, with the items from the two given stacks merged.
   */
  public static StackInterface merge(StackInterface s1, StackInterface s2)
  {
     StackInterface newStack = new StackReferenceBased();
     Integer i1 = new Integer(-1);
     Integer i2 = new Integer(-1);
    
     if (!s1.isEmpty())
        i1 = (Integer)s1.pop();
        
     if (!s2.isEmpty())
        i2 = (Integer)s2.pop();
    
     while (!s1.isEmpty() && !s2.isEmpty()) {

       System.out.println("Comparing " + i1 + " and " + i2);

       if (i1.compareTo(i2) < 0) {
            newStack.push(i2);
            
            //Get next item from second stack
            i2 = (Integer)s2.pop();
       }
       else {
             newStack.push(i1);    
           
             //Get next item from first stack
             i1 = (Integer)s1.pop();
       }
     }
     
     // At this point, s1 and/or s2 are empty. 
     
     if (s1.isEmpty()) {
        newStack.push(i2);
        while (!s2.isEmpty()) {
           newStack.push(s2.pop());    
        }
     }
        
     if (s2.isEmpty()) {
        newStack.push(i1);
        while (!s1.isEmpty()) {
           newStack.push(s1.pop());    
        }
     }
          
     return newStack;
  }
    
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
    
    /*
    while (!stack.isEmpty()) {
      // cast result of pop to Integer
      System.out.println((Integer)(stack.pop()));
    }  // end while
    */
    
    System.out.println("Testing Stack Implemented Using Reference:");
    StackReferenceBased stack2 = new StackReferenceBased();
    Integer items2[] = new Integer[MAX_ITEMS/2];
    for (int i=0; i<MAX_ITEMS/2; i++) {
      items2[i] = new Integer(i*i);
      //if (!stack2.isFull()) {
        stack2.push(items2[i]);
      //}  // end if
    }  // end for
   
    /*
    while (!stack2.isEmpty()) {
      // cast result of pop to Integer
      System.out.println((Integer)(stack2.pop()));
    }  // end while
    */
    
    System.out.println("Testing merge of two stacks");
    StackReferenceBased stack3 = (StackReferenceBased) merge(stack, stack2);
    while (!stack3.isEmpty()) {
      // cast result of pop to Integer
      System.out.println((Integer)(stack3.pop()));
    }  // end while 
    
  }  // end main
}