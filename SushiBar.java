import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SushiBar {

    // SushiBar settings
    public static int waitingAreaCapacity = 15;
    private static int waitressCount = 8;
    private static int duration = 4;
    public static int maxOrder = 10;
    public static int waitressWait = 50; // Used to calculate the time the waitress spends before taking the order
    public static int customerWait = 2000; // Used to calculate the time the customer spends eating
    public static int doorWait = 100; // Used to calculate the interval at which the door tries to create a customer
    public static boolean isOpen = true;

    // Creating log file
    private static File log;
    private static String path = "./";

    // Variables related to statistics
    public static SynchronizedInteger customerCounter;
    public static SynchronizedInteger servedOrders;
    public static SynchronizedInteger takeawayOrders;
    public static SynchronizedInteger totalOrders;

    // SushiBar variables
    private static SynchronizedInteger customersInRestaurant;

    public static void main(String[] args) {
        log = new File(path + "log.txt");

        // Initializing shared variables for counting number of orders
        customerCounter = new SynchronizedInteger(0);
        totalOrders = new SynchronizedInteger(0);
        servedOrders = new SynchronizedInteger(0);
        takeawayOrders = new SynchronizedInteger(0);
        customersInRestaurant = new SynchronizedInteger(0);

        // TODO initialize the bar and start the different threads

        /*
         * Have a run loop that polls the three conditionals Alternatively use
         * interrupts and some kind of sleep to improve perfomance?
         * 
         * Keep track of number of customers currently in the restaurant with a
         * synchronizedInteger. Initialize the door and waitress threads, then enter a
         * loop. At the end of the loop, check if !isOpen && nCustomers == 0 &&
         * waitingArea.n == 0 if !isOpen and no customers then signalAll to terminate
         * and terminate itself. Maybe wait until door and waitresses terminate before
         * terminating itself?
         */

        Clock clock = new Clock(duration);

        WaitingArea waitingArea = new WaitingArea();

        new Thread(new Door(waitingArea)).start();

        new Thread(new Waitress(waitingArea)).start();

        System.out.println("Last line of SushiBar");
    }

    // Writes actions in the log file and console
    public static void write(String str) {
        try {
            FileWriter fw = new FileWriter(log.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Clock.getTime() + ", " + str + "\n");
            bw.close();
            System.out.println(Clock.getTime() + ", " + str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
