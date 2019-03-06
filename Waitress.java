/**
 * This class implements the consumer part of the producer/consumer problem.
 * One waitress instance corresponds to one consumer.
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
        // TODO Implement required functionality

        this.waitingArea = waitingArea;
    }

    /**
     * This is the code that will run when a new thread is
     * created for this instance
     */
    @Override
    public void run() {
        // TODO Implement required functionality

        while(true){
            customer = waitingArea.next();

            try{
                System.out.println("Waitress sleep first");
                Thread.sleep(SushiBar.waitressWait);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }

            try{
                System.out.println("Waitress sleep second");
                Thread.sleep(SushiBar.customerWait);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}

