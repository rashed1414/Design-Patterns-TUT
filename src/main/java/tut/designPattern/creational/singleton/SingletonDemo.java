package tut.designPattern.creational.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        // This is to make sure that only one instance is created

        Singleton singletonInstance1 = Singleton.getSingletonInstance();
        System.out.println("singletonInstance1: " + singletonInstance1);
        Singleton singletonInstance2 = Singleton.getSingletonInstance();
        System.out.println("singletonInstance2: " + singletonInstance2);

        if (singletonInstance1 == singletonInstance2) {
            System.out.println("Both Instances are same");
        }

        System.out.println("End of Singleton Demo");
    }
}
