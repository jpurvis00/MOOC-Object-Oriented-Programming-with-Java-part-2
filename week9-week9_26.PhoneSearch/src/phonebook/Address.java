package phonebook;

public class Address {
    //Object attributes/instance vars
    private String street;
    private String city;

    //Object constructors
    public Address(){

    }

    public Address(String street, String cty){
        this.street = street;
        this.city = cty;
    }

    //Object methods
    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String cty){
        this.city = cty;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    @Override
    public String toString(){
        return "address: " + this.street + " " + this.city;
    }
}
