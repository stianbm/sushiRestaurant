import java.util.LinkedList;

/**
 * This class implements a waiting area used as the bounded buffer, in the producer/consumer problem.
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
     * This method should put the customer into the waitingArea
     *
     * @param customer A customer created by Door, trying to enter the waiting area
     */
    public synchronized void enter(Customer customer) {
        // TODO Implement required functionality

        if (customerList.size() >= size){
            try{
                System.out.println("Enter is waiting");
                this.wait();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
            
        customerList.add(customer);
        System.out.println("Number of waiting customers: " + customerList.size());
    }

    /**
     * @return The customer that is first in line.
     */
    public synchronized Customer next() {
        // TODO Implement required functionality
        return new Customer(0);
    }

    // Add more methods as you see fit
}
