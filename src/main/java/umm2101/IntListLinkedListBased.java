package umm2101;

import java.util.NoSuchElementException;

public class IntListLinkedListBased implements IntegerList {
    // Linked list implementation
    // adapted from OpenDSA textbook: 
    // http://lti.cs.vt.edu/LTI_ruby/Books/CSCI2101/html/index.html
    private Link head;         // Pointer to list header
    private Link tail;         // Pointer to last element
    private Link curr;         // Access to current element
    private int numItems;      // Number of elements in the list
    
    // Constructors
    IntListLinkedListBased(int size) { this(); }     // Constructor -- Ignore size
    IntListLinkedListBased() { clear(); }
    
    // Remove all elements
    public void clear() {
        curr = tail = new Link(null); // Create trailer
        head = new Link(tail);        // Create header
        numItems = 0;
    }
      
    // todo: implement insert
    // Insert "it" at current position
    public boolean insert(int it) {
        Link myLink = new Link(curr.getElement(),curr.getNext());
        curr.setNext(myLink);
        curr.setElement(it);
        numItems++;
        return true;
    }
      
    // todo: implement append
    // Append "it" to list
    public boolean append(int it) {
        return true;
    }
    
    // todo: implement remove
    // Remove and return current element
    public int remove () throws NoSuchElementException {
        return 0;
    }
    
    public void moveToStart() { curr = head.getNext(); } // Set curr at list start
    public void moveToEnd() { curr = tail; }          // Set curr at list end
    
    // Move curr one step left; no change if now at front
    public void prev() {
        if (head.getNext() == curr) { return; } // No previous element
        Link temp = head;
        // March down list until we find the previous element
        while (temp.getNext() != curr) { temp = temp.getNext(); }
        curr = temp;
    }
    
    // Move curr one step right; no change if now at end
    public void next() { if (curr != tail) curr = curr.getNext(); }
    
    public int length() { return numItems; } // Return list length
    
    
    // Return the position of the current element
    public int currPos() {
        Link temp = head.getNext();
        int i;
        for (i=0; curr != temp; i++) {
          temp = temp.getNext();
        }
        return i;
    }
      
    // Move down list to "pos" position
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > numItems)) { return false; }
        curr = head.getNext();
        for(int i=0; i<pos; i++) {
            curr = curr.getNext();
        }
        return true;
    }
    
    // Return true if current position is at end of the list
    public boolean isAtEnd() { return curr == tail; }
    
    // Return current element value.
    public int getValue() throws NoSuchElementException {
        if (curr == tail) { // No current element
          throw new NoSuchElementException("getvalue() in LList has current of " + curr + " and size of "
            + numItems + " that is not a a valid element");
        }
        return curr.getElement(); 
    }
    
    // Check if the list is empty
    public boolean isEmpty() { return numItems == 0; }

    public String toString() {
        String s = "[";
        for (Link link = head.next; link != tail; link = link.getNext()){
            s = s + link.getElement() + ", ";
        }
        s += "]";
        return s;
    }
    
}