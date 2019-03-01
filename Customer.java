/**
 * This class implements a customer, which is used for holding data and update the statistics
 *
 */
public class Customer {

    /**
     *  Creates a new Customer.
     *  Each customer should be given a unique ID
     */
    public Customer() {
        // TODO Implement required functionality
    	
    	/* Update sushiBar.customerCounter.
    	 * Set private id passed from door.
    	 */
    }


    /**
     * Here you should implement the functionality for ordering food as described in the assignment.
     */
    public synchronized void order(){
        // TODO Implement required functionality
    	
    	/* Use random to decide order, own method.
    	 * Update SushiBar.servedOrders, takeawayOrders and totalOrders.
    	 * Wait until meal is eaten, then terminate.
    	 */
    }

    /**
     *
     * @return Should return the customerID
     */
    public int getCustomerID() {
        // TODO Implement required functionality
    }

    // Add more methods as you see fit
}
