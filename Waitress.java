/**
 * This class implements the consumer part of the producer/consumer problem.
 * One waitress instance corresponds to one consumer.
 */
public class Waitress implements Runnable {

    /**
     * Creates a new waitress. Make sure to save the parameter in the class
     *
     * @param waitingArea The waiting area for customers
     */
    Waitress(WaitingArea waitingArea) {
        // TODO Implement required functionality
    }

    /**
     * This is the code that will run when a new thread is
     * created for this instance
     */
    @Override
    public void run() {
        // TODO Implement required functionality
    	
    	/* Have running loop
    	 * Check waiting room counter then either wait or get customer.
    	 * Wait for waitressWait then take order and update statistics.
    	 * Update restaurant counter and call customer.eat().
    	 * Update SushiBar.servedOrders, takeawayOrders and totalOrders.
    	 * Wait until customer has eaten before fetching another.
    	 */
    	
    	
    }


}

