public class Airplanes {
    //Object attributes/vars
    private String planeId;
    private int capacity;

    //Object constructors
    public Airplanes(String id, int cap){
        this.planeId = id;
        this.capacity = cap;
    }

    //Object methods
    //Returns the planes id
    public String getPlaneId(){
        return this.planeId;
    }

    //Returns the capacity of the plane
    public int getCapacity(){
        return this.capacity;
    }

    public String toString(){
        return this.planeId + "  (" + this.capacity + ")";
    }
}
