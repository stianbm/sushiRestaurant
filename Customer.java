/**
 * This class implements a customer, which is used for holding data and update the statistics
 *
 */
public class Customer {
	
	private int customerID = 0;
	

    /**
     *  Creates a new Customer.
     *  Each customer should be given a unique ID
     *  
     *  @param _customerID id generated and passed by Door.
     */
    public Customer(int _customerID) {
        // TODO Implement required functionality
    	
    	/* Update sushiBar.customerCounter.
    	 * Set private id passed from door.
    	 */
    	
    	this.customerID = _customerID;
    	
    	System.out.println("Customer " + this.customerID + " created");
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
    	return this.customerID;
    }

    // Add more methods as you see fit
    
    
    /**
     * Make customer wait for meals * customerWait, then terminate.
     * 
     * @param meals	the amount of meals to be eaten.
     */
    public void eat(int meals) {
    	// TODO Implement required functionality
    }
}
