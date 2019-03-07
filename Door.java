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
        // TODO Implement required functionality

        while (SushiBar.isOpen) {
            addNewCustomer();

            try {
                wait = ThreadLocalRandom.current().nextInt(0, SushiBar.doorWait + 1);
                Thread.sleep(wait);
                System.out.println("Door slept for " + wait + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Door done");
    }

    // Add more methods as you see fit

    private void addNewCustomer() {
        Customer customer = new Customer(customerID++);
        waitingArea.enter(customer);
        synchronized (waitingArea) {
            waitingArea.notify();
        }
    }
}
