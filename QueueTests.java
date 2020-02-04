//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: QueueTests
// Files: Guest.java, ServingQueue.java, QueueTests.java, DessertSolvers.java
// Course: Comp Sci 300, LEC-005, Spring 2019
//
// Author: Shihan Cheng
// Email: scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NA
// Partner Email: NA
// Partner Lecturer's Name: NA
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NA
// Online Sources: NA
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class contains test methods to test class Guest(), ServingQueue() and
 * DessertSolvers() Check if these classes work well
 * 
 * @author shihan
 *
 */
public class QueueTests {

  /**
   * This method tests if the class Guest() works well
   * 
   * @return true once the guest has been created, has the correct index and dietary
   *         restriction. Otherwise, return false
   */
  public static boolean testGuset() {
    // Reset the guest index
    Guest.resetNextGuestIndex();
    // Create two new guests, one is with a dietary restriction
    Guest shihan = new Guest();
    Guest cheng = new Guest("no milk");

    // Check the guest's information
    if (!shihan.toString().equals("#1")) {
      System.out.println("Return value is " + shihan.toString());
      return false;
    }
    // Check if the dietary restriction implement
    if (cheng.hasDietaryRestriction() != true) {
      return false;
    }
    if (!cheng.toString().equals("#2(no milk)")) {
      System.out.println("Return value is " + cheng.toString());
      return false;
    }
    // Reset the guest index again
    Guest.resetNextGuestIndex();
    // Create two new guests again, the index should be 1 and 2
    Guest ruoxi = new Guest();
    Guest shen = new Guest("no cookie");
    // Check the new guests' information with new indices
    if (!ruoxi.toString().equals("#1")) {
      System.out.println("Return value is " + ruoxi.toString());
      return false;
    }
    if (!shen.toString().equals("#2(no cookie)")) {
      System.out.println("Return value is " + shen.toString());
      return false;
    }
    // Reset the guest index for next time or other classes' call
    Guest.resetNextGuestIndex();
    // No bug, return true
    return true;
  }

  /**
   * This method tests if the class ServingQueue() works well
   * 
   * @return true if the queue array store guests well. Otherwise, return false
   */
  public static boolean testServingQueue() {
    // Reset the guest index
    Guest.resetNextGuestIndex();
    // Create a new serving queue with size of 4
    ServingQueue table = new ServingQueue(4);
    // Create 4 new guests
    Guest shihan = new Guest();
    Guest cheng = new Guest();
    Guest ruoxi = new Guest();
    Guest shen = new Guest();

    // Add them into the queue
    table.add(shihan);
    table.add(cheng);
    table.add(ruoxi);
    table.add(shen);

    // Check if the serving queue is empty
    if (table.isEmpty() != false) {
      System.out.println("Table is " + table.isEmpty());
      return false;
    }
    // Check if shihan is the peek(front) of queue
    if (table.peek() != shihan) {
      System.out.println("Peek is " + table.peek());
      return false;
    }
    // Try to remove peek
    table.remove();
    // Check the current peek
    if (table.peek() != cheng) {
      System.out.println("Peek is " + table.peek());
      return false;
    }
    // Check table's list
    if (!table.toString().equals("[#2, #3, #4]")) {
      System.out.println(table.toString());
      return false;
    }
    // Add shihan to the queue again
    table.add(shihan);
    // Check table's list again
    if (!table.toString().equals("[#2, #3, #4, #1]")) {
      System.out.println(table.toString());
      return false;
    }
    // Remove all guests then check if the empty queue works well
    table.remove();
    table.remove();
    table.remove();
    table.remove();
    if (table.isEmpty() != true) {
      System.out.println("Table is " + table.isEmpty());
      return false;
    }
    if (!table.toString().equals("[]")) {
      System.out.println(table.toString());
      return false;
    }
    // Reset the guest index for next time or other classes' call
    Guest.resetNextGuestIndex();
    // No bug, return true;
    return true;
  }

  /**
   * This method tests if the class DessertSolvers() works well
   * 
   * @return true if the last guest returned correctly. Otherwise, return false
   */
  public static boolean testDessertSolvers() {
    // Check first dessert variable skips with 8 guests and 1 skips
    Guest last = DessertSolvers.firstDessertVariableSkips(8, 1);
    // The last guest should be #8
    if (!last.toString().equals("#8")) {
      System.out.println(last.toString());
      return false;
    }
    // Check first dessert variable skips with 8 guests and 3 skips
    last = DessertSolvers.firstDessertVariableSkips(8, 3);
    // The last guest should be #8
    if (!last.toString().equals("#3")) {
      System.out.println(last.toString());
      return false;
    }
    // Check first dessert variable course with 8 guests and 1 course
    last = DessertSolvers.firstDessertVariableCourses(8, 1);
    // The first guest to be reserved with dessert should be #1
    if (!last.toString().equals("#1")) {
      System.out.println(last.toString());
      return false;
    }
    // Check first dessert variable course with 8 guests and 2 courses
    last = DessertSolvers.firstDessertVariableCourses(8, 2);
    // The first guest to be reserved with dessert should be #8
    if (!last.toString().equals("#8")) {
      System.out.println(last.toString());
      return false;
    }
    // Check first dessert variable course with 8 guests and 4 courses
    last = DessertSolvers.firstDessertVariableCourses(8, 4);
    // The first guest to be reserved with dessert should be #5
    if (!last.toString().equals("#5")) {
      System.out.println(last.toString());
      return false;
    }
    // No bug, return true
    return true;
  }
  
  public static boolean testCapicity() {
    ServingQueue table = new ServingQueue(4);
    table.add(new Guest());
    table.add(new Guest());
    table.add(new Guest());
    table.add(new Guest());
    table.add(new Guest());
    
    
    return true;
  }

  /**
   * The main method calls all the test methods above and print the messages for
   * displaying the test outcomes
   * 
   * @param arg (input arguments if any)
   */
  public static void main(String arg[]) {
    System.out.println("testGuset(): " + testGuset());
    System.out.println("testServingQueue(): " + testServingQueue());
    System.out.println("testDessertSolvers(): " + testDessertSolvers());
    testCapicity();
  }

}
