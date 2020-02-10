package farmsimulator;

public class MilkingRobot {
    //Object attributes/instance vars
    private BulkTank bulkTank;

    //Object constructors


    //Object methods
    public BulkTank getBulkTank(){
        if(this.bulkTank == null)
            return null;

        return this.bulkTank;
    }

    public void setBulkTank(BulkTank tank){
        this.bulkTank = tank;
    }

    public void milk(Milkable milkable){
        if(this.bulkTank == null)
            throw new IllegalStateException("The MilkingRobot hasn't been installed");

        this.bulkTank.addToTank(milkable.milk());
    }
}
