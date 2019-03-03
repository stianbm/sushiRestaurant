import java.util.LinkedList;


/**
 * This class implements a waiting area used as the bounded buffer, in the producer/consumer problem.
 */
public class WaitingArea {
	
	private LinkedList customerList;
	private SynchronizedInteger customerCounter;
	

    /**
     * Creates a new waiting area.
     *
     * @param size The maximum number of Customers that can be waiting.
     */
    public WaitingArea(int size) {
        // TODO Implement required functionality
    	
    	/* Create a fifo list, maybe linked, to keep track of customers. Also keep a SynchronizedInteger counter for the list.
    	 * 
    	 */
    }
    
    public WaitingArea() {
    	customerList = new LinkedList();
    	customerCounter = new SynchronizedInteger(0);
    	
    	System.out.println("Waiting area created");
    }

    /**
     * This method should put the customer into the waitingArea
     *
     * @param customer A customer created by Door, trying to enter the waiting area
     */
    public synchronized void enter(Customer customer) {
        // TODO Implement required functionality
    	
    	/* Leave checking to door, so just add customer to the customer list and update the counter
    	 * 
    	 */
    }

    /**
     * @return The customer that is first in line.
     */
    public synchronized Customer next() {
        // TODO Implement required functionality
    	
    	/* Leave checking to door, so just return first customer from list, then update list and counter.
    	 * 
    	 */
    	
    	return new Customer(0);
    }

    // Add more methods as you see fit
    
    
}
