package tut.designPattern.creational.singleton;

public class Singleton {
    /*
     * This is Singleton Demo that is part of design Pattern
     * *****************************************************
     * Singleton specifications:
     * * Single Instance
     * ** Thread Safe
     * *** Lazily Loaded
     * **** Has Private Constructor
     * ***** Instance can be Called using Getter Method
     */

    // volatile keyword used to make sure that multiple threads handle
    // the uniqueInstance variable correctly when it is being initialized
    // to the Singleton instance.
    private static volatile Singleton singletonInstance = null;

    private Singleton() {
        // Private Constructor to prevent instantiation from other classes
        // This is to make sure that only one instance is created
        // and to prevent the use of reflection to break the singleton pattern
        // by instantiating multiple instances using the constructor.
        // Reflection can be prevented by throwing an exception in the constructor
        // if the instance is already created.

        System.out.println("Singleton Instance Created");
        if (singletonInstance != null) {
            throw new RuntimeException("Use getSingletonInstance() method to get the instance");
        }
    }

    public static Singleton getSingletonInstance() {
        // Lazy Loading (if not null then return the instance) - Thread Safe (synchronized)
        // We only synchronize the first time through, this is called "Double-Checked Locking"
        // We use Lazy Loading to make sure that the instance is created only when it is needed
        // to avoid memory wastage and performance issues
        if (singletonInstance == null) {
            System.out.println("Creating Singleton Instance");
            synchronized (Singleton.class) {
                System.out.println("Thread No: " + Thread.currentThread().getId() + " is creating Singleton Instance");
                singletonInstance = new Singleton();
            }
        } else {
            System.out.println("Singleton Instance Already Created");
        }

        return singletonInstance;
    }


}
