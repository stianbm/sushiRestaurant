import java.util.concurrent.ThreadLocalRandom;

/**
 * This class implements the Door component of the sushi bar assignment The Door
 * corresponds to the Producer in the producer/consumer problem
 */
public class Door implements Runnable {

    private int customerID = 0;
    private WaitingArea waitingArea;
    private int wait = 0;

    /**
     * Creates a new Door. Make sure to save the
     * 
     * @param waitingArea The customer queue waiting for a seat
     */
    public Door(WaitingArea waitingArea) {
        // TODO Implement required functionality

        /*
         * Save waitingArea and initialize customerID to zero.
         * 
         */

        this.waitingArea = waitingArea;
        this.customerID = 0;

        System.out.println("Door created");
    }

    /**
     * This method will run when the door thread is created (and started) The method
     * should create customers at random intervals and try to put them in the
     * waiting area
     */
    @Override
    public void run() {
        /*
         * Use wait to create customers at intervals. Do this inside a run loop,
         * terminate when !sushiBar.isOpen.
         */

        while (SushiBar.isOpen) {
            createNewCustomer();

            try {
                wait = ThreadLocalRandom.current().nextInt(0, SushiBar.doorWait + 1);
                Thread.sleep(wait);
                System.out.println("Door slept for " + wait + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Door ran");
    }

    // Add more methods as you see fit

    /**
     * Checks if the bar is open and waiting area has capacity. If so it creates a
     * new customer and adds it to the waiting area. It also passes and increments
     * the customerID to the customer constructor.
     */
    private void createNewCustomer() {
        if (SushiBar.isOpen && waitingArea.getCustomerCounter() < SushiBar.waitingAreaCapacity) {
            Customer customer = new Customer(customerID++);
            waitingArea.enter(customer);

        }
    }
}
