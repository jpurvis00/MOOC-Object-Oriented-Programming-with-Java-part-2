package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{
    //Object attributes/instance vars
    private List<Movable> groupList;

    //Object constructors
    public Group(){
        this.groupList = new ArrayList<Movable>();
    }

    //Object methods
    public void addToGroup(Movable movable){
        this.groupList.add(movable);
    }

    @Override
    public String toString(){
        String allGroup = "";

        for(Movable m : this.groupList){
            allGroup += m + "\n";
        }

        return allGroup;
    }

    @Override
    public void move(int dx, int dy){
        for(Movable m : this.groupList){
            m.move(dx, dy);
        }
    }
}
