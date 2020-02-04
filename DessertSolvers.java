//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DessertSolvers
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
 * This class solves the dessert problem.
 * 
 * @author shihan
 *
 */
public class DessertSolvers {

  /**
   * The first guest to arrive will be served first, and the servers will then make their
   * way counter-clockwise around the table. But instead of serving every guest in order
   * around the table, they always skip the first waiting guest who has not yet been
   * served, and serve the next waiting guest after them. This continues around the table
   * until every guest has been served. Also will work with any number of skipped
   * 
   * @param numberOfGuests Amount of guests attend the party
   * @param guestsSkipped Amount of guests will be skipped
   * @return the guest will be served last
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
    // Reset guest index
    Guest.resetNextGuestIndex();
    // Check if the parameters are valid
    if (numberOfGuests <= 0 || guestsSkipped < 0) {
      throw new IllegalArgumentException();
    }
    // Create a new queue table with amount of guests
    ServingQueue table = new ServingQueue(numberOfGuests);
    // Create guest to fill the table fully
    for (int i = 0; i < numberOfGuests; i++) {
      Guest guest = new Guest();
      table.add(guest);
    }
    // This loop only need to iterate times of numberOfGuests - 1, because we want at
    // least one
    // guest to stay at the queue list in order to be the last one who has not been served
    for (int j = 0; j < numberOfGuests - 1; j++) {
      // Remove the guest who has been served already, the index front will move to next
      // guest
      table.remove();
      // Then start the second loop to move the number of guest(s) need to be skipped
      for (int m = 0; m < guestsSkipped; m++) {
        Guest temp = table.peek();
        table.remove();
        table.add(temp);
      }
    }
    // The peek, which is the only guest still stored in queue will be returned
    return table.peek();
  }

  /**
   * This class will solve the variation of the original problem, we’ll assume that one
   * waiting guest is always skipped (rather than the variable number considered in the
   * previous problem).
   * 
   * @param numberOfGuests Amount of guests attend the party
   * @param coursesServed Amount of guests will be served
   * @return
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) {
    // Reset guest index
    Guest.resetNextGuestIndex();
    // Check if the parameters are valid
    if (numberOfGuests <= 0 || coursesServed <= 0) {
      throw new IllegalArgumentException();
    }
    // Create a new queue table with amount of guests
    ServingQueue table = new ServingQueue(numberOfGuests);
    // Create another queue to store served guest removed from the queue table
    ServingQueue copy = new ServingQueue(numberOfGuests);
    // Create guest to fill the table fully
    for (int i = 0; i < numberOfGuests; i++) {
      Guest guest = new Guest();
      table.add(guest);
    }
    // When the table only have one guest
    if (numberOfGuests == 1) {
      return table.peek();
    }
    // Then start the loop course by course
    for (int j = 0; j < coursesServed - 1; j++) {
      // Iterate the guests with skiiped number 1
      for (int m = 0; m < numberOfGuests - 1; m++) {
        // Remove the guest who has been served already
        // the index front will move to next guest
        // Store the guest will be served
        Guest temp = table.peek();
        // Copy the guest to the temporary table
        copy.add(temp);
        // Remove the guest who has been served already
        table.remove();
        // Store the guest will be skipped
        Guest last = table.peek();
        // Remove the guest and add her/him to the end of the serving order
        table.remove();
        table.add(last);
      }
      // Now the only peek/front on table is the last guest to be served
      // We can add rest of guests onto table again by removing gusts stored in copy
      // That will be the queue with serving order for next course
      for (int n = 0; n < numberOfGuests - 1; n++) {
        table.add(copy.remove());
      }
    }
    // Return the guest will be served with the dessert first
    return table.peek();
  }

}
