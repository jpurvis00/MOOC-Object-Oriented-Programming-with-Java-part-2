import java.util.ArrayList;
import java.util.HashMap;

public class Airport {
    //Object attributes/vars
    //Will hold all plain objects.  Using a hashmap so we don't duplicate any plane names
    private HashMap<String, Airplanes> planeList;

    //Will hold all flight information
    private ArrayList<Flights> flightList;

    //Object constructors
    public Airport(){
        planeList = new HashMap<String, Airplanes>();
        flightList = new ArrayList<Flights>();
    }

    //Object methods
    //Add a plane object and it's id to a hashmap
    public void addPlanes(String planeId, Airplanes allPlanes){
        this.planeList.put(planeId, allPlanes);
    }

    //Add a flight path object to an arrayList
    public void addFlights(Flights flightInfo){
        this.flightList.add(flightInfo);
    }

    //Prints out all flight info from the arrayList
    public void getFlights(){
        //Go through every Flights object in the flightList arrayList
        for(Flights flights: this.flightList){
            //Get the flight objects planeId
            String id = flights.getPlaneId();

            //Use the flight objects planeId to find that id in the hashMap and assign it to an airplane object
            Airplanes airplane = this.planeList.get(id);

            //Since we got an airplane object in the above statement, we can now access the capacity for
            //that plane through that objects method
            int cap = airplane.getCapacity();

            System.out.println(id + " (" + cap + " ppl) (" + flights.getDepCode() + "-" + flights.getDestCode() + ")");
        }
        System.out.println();
    }

    //Prints out all plane info in the hashmap
    public void getPlanes(){
        //Go through each element in the hashmap and get the planeId
        for(String planeId: this.planeList.keySet()){
            //Get the Airplanes object from the hashmap and assign it to airplane.  This allows us to now
            //get the planeId and the capacity to print out for the user
            Airplanes airplane = this.planeList.get(planeId);
            System.out.println(airplane.getPlaneId() + " (" + airplane.getCapacity() + " ppl)");
        }
        System.out.println();


    }

    //Prints a specified planes info
    public String getPlaneInfo(String id){
        //Goes through each element in the hashmap
        for(String planeId: this.planeList.keySet()){
            //If the planes id is in the hashmap
            if(planeId.equals(id)) {
                //Return the planeId and capacity
                Airplanes airplane = this.planeList.get(planeId);
                return airplane.getPlaneId() + " (" + airplane.getCapacity() + " ppl)";
            }
        }

        return "Plane not found!";
    }
}
