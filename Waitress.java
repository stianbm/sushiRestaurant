/**
 * This class implements the consumer part of the producer/consumer problem. One
 * waitress instance corresponds to one consumer.
 */
public class Waitress implements Runnable {

    private WaitingArea waitingArea;
    private Customer currentCustomer = null;

    /**
     * Creates a new waitress. Make sure to save the parameter in the class
     *
     * @param waitingArea The waiting area for customers
     */
    Waitress(WaitingArea waitingArea) {
        this.waitingArea = waitingArea;

        System.out.println("waitress created");
    }

    /**
     * This is the code that will run when a new thread is created for this instance
     */
    @Override
    public void run() {
        // TODO Implement required functionality

        /*
         * Have running loop Check waiting room counter then either wait or get
         * customer. Wait for waitressWait then take order and update statistics. Update
         * restaurant counter and call customer.eat(). Update SushiBar.servedOrders,
         * takeawayOrders and totalOrders. Wait until customer has eaten before fetching
         * another.
         */

        while (SushiBar.isOpen || waitingArea.getCustomerCounter() > 0) {
            fetchCustomer();
            // TODO make check syncrhonous with fetchCustomer()

            if (currentCustomer == null) {
                System.out.println("Waitress fetched customer null");
                try {
                    waitingArea.wait();
                } catch (Exception e) {
                    System.out.println("waitress exception");
                }

            } else {
                System.out.println("Waitress fetched customer: " + currentCustomer.getCustomerID());
                // TODO take order and wait for customer to finish meal.
            }
        }
        System.out.println("Waitress done");
    }

    /**
     * Checks if the waiting area has any customers, then either fetches one and
     * stores it in currentCustomer, or sets it to null.
     */
    private void fetchCustomer() {
        synchronized (waitingArea) {
            if (waitingArea.getCustomerCounter() > 0) {
                currentCustomer = waitingArea.next();
            } else {
                currentCustomer = null;
            }
        }
    }

}
