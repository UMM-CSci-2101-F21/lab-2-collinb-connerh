package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains Java unit tests (JUnit tests). Methods with the annotation @Test
 * will be called when running the test with JUnit (unless there is some other indication
 * that the test should not be run, such as using the annotation @Disabled).
 */
public class LambertyListTester {

  private static final Logger logger = Logger.getLogger(LambertyListTester.class.getName());
  
  IntegerList list;
  
  @BeforeEach
  public void setUp() {
    list = new IntListLinkedListBased();
  }

  @Test
  public void testEmptyOnCreate() {
    // when you create a list, it should be empty
    assertTrue(list.isEmpty());
  }
  
  @Test
  public void testInsertMethod() {
    // Using the logger
    logger.info("There should not be anything in the new list:" + list);

    // Check the assertion that the list has nothing
    assertEquals(0, list.length());
    // add 20 as the first item in the list (add to an empty list)
    list.insert(20);
    // verify that the list has exactly one item
    assertEquals(1, list.length());
    // Check the assertion that the item is, indeed, 20
    assertEquals(20, list.getValue());
    
    // add to the end of a non-empty list
    list.append(30);

  }
  
  @Test
  public void testGet() {  
    list.insert(20);
    // verify that the list has exactly one item
    assertEquals(1, list.length());
    // Check the assertion that the item is, indeed, 20
    assertEquals(20, list.getValue());
  }
  
  @Test
  public void testRemove() {
    // add one item
    list.insert(20);
    logger.info("The list includes: " + list);
    
    // size is one, remove the first item, size is now zero
    assertEquals(1, list.length());
    logger.info("The list has " + list.length() + " items.");
    int val = list.remove();
    logger.info("The list no longer has this " + val);
    assertEquals(0, list.length());
    logger.info("The list has " + list.length() + " items.");

    // add 50 things to the list
    for (int i = 1; i<=50; i++) {
      list.insert(i);
    }
    logger.info("The list has: " + list);
    assertEquals(50, list.length());

    // move to the next item 10 times (end on index 10)
    for (int i = 0; i < 10; i++) {
      list.next(); 
    }
   
    // removing the 11th item (index 10) should remove 40
    assertEquals(40, list.getValue());
    list.remove();
    assertEquals(39, list.getValue());
    assertEquals(49, list.length());
    
    // add a 50th item in position 50
    list.moveToPos(50);
    list.insert(66);
    assertEquals(66, list.getValue());
  }

  // todo: include some of the tests 
  // that you wrote last week that captured more of the behavior of an integer list

  // todo: update your tests to include 5 additional assertions to further verify the 
  // expected behavior (see directions for more details)
  


}
