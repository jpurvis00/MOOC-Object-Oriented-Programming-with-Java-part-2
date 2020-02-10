package farmsimulator;

public class BulkTank {
    //Object attributes/instance vars
    private double tankCapacity;
    private double tankVolume;

    //Object constructors
    public BulkTank(){
        this.tankCapacity = 2000;
        this.tankVolume = 0;
    }

    public BulkTank(double capacity){
        this.tankCapacity = capacity;
        this.tankVolume = 0;
    }

    //Object methods
    public double getCapacity(){
        return this.tankCapacity;

    }

    public double getVolume(){
        return this.tankVolume;
    }

    public double howMuchFreeSpace(){
        return getCapacity() - getVolume();
    }

    public void addToTank(double amount){
        if(this.tankVolume + amount > this.tankCapacity)
            this.tankVolume = this.tankCapacity;
        else
            this.tankVolume += amount;
    }

    public double getFromTank(double amount){
        if(this.tankVolume - amount < 0)
            this.tankVolume = 0;
        else
            this.tankVolume -= amount;

        return this.tankVolume;
    }

    @Override
    public String toString(){
        return Math.ceil(this.tankVolume) + "/" + Math.ceil(this.tankCapacity);
    }
}
