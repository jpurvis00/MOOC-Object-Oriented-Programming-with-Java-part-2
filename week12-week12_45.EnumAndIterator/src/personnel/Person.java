package personnel;

public class Person {
    //Object attributes/instance vars
    private String name;
    private Education education;

    //Object constructors
    public Person(String name, Education education){
        this.name = name;
        this.education = education;
    }

    //Object methods
    public Education getEducation() {
        return this.education;
    }

    @Override
    public String toString(){
        return this.name + ", " + this.education;
    }
}
