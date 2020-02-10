package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
    //Object attributes/instance vars
    private Map<Film, List<Rating>> filmRatings;

    //Object constructors
    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.filmRatings = ratings;
    }

    //Object methods
    /*For sorting films based on their ratings*/
    @Override
    public int compare(Film f1, Film f2){
        double f1Average = 0;
        double f2Average = 0;

        for(Rating rating : this.filmRatings.get(f1)){
            f1Average += rating.getValue();
        }

        f1Average /= this.filmRatings.size();

        for(Rating rating : this.filmRatings.get(f2)){
            f2Average += rating.getValue();
        }

        f2Average /= this.filmRatings.size();

        if (f1Average == f2Average) {
            return 0;
        } else if (f1Average > f2Average) {
            return -1;
        } else {
            return 1;
        }
    }
}
