/**
 * This class implements the Door component of the sushi bar assignment
 * The Door corresponds to the Producer in the producer/consumer problem
 */
public class Door implements Runnable {

    /**
     * Creates a new Door. Make sure to save the
     * @param waitingArea   The customer queue waiting for a seat
     */
    public Door(WaitingArea waitingArea) {
        // TODO Implement required functionality
    	
    	/* Save waitingArea and initialize SyncrhonizedInteger customerID to zero.
    	 * 
    	 */
    }

    /**
     * This method will run when the door thread is created (and started)
     * The method should create customers at random intervals and try to put them in the waiting area
     */
    @Override
    public void run() {
        // TODO Implement required functionality
    	
    	/* Use wait to create customers at intervals, pass customerID into their constructors.
    	 * Check SushiBar.isOpen and waitingArea.counter before creatig customers.
    	 * Do this inside a run loop, exit on signal from SushiBar then terminate.
    	 */
    }

    // Add more methods as you see fit
}
