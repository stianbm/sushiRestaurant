import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        log = new File(path + "log.txt");

        // Initializing shared variables for counting number of orders
        customerCounter = new SynchronizedInteger(0);
        totalOrders = new SynchronizedInteger(0);
        servedOrders = new SynchronizedInteger(0);
        takeawayOrders = new SynchronizedInteger(0);

        Clock clock = new Clock(duration);

        WaitingArea waitingArea = new WaitingArea(waitingAreaCapacity);

        new Thread(new Door(waitingArea)).start();

        ArrayList<Thread> waitressThreads = new ArrayList<Thread>();

        for (int i = 0; i < waitressCount; i++) {
            Thread tempWaitressThread = new Thread(new Waitress(waitingArea));
            waitressThreads.add(tempWaitressThread);
            tempWaitressThread.start();
        }

        for (int i = 0; i < waitressThreads.size(); i++) {
            try {
                waitressThreads.get(i).join();
            } catch (InterruptedException exception) {
                write(exception.getMessage());
            }

        }

        write(Thread.currentThread().getName() + " ***** NO MORE CUSTOMERS - THE SHOP IS CLOSED NOW. *****");
        write(Thread.currentThread().getName() + " customerCounter: " + customerCounter.get());
        write(Thread.currentThread().getName() + " servedOrders: " + servedOrders.get());
        write(Thread.currentThread().getName() + " takeawayOrders: " + takeawayOrders.get());
        write(Thread.currentThread().getName() + " totalOrders: " + totalOrders.get());
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
}
