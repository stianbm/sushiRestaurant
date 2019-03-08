import java.util.LinkedList;

/**
 * This class implements a waiting area used as the bounded buffer, in the
 * producer/consumer problem.
 */
public class WaitingArea {

    private int size = 0;
    private LinkedList<Customer> customerList;

    /**
     * Creates a new waiting area.
     *
     * @param size The maximum number of Customers that can be waiting.
     */
    public WaitingArea(int size) {
        customerList = new LinkedList<Customer>();
        this.size = size;

        System.out.println("waitingArea created");
    }

    /**
     * This method should put the customer into the waitingArea Leave checking to
     * door, so just add customer to the customer list and update the counter.
     *
     * @param customer A customer created by Door, trying to enter the waiting area
     */
    public synchronized void enter(Customer customer) {

        // If there isn't room for the new customer, the thread waits.
        if (customerList.size() >= size) {
            try {
                System.out.println("Enter is waiting");
                this.wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        customerList.add(customer);
        SushiBar.write("Customer " + customer.getCustomerID() + " is waiting");
        System.out.println("Number of waiting customers: " + customerList.size());
    }

    /**
     * Checking is done by the waitress, so just return the first customer in the
     * list
     * 
     * @return The customer that is first in line.
     */
    public synchronized Customer next() {

        // If there are no available customers, the thread waits.
        if (!(customerList.size() > 0)) {
            try {
                System.out.println("Next is waiting");
                this.wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // pollFirst() returns null if list is empty, waitress checks for this.
        return customerList.pollFirst();

    }

    // Add more methods as you see fit

    public synchronized int getNumberOfWaitingCustomers() {
        return this.customerList.size();
    }
}
