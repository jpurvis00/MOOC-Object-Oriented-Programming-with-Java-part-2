package boxes;

import java.util.Objects;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if(weight < 0)
            throw new IllegalArgumentException("Weight must be 0 or above.");

        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return Objects.equals(name, thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
