public class Book implements ToBeStored {
    //Object attributes/vars
    private String writer;
    private String name;
    private double weight;

    //Object constructors
    public Book(String writer, String name, double weight){
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    //Object methods
    @Override //override ToBeStored weight() method
    public double weight() {
        return this.weight;
    }

    @Override //override the object class toString method
    public String toString(){
        return this.writer + ": " + this.name;
    }


}
