import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class implements a customer, which is used for holding data and update
 * the statistics
 *
 */
public class Customer {

    private int customerID = 0;

    /**
     * Creates a new Customer. Each customer should be given a unique ID
     * 
     * @param _customerID id generated and passed by Door.
     */
    public Customer(int _customerID) {
        // TODO Implement required functionality

        /*
         * Set private id passed from door.
         */

        this.customerID = _customerID;

        System.out.println("Customer " + this.customerID + " created");
    }

    /**
     * Here you should implement the functionality for ordering food as described in
     * the assignment.
     */
    public synchronized Map order() {
        // TODO Implement required functionality

        /*
         * Use random to decide order, own method. Wait until meal is eaten, then
         * terminate.
         */

        int orders = ThreadLocalRandom.current().nextInt(0, SushiBar.maxOrder + 1);
        int takeaways = SushiBar.maxOrder - orders;
        Map order = new HashMap();
        order.put("orders", orders);
        order.put("takeaways", takeaways);

        System.out.println("Orders: " + orders);
        System.out.println("Takeaways: " + takeaways);

        return order;
    }

    /**
     *
     * @return Should return the customerID
     */
    public int getCustomerID() {
        return this.customerID;
    }

    // Add more methods as you see fit

    /**
     * Make customer wait for meals * customerWait, then terminate.
     * 
     * @param meals the amount of meals to be eaten.
     */
    public void eat(int meals) {
        // TODO Implement required functionality
    }
}
