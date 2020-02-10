public class CD implements ToBeStored {
    //Object attributes/vars
    private String artist;
    private String title;
    private int publishingYear;

    //Object constructors
    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.title = title;
        this.publishingYear = publishingYear;
    }

    //Object methods
    @Override  //override ToBeStored weight() method
    public double weight() {
        return 0.1;
    }

    @Override //override the object class toString method
    public String toString(){
        return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
    }
}
