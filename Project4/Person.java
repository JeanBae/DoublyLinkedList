/**
 * This is the Person class that implements the comparable interface
 * @author Kyle Jackson
 * @author Jean Bae
 */
public class Person implements Comparable <Person>{

    private String firstName, lastName, DOB;
    private int ID;
    
    /**
     * This is the compareTo method that takes the parameter and compares this ID to person 2's ID
     */
    @Override
	public int compareTo(Person person2) {
	return Integer.compare(this.ID, person2.getID());
    }
    /**
     * This is the toString method that takes first name, last name, and date of birth and puts it into a string
     */
    public String toString(){
	String stringID = String.format("%04d", this.ID);
	String str = stringID + " " + this.firstName + " " + this.lastName + " " +  this.DOB;
	return str;
    }
    /**
     * This is a method to get the first name
     * @return first name of Person
     */
    protected String getFirstName(){
	return firstName;
    }
    /**
     * This is a method to get the last name of a person
     * @return last name of Person
     */
    protected String getLastName(){
	return lastName;
    }
    /**
     * This is a method to get the Date of birth of a person
     * @return DOB of the person
     */
    protected String getDOB(){
	return DOB;
    }
    /**
     * This is a method to get the ID of a person
     * @return ID of the person
     */
    protected int getID(){
	return ID;
    }
    /**
     * This method sets the first name of the person
     * @param firstName of the person is set to the first name passed in the parameter
     */
    protected void setFirstName(String firstName){
	this.firstName = firstName;
    }
    /**
     * This is the setter method for the last name of a person
     * @param lastName is passed through the parameter to set to this last name
     */
    protected void setLastName(String lastName){
	this.lastName = lastName;
    }
    /**
     * This is the setter method for the date of birth of a person
     * @param DOB is passed through the parameter to set to this date of birth
     */
    protected void setdOB(String DOB){
	this.DOB = DOB;
    }
    /**
     * This is the setter method for the ID for a person
     * @param ID is passed through the parameter to set to this ID
     */
    protected void setID(int ID){
	this.ID = ID;
    }
    /**
     * This is the equals method that returns true if Person equals object and false if otherwise
     */
    @Override
	public boolean equals(Object o){
	if(compareTo((Person) o) == 0) return true;
	return false;
    }
}