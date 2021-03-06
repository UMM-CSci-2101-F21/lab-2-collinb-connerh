package umm2101;
  // List class ADT. Generalize by using "Object" for the element type.
  // adapted from OpenDSA textbook: http://lti.cs.vt.edu/LTI_ruby/Books/CSCI2101/html/index.html

import java.util.NoSuchElementException;

public interface IntegerList { // List class ADT
  // Remove all contents from the list, so it is once again empty
  public void clear();

  // Insert "it" at the current location
  // The client must ensure that the list's capacity is not exceeded
  public boolean insert(int it);

  // Append "it" at the end of the list
  // The client must ensure that the list's capacity is not exceeded
  public boolean append(int it);

  // Remove and return the current element
  public int remove() throws NoSuchElementException;

  // Set the current position to the start of the list
  public void moveToStart();

  // Set the current position to the end of the list
  public void moveToEnd();

  // Move the current position one step left, no change if already at beginning
  public void prev();

  // Move the current position one step right, no change if already at end
  public void next();

  // Return the number of elements in the list
  public int length();

  // Return the position of the current element
  public int currPos();

  // Set the current position to "pos" (use 0 based indices)
  public boolean moveToPos(int pos);

  // Return true if current position is at end of the list
  public boolean isAtEnd();

  // Return the current element
  public int getValue() throws NoSuchElementException;
  
  public boolean isEmpty();
}
