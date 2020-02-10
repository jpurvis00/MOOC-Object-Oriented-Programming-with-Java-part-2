public class Flights {
    //Object attributes/vars
    private String planeId;
    private String depCode;
    private String destCode;

    //Object constructors
    public Flights(String id, String dep, String dest){
        this.planeId = id;
        this.depCode = dep;
        this.destCode = dest;
    }

    //Object methods
    //Returns the planes id
    public String getPlaneId() {
        return this.planeId;
    }

    //Returns the planes departure code
    public String getDepCode() {
        return this.depCode;
    }

    //Returns the planes destination code
    public String getDestCode() {
        return this.destCode;
    }

    public String toString(){
        return this.planeId + "  (" + this.depCode + "-" + this.destCode + ")";
    }
}
