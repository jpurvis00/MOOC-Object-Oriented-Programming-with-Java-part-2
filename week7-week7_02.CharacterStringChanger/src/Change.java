public class Change {
    //Object attributes/vars
    private char fromChar;
    private char toChar;

    //Object constructors
    public Change(char fromCharacter, char toCharacter){
        this.fromChar = fromCharacter;
        this.toChar = toCharacter;
    }

    //Object methods
    //Replaces all fromChar with tochar and returns the new string.
    public String change(String characterString){
        //I originally used replaceAll.  That is prob overkill and the replace method works better since I
        //don't have to convert chars to strings.
        //return characterString.replaceAll(Character.toString(this.fromChar), Character.toString(this.toChar));
        return characterString.replace(this.fromChar, this.toChar);
    }
}
