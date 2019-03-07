/**
 * This class implements a customer, which is used for holding data and update
 * the statistics
 *
 */
public class Customer {

    private int customerID = 0;

    /**
     * Creates a new Customer. Each customer should be given a unique ID
     */
    public Customer(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Here you should implement the functionality for ordering food as described in
     * the assignment.
     */
    public synchronized void order() {
        // TODO Implement required functionality
    }

    /**
     *
     * @return Should return the customerID
     */
    public int getCustomerID() {
        return this.customerID;
    }

    // Add more methods as you see fit
}
