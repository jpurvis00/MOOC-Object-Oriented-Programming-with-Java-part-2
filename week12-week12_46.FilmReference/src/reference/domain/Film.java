package reference.domain;

import java.util.Objects;

public class Film {
    //Object attributes/instance vars
    private String name;

    //Object constructors
    public Film(String name){
        this.name = name;
    }

    //Object methods
    public String getName(){
        return this.name;
    }

    public void setName(String name){ this.name = name;}

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
