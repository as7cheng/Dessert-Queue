//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ServingQueue
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
 * This class implements a queue of Guest objects, using an array with circular indexing.
 * The first guest added to this array must be added to index 0, the second guest should
 * be added to index 1, etc.
 * 
 * @author shihan
 *
 */
public class ServingQueue {
  // Instance fields
  private Guest[] array; // Array to store guest(s)
  private int capacity; // The maximum of the guests can be added
  private int size; // Current amount of guest in the array
  private int front = -1; // Front index starts with -1
  private int back = -1; // Back index starts with -1


  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue
   * should be initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    this.array = new Guest[seatsAtTable]; // Create a new array
    this.capacity = seatsAtTable; // The maximum of the guests can be added
    this.size = 0; // At beginning, there is no guest in the array
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    // If the size is 0, which means no guest in the array.
    return size == 0;
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were
   * previously added to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is
   *         full
   */
  public void add(Guest newGuest) {
    // If the array is already full, throw the exception
    if (this.size >= this.capacity) {
      throw new IllegalStateException();
    }
    // If the array is still empty
    if (front == -1 && back == -1) {
      // Increase front and back
      // Set this guest as the front and back
      this.front = (this.front + 1) % this.capacity;
      this.back = (this.back + 1) % this.capacity;
      this.array[front] = newGuest;
      this.array[back] = newGuest;
      this.size++; // Size increases 1
    } else { // If the array is not empty
      // Back increases 1 and set the guest as back
      this.back = (this.back + 1) % this.capacity;
      this.array[back] = newGuest;
      this.size++; // Size increases 1
    }
  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does
   * not add or remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() {
    if (isEmpty() == true) {
      throw new IllegalStateException();
    }
    // Return the front, which is the peek of queue
    return this.array[front];
  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * 
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() {
    // If the array is empty, throw a new exception
    if (this.size == 0) {
      throw new IllegalStateException();
    }
    // Store the guest to be removed temporarily
    Guest temp = array[front];
    // Move the front to next index
    this.front = (this.front + 1) % this.capacity;
    // Size decreases 1
    this.size--;
    // Return the guest we stored above
    return temp;
  }

  /**
   * The string representation of the guests in this queue should display each of the
   * guests in this queue (using their toString() implementation), and should display them
   * in a comma separated list that is surrounded by a set of square brackets. (this is
   * similar to the formatting of java.util.ArrayList.toString()). The order that these
   * guests are presented in should be (from left to right) the guest that has been in
   * this queue the longest, to the guest that has been in this queue the shortest. When
   * called on an empty ServingQueue, returns "[]".
   * 
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String orderedGuest = "["; // Declare a string to store the result and return it
    int track = 0; // For using in the for loop and tracking the array
    // When the array is empty
    if (this.size == 0) {
      return "[]";
    }
    // If the array is not empty, iterate it
    while (track < size - 1) {
      // add every guest's information into the string
      orderedGuest = orderedGuest + array[(front + track) % capacity].toString() + ", ";
      track++;
    }
    // Add "]" to the string
    orderedGuest = orderedGuest + array[back] + "]";
    return orderedGuest;
  }

}
