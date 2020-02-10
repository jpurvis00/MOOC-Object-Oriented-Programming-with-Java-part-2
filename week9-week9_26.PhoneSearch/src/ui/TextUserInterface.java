package ui;

import phonebook.Address;
import phonebook.PhoneNumber;

import java.util.*;


public class TextUserInterface {
    //Object attributes/instance vars
    private Scanner reader;
    private Map<PhoneNumber, Address> finalPhoneBook;

    //Object constructors
    public TextUserInterface(){
        this.reader = new Scanner(System.in);
        this.finalPhoneBook = new HashMap<PhoneNumber, Address>();
    }

    //Object methods
    public void startUI(){
        //System.out.println("started");
        menu();
        getUserInput();
    }

    /*Prints out the text menu for the user displaying what they can do*/
    private void menu(){
        System.out.println("phone search\navailable operations:");
        System.out.println("1 add a number");
        System.out.println("2 search for a number");
        System.out.println("3 search for a person by phone number");
        System.out.println("4 add an address");
        System.out.println("5 search for personal information");
        System.out.println("6 delete personal information");
        System.out.println("7 filtered listing");
        System.out.println("x quit");
    }

    /*Creates a while loop to get user input until the user is finished adding/searching data*/
    private void getUserInput(){
        String choice = "";

        while(!choice.equals("x")){
            System.out.println("");
            System.out.print("command: ");
            choice = reader.nextLine();

            /*Received an error on submit for using string with switch, using if/else to get past
            class submission.
             */
            /*switch(choice){
                case "1":
                    addNumber();
                    break;
                case "2":
                    searchNumber();
                    break;
            }*/
            if(choice.equals("1"))
                addNumber();
            else if(choice.equals("2"))
                searchByPerson();
            else if(choice.equals("3"))
                searchByNumber();
            else if(choice.equals("4"))
                addAddress();
            else if(choice.equals("5"))
                searchForPersonalInfo();
            else if(choice.equals("6"))
                deletePersonalInfo();
            else if(choice.equals("7"))
                filteredListing();
        }
    }

    /*Searches through the phone book for the keyword that has been specified.  The keyword can
    match a value in the persons name or address.  We originally stored all our info in a hashMap
    which is unsorted.  I take that hashMap and stick it in a TreeMap wich is sorted.  The treeMap
    must use the compareTo method from the Comparable interface.  We have implemented that interface
    in our PhoneNumber class so that they keys are sorted alphabetically by name.
    */
    private void filteredListing(){
        /*Sticks our hashMap into a TreeMap which sorts the keys by name*/
        Map<PhoneNumber, Address> treeMap = new TreeMap<PhoneNumber, Address>(this.finalPhoneBook);
        String keyWord = getUsrInput("keyword (if empty, all listed): ");
        boolean found = false;
        boolean addressUnknown = false;

        /*No keyword specified.  Return entire phonebook in alphabetical order*/
        if(keyWord.equals("")) {
            for(PhoneNumber entry : treeMap.keySet()) {
                printAllPhonebook(treeMap, entry, addressUnknown);
            }

            return;
        }

        /*Look through keys(person object) for a match*/
        for(PhoneNumber entry : treeMap.keySet()){
            if(entry.getName().contains(keyWord)) {
                /*If either the street or city are null, set addressUnknown to true*/
                if(treeMap.get(entry).getCity() == null && treeMap.get(entry).getStreet() == null) {
                    addressUnknown = true;
                }

                printAllPhonebook(treeMap, entry, addressUnknown);
                found = true;
            }
            /*Reset to false so all entrys are not displayes as "unknown address"*/
            addressUnknown = false;
        }

        /*keyword was not found in keys, look through values(address object) for a match*/
        if(!found){
            for(PhoneNumber entry : treeMap.keySet()) {
                /*Street and city have values*/
                if(treeMap.get(entry).getCity() != null && treeMap.get(entry).getStreet() != null) {
                    /*Check to see if street or city contain the keyword. If so, print out person*/
                    if(treeMap.get(entry).getStreet().contains(keyWord) || treeMap.get(entry).getCity().contains(keyWord)) {
                        printAllPhonebook(treeMap, entry, addressUnknown);
                        found = true;
                    }
                }
            }
        }

        /*No matches found for the keyword*/
        if(!found)
            System.out.println(" keyword not found");
    }

    /*Prints a person information*/
    private void printAllPhonebook(Map treeMap, PhoneNumber entry, boolean addressUnknown){
        System.out.println("");
        System.out.println(" " + entry.getName());
        if(addressUnknown)
            System.out.println(" address unknown");
        else
            System.out.println(" " + treeMap.get(entry));
        printNumbers(entry);
    }

