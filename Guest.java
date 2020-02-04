//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Guest
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
 * This class is used to keep track of guests at a dinner party, and the peculiar orders
 * in which they are served. we’ll need to track for each guest are 1) the index
 * describing the order that they arrive to dinner in. 2) whether that guest has any
 * dietary restrictions.
 * 
 * @author shihan
 *
 */
public class Guest {
  // Fields declaration
  private String dietaryRestriction = ""; // The dietary restriction of current guest
  private static int guestIndex; // The the amount of guest(s) currently created on the
                                 // static
  private int numberOfGuest; // The guest's index starting with 1

  /**
   * Resets the counting of newly constructed guest indexes, so that the next new Guest
   * that is created will be associated with the guest index of one.
   * 
   * Note: that this will be helpful when running several tests, or solving solving
   * several dessert simulation problems. And that this should never be called from
   * ServingQueue.java
   */
  public static void resetNextGuestIndex() {
    guestIndex = 0; // Reset the index
  }

  /**
   * Constructs a new guest with no dietary restrictions. This guest should be associated
   * with an index that is one larger than the previously constructed guest (or 1, if no
   * prior guest, or if resetNextGuestIndex() was called more recently).
   */
  public Guest() {
    guestIndex++; // Increase index to 1 larger than previous guest
    this.numberOfGuest = guestIndex; // Set the index to this guest
    this.dietaryRestriction = ""; // No dietary restriction
  }

  /**
   * Constructs a new guest with the specified dietary restrictions. This guest should be
   * associated with an index that is one larger than the previously constructed guest (or
   * 1, if no prior guest, or if resetNextGuestIndex() was called more recently).
   * 
   * @param dietaryRestriction describes requirements for what this guest can and cannot
   *        eat
   */
  public Guest(String dietaryRestriction) {
    guestIndex++; // Increase index to 1 larger than previous guest
    this.numberOfGuest = guestIndex; // Set the index to this guest
    this.dietaryRestriction = dietaryRestriction; // Set the dietary restriction
  }

  /**
   * Access whether this guest has any dietary restrictions or not
   * 
   * @return true for guests constructed using new Guest(String), false otherwise
   */
  public boolean hasDietaryRestriction() {
    // If the guest's dietary restriction is not empty, return true
    if (this.dietaryRestriction != "") {
      return true;
    }
    // Otherwise, return false
    return false;
  }

  /**
   * The string representation of a Guest should be formatted as, for examples: #3(no
   * dairy) for a guest with a guest index of 3 and the dietary restriction of "no dairy",
   * or: #4 for a guest with a guest index of 4 and no dietary restriction
   * 
   * @return string representing the guest index and any dietary restriction they might
   *         have
   * @see java.lang.Object#toString()
   */
  public String toString() {
    String info = ""; // Create a string to store the information of guest to return

    // If the guest has the dietary restriction, return the number and dietary restriction
    if (hasDietaryRestriction()) {
      info = "#" + this.numberOfGuest + "(" + this.dietaryRestriction + ")";
    } else { // Otherwise, print number only
      info = "#" + this.numberOfGuest;
    }
    // Return the guest's information
    return info;
  }
  
}
