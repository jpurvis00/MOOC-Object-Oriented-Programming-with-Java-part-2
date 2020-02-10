package containers;

public class ProductContainerRecorder extends ProductContainer {
    //Object attributes/instance vars
    private ContainerHistory contHistory = new ContainerHistory();

    //Object constructors
    public ProductContainerRecorder(String productName, double capacity, double initialVolume){
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.contHistory.add(initialVolume);
    }

    //Object methods
    /*Returns all elements in the ContainerHistory arrayList*/
    public String history(){
        return this.contHistory.toString();
    }

    /*Adds an amount to the container and then adds the new volume to the ContainerHistory arrayList*/
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.contHistory.add(super.getVolume());
    }

    /*Subtracts an amount to the container and then adds the new volume to the ContainerHistory arrayList*/
    public double takeFromTheContainer(double amount){
        double amt = super.takeFromTheContainer(amount);
        this.contHistory.add(super.getVolume());
        return amt;
    }

    /*Display all info on container*/
    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + this.contHistory.maxValue());
        System.out.println("Smallest product amount: " + this.contHistory.minValue());
        System.out.println("Average: " + this.contHistory.average());
        System.out.println("Greatest change: " + this.contHistory.greatestFluctuation());
        System.out.println("Variance: " + this.contHistory.variance());
    }
}
