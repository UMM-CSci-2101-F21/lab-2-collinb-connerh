package umm2101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains Java unit tests (JUnit tests). Methods with the annotation @Test
 * will be called when running the test with JUnit (unless there is some other indication
 * that the test should not be run, such as using the annotation @Disabled).
 */
public class BeaneHettingerListTester {

  private static final Logger logger = Logger.getLogger(BeaneHettingerListTester.class.getName());
  
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

  @Test
   public void testRemoveAllItems(){
   // todo: 6d: write a test for removing all the items (clear)
   for (int i = 1; i<=20; i++)
    {
        list.append(i);
    } 
   list.clear();
   assertTrue(list.isEmpty());
   }

   @Test
    public void testRemoveException(){
    // todo: 6c1: write a test that triggers the exception
    // because the location is too large of a number compared to the number of items in the list
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    for(int i = 1; i<= 25;i++)
    {
        list.next();
    }
    try{
        list.remove();
    }
    catch(NoSuchElementException tes){
        System.out.println(tes.getMessage());
        assertEquals("List exception on remove- position idex out" +
        " of range of List- current pos <" + 20 + "> and length of list <" + 20 + ">", tes.getMessage()); //current position is only 20 because the next method does
                                                                                                          //not alow it to go further but still throws exception due
                                                                                                          //to 0 based index
    }
    }

    @Test
    public void testGetOutOfRange(){
    // todo: 6b2: write a test to trigger an exception because 
    // you are asking for an item with a location that is too large of a number given the number of items
    for (int i = 1; i<=20; i++)
    {
        list.append(i);
    }
    assertEquals(20, list.length());
    for(int i = 1; i<= 33;i++)
    {
        list.next();
    }
    try{
        list.getValue();
    }
    catch(NoSuchElementException tes){
        System.out.println(tes.getMessage());
        assertEquals("There isn't an element here", tes.getMessage());
    }

    }

    @Test
    public void testAppend(){
    // todo: 6a2: One of which appends an item to the end of the list and checks that it worked(taken from instruction doc, different than provided code);;;;;;;;
                                // add a test for insert that throws an exception because 
                                // the location is not a possible location since the list only has some smaller number of items
    for (int i = 1; i<=20; i++)
    {
        list.insert(i);
    }
    System.out.println(list);
    assertEquals(20, list.length());
    list.append(0); 
    assertEquals(1, list.getValue()); //doesn't work yet, nothing is inserted into list
    list.moveToEnd();
    System.out.println(list);
    assertEquals(21, list.length());
    assertEquals(0,list.getValue());
    }

  @Test 
  public void testNextPrev(){
    //tests that next() and prev() move the current position forward, or backwards
    for (int i = 1; i<=20; i++)
    {
        list.insert(i);
    }
    assertEquals(0, list.currPos()); //new assertion 1
    for (int i = 1; i<=5; i++)
    {
        list.next();
    }
    assertEquals(5, list.currPos()); // new assertion 2
    for (int i = 1; i<=2; i++)
    {
        list.prev();
    }
    assertEquals(3, list.currPos()); //new asserion 3
  }

  @Test
  public void testMoveToPos(){
    //tests that moveToPos moves the current position to desired location
    for (int i = 1; i<=10; i++)
    {
        list.insert(i);
    }
    assertEquals(0, list.currPos()); //new assertion 4
    list.moveToPos(3);
    assertEquals(3, list.currPos()); //new assertion 5
  }
  // todo: include some of the tests 
  // that you wrote last week that captured more of the behavior of an integer list

  // todo: update your tests to include 5 additional assertions to further verify the 
  // expected behavior (see directions for more details)


  


}
