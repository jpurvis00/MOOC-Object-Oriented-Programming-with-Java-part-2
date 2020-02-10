package containers;

public class ProductContainer extends Container {
    //Object attributes/instance vars
    private String productName;

    //Object constructors
    public ProductContainer(String pName, double capacity){
        super(capacity);
        this.productName = pName;
    }

    //Object methods
    /*Returns product name*/
    public String getName(){
        return this.productName;
    }

    /*Sets product name*/
    public void setName(String newName){
        this.productName = newName;
    }

    /*This toString method is overriding the toString method in the inherited Container class.
    We can also call the inherited method by using super.toString() which displays that methods data.
     */
    @Override
    public String toString(){
        return this.productName + ": " + super.toString();
    }
}