    /*Removes the specified user from the hashMap*/
    private void deletePersonalInfo(){
        String name = getUsrInput("whose information: ");

        /*Go through all keys in the hashMap*/
        for(PhoneNumber entry : this.finalPhoneBook.keySet()) {
            if (entry.getName().equals(name)) {
                this.finalPhoneBook.remove(entry);
                /*I need to include a break statement to get us out of the for loop if we delete a person
                from the phonebook.  If I don't do this, I get a concurrentModicficationException meaning
                that I tried to delete something that we are currently iterating on.
                 */
                break;
            }
        }
    }

    /*Searches through the phone book for the specified persons name.  When found, prints out the
    persons address and all of their phone #'s.
     */
    private void searchForPersonalInfo(){
        String name = getUsrInput("whose information: ");
        boolean found = false;

        /*Go through all keys in the hashMap*/
        for(PhoneNumber entry : this.finalPhoneBook.keySet()) {
            if(entry.getName().equals(name)) {
                /*prints out the persons address if it's not null*/
                if(this.finalPhoneBook.get(entry).getStreet() != null)
                    System.out.println("  " + this.finalPhoneBook.get(entry));
                else
                    System.out.println("  address unknown");

                /*Prints persons phone #'s*/
                printNumbers(entry);
                found = true;
            }
        }

        if(!found)
            System.out.println("  not found");
    }

    //what if the person does not exist yet?
    private void addAddress(){
        String name = getUsrInput("whose address: ");
        String street = getUsrInput("street: ");
        String city = getUsrInput("city: ");
        boolean found = false;

        /*Go through all keys in the hashMap*/
        for(PhoneNumber entry : this.finalPhoneBook.keySet()) {
            if (entry.getName().equals(name)) {
                this.finalPhoneBook.get(entry).setStreet(street);
                this.finalPhoneBook.get(entry).setCity(city);
                found = true;
            }
        }

        /*User has decided to add the address for the person before adding a #.  Put new
        entry into the hashMap.
         */
        if(!found){
            this.finalPhoneBook.put(new PhoneNumber(name), new Address(street, city));
        }
    }

    /*Prompts the user for a phone number.  We then search all records for that # and display
    the name associated with that #.
     */
    private void searchByNumber(){
        System.out.print("number: ");
        String number = this.reader.nextLine();
        boolean found = false;

        /*Go through all keys in the hashMap*/
        for(PhoneNumber entry : this.finalPhoneBook.keySet()){
            /*Store all #'s in a set.*/
            Set<String> numbers = entry.getPhoneNumbers();

            /*Check each # in the set to see if it matches the user inputted #.  If they match,
            return the person's name.
             */
            for(String numb : numbers){
                if(numb.equals(number)) {
                    System.out.println(" " + entry.getName());
                    found = true;
                }
            }
        }

        if(!found)
            System.out.println(" not found");
    }

    /*Prompts the user for a person to search for their phone #.  If found, print out their
    #'s.  If not found, print " not found".
     */
    private void searchByPerson(){
        String name = getUsrInput("number: ");
        boolean found = false;

        /*Go through all keys in the hashMap*/
        for(PhoneNumber entry : this.finalPhoneBook.keySet()) {
            /*Match the key objects name to the user inputted name.  If equal, print #'s*/
            if(entry.getName().equals(name)){
                printNumbers(entry);
                found = true;
            }
        }

        if(!found)
            System.out.println(" not found");
    }

    /*Prints the phone #'s from the PhoneNumber object, 1 # per line*/
    private void printNumbers(PhoneNumber entry){
        /*Get all phone #'s and put them in a set*/
        Set<String> numbers = entry.getPhoneNumbers();

        /*Print out each # in the set if the set is > 0*/
        if(numbers.size() == 0){
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (String number : numbers) {
                System.out.println(" " + number);
            }
        }
    }

    /*Prompts the user for a name and number to add to the phone book hashMap.  We use a hashMap
    here bc it only allows unique keys.  Since we are storing objects as keys, we have created
    overriding methods equals and hashCode in the PhoneNumber class.  This lets the hashMap put method
    compare the objects by name and not add duplicate names.  If the same name is found, we add the new
    phone number to the PhoneNumber object which stores all #'s in a hashSet.
     */
    private void addNumber(){
        String name = getUsrInput("whose number: ");
        String number = getUsrInput("number: ");
        boolean found = false;

        /*Checks each key PhoneNumber object to see if the name is equal to the name the user
        just inputted.  If they are equal, add the new # to the PhoneNumber objects hashSet.
         */
        for(PhoneNumber entry : this.finalPhoneBook.keySet()){
            if(entry.getName().equals(name)) {
                entry.setPhoneNumbers(number);
                found = true;
            }
        }

        /*New user does not exist, create a new object and store in the hashMap*/
        if(!found)
            this.finalPhoneBook.put(new PhoneNumber(name, number), new Address());
    }

    /*I can redo all these into 1 method....pass the words in as a string like i did for just 1 word*/
    /*Prompts the user for a name and returns it as a string*/
    private String getUsrInput(String prompt){
        System.out.print(prompt);
        return reader.nextLine();
    }
}
