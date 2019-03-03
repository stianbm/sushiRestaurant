import java.util.LinkedList;


/**
 * This class implements a waiting area used as the bounded buffer, in the producer/consumer problem.
 */
public class WaitingArea {
	
	private LinkedList<Customer> customerList;
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
    	customerList = new LinkedList<Customer>();
    	customerCounter = new SynchronizedInteger(0);
    	
    	System.out.println("Waiting area created");
    }

    /**
     * This method should put the customer into the waitingArea
     * Leave checking to door, so just add customer to the customer list and update the counter.
     *
     * @param customer A customer created by Door, trying to enter the waiting area
     */
    public synchronized void enter(Customer customer) {
    	
    	customerList.add(customer);
    	customerCounter.increment();
    	
    	System.out.println("Added customer " + customer.getCustomerID() + " to waiting area");
    	System.out.println("customerCounter: " + customerCounter.get());
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
    
    
    public int getCustomerCounter() {
    	return customerCounter.get();
    }
}
