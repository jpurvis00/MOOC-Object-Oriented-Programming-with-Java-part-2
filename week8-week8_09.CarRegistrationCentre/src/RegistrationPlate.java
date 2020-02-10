
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override //We are overriding the object classes equals method with one of our own.  This is done so
              //we can overide the hashCode method as well.  We are doing this so we can use an object as
              //the key value in a hashmap.  We need to compare the elements in the object to the other object
              //elements to see if they are equal since the objects will always have different internal values.
    public boolean equals(Object object){
        if(object == null) return false;

        //Checks to see if object is of the same class type as this class
        if(getClass() != object.getClass()) return false;

        //Type cast object to be a RegistrationPlate object so we can compare them
        RegistrationPlate compared = (RegistrationPlate) object;

        if(this.regCode != compared.regCode) return false;

        if(this.country == null || !this.country.equals(compared.country)) return false;

        return true;
    }

    @Override
    public int hashCode(){
        if(this.regCode == null) return 7;

        return this.regCode.hashCode() + this.country.hashCode();
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

}
