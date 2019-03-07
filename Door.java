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

        while (SushiBar.isOpen) {

            addNewCustomer();

            // Wait for a random amount of time
            try {
                wait = ThreadLocalRandom.current().nextInt(0, SushiBar.doorWait + 1);
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        SushiBar.write("***** DOOR CLOSED *****");
    }

    // Add more methods as you see fit

    /**
     * Generates a new customer using the customerID, only one door so doesn't need
     * to be syncrhonized. Add the customer to the waiting area and notify the
     * waitresses.
     */
    private void addNewCustomer() {

        Customer customer = new Customer(customerID++);
        waitingArea.enter(customer);

        synchronized (waitingArea) {
            waitingArea.notify();
        }
    }
}
