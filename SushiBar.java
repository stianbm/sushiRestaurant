import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SushiBar {

    // SushiBar settings
    private static int waitingAreaCapacity = 15;
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

    // Variable to keep track of number of waitresses that are done
    private static SynchronizedInteger doneWaitressCounter;

    public static void main(String[] args) {
        log = new File(path + "log.txt");

        // Initializing shared variables for counting number of orders
        customerCounter = new SynchronizedInteger(0);
        totalOrders = new SynchronizedInteger(0);
        servedOrders = new SynchronizedInteger(0);
        takeawayOrders = new SynchronizedInteger(0);

        // Initialize counter for keeping track of done waitresses
        doneWaitressCounter = new SynchronizedInteger(0);

        Clock clock = new Clock(duration);

        WaitingArea waitingArea = new WaitingArea(waitingAreaCapacity);

        new Thread(new Door(waitingArea)).start();

        for (int i = 0; i < waitressCount; i++) {
            new Thread(new Waitress(waitingArea)).start();
        }

        System.out.println("SushiBar done");
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
            e.printStackTrace();
        }
    }

    // TODO make SushiBar wait until everyone are done before closing. Create method
    // waitressDone with SynchronizedInteger, then check number of done waitresses
    // in a while loop. In loop call this.wait, then call SushiBar.notify when
    // waitress leaves.

    public static synchronized void waitressDone(){
        doneWaitressCounter.increment();
        if(!(doneWaitressCounter.get() < waitressCount)){
            write("***** NO MORE CUSTOMERS - THE SHOP IS CLOSED NOW. *****");
        }
    }
}
