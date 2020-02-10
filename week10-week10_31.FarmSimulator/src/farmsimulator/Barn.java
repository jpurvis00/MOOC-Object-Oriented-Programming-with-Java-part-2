package farmsimulator;

import java.util.Collection;

public class Barn {
    //Object attributes/instance vars
    private BulkTank barnTank;
    private MilkingRobot barnRobot;

    //Object constructors
    public Barn(BulkTank tank){
        this.barnTank = tank;
        this.barnRobot = new MilkingRobot();
    }

    //Object methods
    public BulkTank getBulkTank(){
        return this.barnTank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.barnRobot = milkingRobot;
        this.barnRobot.setBulkTank(this.barnTank);
    }

    public void takeCareOf(Cow cow){
        this.barnRobot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows){
        for(Cow cow : cows){
            this.barnRobot.milk(cow);
        }
    }

    public String toString(){
        return this.barnTank.toString();
    }

}
