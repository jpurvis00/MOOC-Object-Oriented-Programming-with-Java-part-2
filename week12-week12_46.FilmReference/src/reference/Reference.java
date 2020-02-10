package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    //Object attributes/instance vars
    private RatingRegister ratingRegister;
    private List<Person> reviewers;

    //Object constructors
    public Reference(RatingRegister ratingRegister){
        this.ratingRegister = ratingRegister;
        this.reviewers = this.ratingRegister.reviewers();
    }

    //Object methods
    /*Recommends a film based on existing reviews of the film by using the filmComparator class
    * to look at all the reviews and then sort them from best to worst.  We then just return the
    * best film.  This works for a user who has never rated a film.*/
    public Film recommendFilm(Person person){
        /*If the user has not rated all movies that exist in the ratings, return a recommendation for a movie*/
        if(this.ratingRegister.getPersonalRatings(person).isEmpty()){
            /*Gets a list of films sorted by ratings*/
            List<Film> films = sortFilms();

            /*Return the first film in the sorted list that hasn't been watched*/
            return films.get(0);
        }
        /*User has rating so we need to recommend a film based on their ratings and other peoples
        * ratings.*/
        else {
            int highScore = 0;
            Film rFilm = new Film("null"); //Used to hold the recommend film object

            /*Holds all films/ratings for the person we are recommending the film for*/
            Map<Film, Rating> personRatings = new HashMap<Film, Rating>(getSpecifiedPersonsRatings(person));

            /*Cycle through all reviewers*/
            for(Person reviewer : this.reviewers){
                /*Do not do the following if the reviewer is the same as the person we are recom. a film for*/
                if(!reviewer.equals(person)){
                    /*Holds all films/ratings for the reviewer we comparing lists to*/
                    Map<Film, Rating> reviewerRatings = new HashMap<Film, Rating>(getSpecifiedPersonsRatings(reviewer));

                    /*Compare the reviewers review scores to the person who we are getting the recommendation for
                    * and return a score.*/
                    int score = compareLists(personRatings, reviewerRatings);

                    /*Do this for the first time or if we receive a new high score.  Get the recommended film
                    * and set the place holder object's name to the recommended film.*/
                    if(score > highScore || highScore == 0) {
                        highScore = score;
                        rFilm.setName(getRecommendedFilm(person, reviewerRatings));
                    }
                }
            }

            /*I guess I've done something kind of strange.  It probably comes from creating a new film
            * object to store the recommended film in.  I then set the name of that object to the name of
            * the recommended film.  The course automated test looks for a null to be returned if all
            * films have been watched.  While the rFilm object is set to null, returning that object is not
            * what the test was looking for.  It's looking straight up for the value null, not a object
            * who's value is null.  I've gotten around this by checking the object for null, if it is null I
            * return null instead of returning the object.  If it's not null, I return the object which contains
            * the name of the recommended movie.*/
            if(rFilm.getName() == null)
                return null;

            return rFilm;
        }

        //return null;
    }

    /*Check to see if the film has already been watched.  If all films have been watched, we will
    * return null.  If not, we will return the best film to recommend to them.*/
    private String getRecommendedFilm(Person person, Map<Film, Rating> rRatings){
        for(Film film : rRatings.keySet()){
            if(!hasBeenWatched(film, person))
                return film.getName();
        }

        return null;
    }

    /*Check to see if the persons film ratings match any film ratings in the reviewer list.  If they
    * do, we multiply those together and add them to the score.  Scores values are gotten from the
    * enumerated Rating object.*/
    private int compareLists(Map<Film, Rating> pRatings, Map<Film, Rating> rRatings){
        int score = 0;

        for(Film film : pRatings.keySet()){
            if(rRatings.containsKey(film)) {
                score += pRatings.get(film).getValue() * rRatings.get(film).getValue();
            }
        }

        return score;
    }

    /*This gets the ratings of the person that we are going to recommend a film to.  We store all of
    * this users ratings into a hashMap.  We can then use this list to go through other peoples ratings
    * lists to see if they have watched the same films or not.  If they have, we can then use the
    * value(rating) of the map and do our calculations to find the correct move to recommend.*/
    private Map<Film, Rating> getSpecifiedPersonsRatings(Person person){
        return this.ratingRegister.getPersonalRatings(person);
    }

    private List<Film> sortFilms(){
        /*Get all the films and their ratings and store them in a map*/
        Map<Film, List<Rating>> filmRatings = this.ratingRegister.filmRatings();

        /*Get all film titles from the map and store them in a list*/
        List<Film> films = new ArrayList<Film>(filmRatings.keySet());

        /*Sort the films by ratings*/
        Collections.sort(films, new FilmComparator(filmRatings));

        return films;
    }

    /*Checks to see if the film exists in the users ratings.  Return true if found and
    false if not found*/
    private boolean hasBeenWatched(Film film, Person person){
            if(this.ratingRegister.getPersonalRatings(person).containsKey(film))
                return true;

        return false;
    }
}
