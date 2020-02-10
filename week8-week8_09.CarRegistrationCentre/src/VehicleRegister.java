import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    //Object attributes/vars
    private HashMap<RegistrationPlate, String> registrationList;

    //Object constructors
    public VehicleRegister(){
        this.registrationList = new HashMap<RegistrationPlate, String>();
    }

    //Object methods
    //Adds info to a hashMap and returns false if it already exists and true if added
    public boolean add(RegistrationPlate plate, String owner){
        if(this.registrationList.containsKey(plate)){
            return false;
        }
        else {
            this.registrationList.put(plate, owner);
            return true;
        }
    }

    //Returns the cars owner if it exists or null if it doesn't
    public String get(RegistrationPlate plate){
        if(!this.registrationList.containsKey(plate))
            return null;

        return this.registrationList.get(plate);

    }

    //Deletes the cars owner if it exists and returns true, false if it doesn't exist
    public boolean delete(RegistrationPlate plate){
        if(this.registrationList.containsKey(plate)) {
            this.registrationList.remove(plate);
            return true;
        } else {
            return false;
        }
    }

    //Displays all registration plates
    public void printRegistrationPlates(){
        for(RegistrationPlate plates: this.registrationList.keySet()){
            System.out.println(plates);
        }
    }

    //Stores all owners in an arrayList only if they do not already exist in the arrayList
    public void printOwners(){
        ArrayList<String> ownerList = new ArrayList<String>();

        for(RegistrationPlate plates: this.registrationList.keySet()){
            if(!ownerList.contains(this.registrationList.get(plates)))
                ownerList.add(this.registrationList.get(plates));
        }

        printAllOwners(ownerList);
    }

    //Prints out all unique owners
    private void printAllOwners(ArrayList<String> ownerList){
        for(int i = 0; i < ownerList.size(); i++){
            System.out.println(ownerList.get(i));
        }
    }
}
