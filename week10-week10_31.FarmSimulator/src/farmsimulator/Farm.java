package farmsimulator;

import java.util.ArrayList;

public class Farm implements Alive{
    //Object attributes/instance vars
    private String farmOwner;
    private Barn farmBarn;
    private ArrayList<Cow> cows;

    //Object constructors
    public Farm(String name, Barn barn){
        this.farmOwner = name;
        this.farmBarn = barn;
        this.cows = new ArrayList<Cow>();
    }

    //Object methods
    public String getOwner(){
        return this.farmOwner;
    }

    public void addCow(Cow cow){
        this.cows.add(cow);
    }

    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.farmBarn.installMilkingRobot(milkingRobot);
    }

    public void manageCows(){
        this.farmBarn.takeCareOf(this.cows);
    }

    @Override
    public String toString(){
        String haveCows = "";

        if(this.cows.isEmpty())
            haveCows = "No cows.";
        else {
            haveCows = "Animals:\n";
            for(Cow cow : this.cows){
                haveCows += "\t" + cow + "\n";
            }
        }

        return "Farm Owner: " + this.farmOwner + "\nBarn bulk tank: " + this.farmBarn.getBulkTank() + "\n" + haveCows;
    }

    @Override
    public void liveHour(){
        for(Cow cow : this.cows){
            cow.liveHour();
        }
    }
}
