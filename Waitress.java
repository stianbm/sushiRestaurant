/**
 * This class implements the consumer part of the producer/consumer problem. One
 * waitress instance corresponds to one consumer.
 */
public class Waitress implements Runnable {

    private WaitingArea waitingArea;
    private Customer customer;

    /**
     * Creates a new waitress. Make sure to save the parameter in the class
     *
     * @param waitingArea The waiting area for customers
     */
    Waitress(WaitingArea waitingArea) {
        this.waitingArea = waitingArea;
    }

    /**
     * This is the code that will run when a new thread is created for this instance
     */
    @Override
    public void run() {

        // Run while SushiBar is open or there are customers left in the waiting area.
        while (SushiBar.isOpen || waitingArea.getNumberOfWaitingCustomers() > 0) {

            // Fetch customer from waiting area and notify door of this. Make sure a
            // customer is retrieved
            customer = waitingArea.next();
            if (customer != null) {
                System.out.println("WNumber of waiting customers " + waitingArea.getNumberOfWaitingCustomers());
                synchronized (waitingArea) {
                    waitingArea.notify();
                }

                // Wait before taking order from customer
                try {
                    Thread.sleep(SushiBar.waitressWait / 2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                // TODO get orderfrom customer, update stats and wait appropriate time.

                // Wait for customer to finish meal
                try {
                    Thread.sleep(SushiBar.customerWait / 2);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Waitress done");
    }

}
