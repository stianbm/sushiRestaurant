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
     */
    public Customer(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Here you should implement the functionality for ordering food as described in
     * the assignment.
     */
    public synchronized void order() {

        // Generate a random order.
        int orders = ThreadLocalRandom.current().nextInt(0, SushiBar.maxOrder + 1);
        int takeaways = SushiBar.maxOrder - orders;

        // Wait for customer to finish the meal
        try {
            SushiBar.write(Thread.currentThread().getName() + " Customer " + this.getCustomerID() + " is now eating");
            Thread.sleep(SushiBar.customerWait * orders);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Update order stats, do this here instead of returning them to waitress,
        // although that would make more sense.
        SushiBar.servedOrders.add(orders);
        SushiBar.takeawayOrders.add(takeaways);
        SushiBar.totalOrders.add(orders + takeaways);
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
