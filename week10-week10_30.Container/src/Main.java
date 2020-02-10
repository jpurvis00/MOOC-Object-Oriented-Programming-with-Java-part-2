import containers.ProductContainer;
import containers.ContainerHistory;
import containers.ProductContainerRecorder;

public class Main {

    public static void main(String[] args) {
        /*ProductContainer juice = new ProductContainer("Juice", 1000.0);
        ContainerHistory history = new ContainerHistory();
        juice.addToTheContainer(1000.0);
        history.add(3);
        juice.takeFromTheContainer(11.3);
        history.add(2);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        history.add(7);
        history.add(2);
        System.out.println(juice);           // Juice: volume = 989.7, space 10.299999999999955
        System.out.println(history);
        System.out.println("max: " + history.maxValue());
        System.out.println("min: " + history.minValue());
        System.out.println("ave: " + history.average());
        System.out.println("fluct: " + history.greatestFluctuation());
        System.out.println("variance: " + history.variance());*/

        // the well known way:
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);           // Juice: volume = 989.7, free space 10.3
        System.out.println(juice.history()); // [1000.0]
        System.out.println();
        juice.printAnalysis();
    }

}
