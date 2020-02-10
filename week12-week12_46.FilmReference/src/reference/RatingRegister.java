package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class RatingRegister {
    //Object attributes/instance vars
    private Film film;
    private Rating rating;
    private Map<Film, List<Rating>> filmRating;
    private Map<Person, Map<Film, Rating>> personalRatings;

    //Object constructors
    public RatingRegister(){
        this.filmRating = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    //Object methods
    /*Adds a rating to a film.  If the film is not in the rating map, create it with the key
    * being an arrayList of ratings.  Using an arrayList because we are not concerned w duplicates*/
    public void addRating(Film film, Rating rating){
        if(!this.filmRating.containsKey(film))
            this.filmRating.put(film, new ArrayList<Rating>());

        this.filmRating.get(film).add(rating);
    }

    /*Returns all ratings for the specified film in a list*/
    public List<Rating> getRatings(Film film){
        return this.filmRating.get(film);
    }

    /*Returns all keys and values in our Map*/
    public Map<Film, List<Rating>> filmRatings(){
        return this.filmRating;
    }

    /*We are creating a hashmap in the method.  The key is a person object and the value
    * is a hashmap with the key of film and a rating for the film.  Before doing any of that
    * though, we are adding the rating to the filmRating hashmap.*/
    public void addRating(Person person, Film film, Rating rating){
        addRating(film, rating);

        /*Checks to see if the person is already in the hashmap.  If not, creates a new
        * entry in the personalRatings hashMap and creates a new hashMap for the value.*/
        if(!this.personalRatings.containsKey(person))
            this.personalRatings.put(person, new HashMap<Film, Rating>());

        /*Get the entry from the existing hashmap and put the film and rating in the hashmap value.*/
        this.personalRatings.get(person).put(film, rating);
    }

    /*Returns the rating of the specified film from the specified person.  If they have not rated the
    * file, return NOT_WATCHED.*/
    public Rating getRating(Person person, Film film){
        if(this.personalRatings.get(person).containsKey(film))
            return this.personalRatings.get(person).get(film);

        return Rating.NOT_WATCHED;
    }

    /*Returns all films with their ratings that the specified person has reviewed*/
    public Map<Film, Rating> getPersonalRatings(Person person){
        if(this.personalRatings.containsKey(person))
            return this.personalRatings.get(person);

        return new HashMap<Film, Rating>();
    }

    /*Returns a list of all people who have evaluated films*/
    public List<Person> reviewers(){
        /*The assignment asks us to return a list so I believe I had to create an arrayList to store
        * the keys in.  I think I could have done this by returning a set though.  Then I would have only
        * had to do the following: return this.personalRatings.keySet().  I confirmed this.  Method is below
        * and commented out.*/
        ArrayList<Person> reviewers = new ArrayList<Person>();

        for(Person person : this.personalRatings.keySet()){
            reviewers.add(person);
        }

        return reviewers;
    }

    /*Testing my theory for the above reviewers method*/
    /*public Set<Person> allReviewers(){
        return this.personalRatings.keySet();
    }*/
}
