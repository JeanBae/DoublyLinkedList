/**
 * This is the Student class that is a subclass of Person.
 * @author Kyle Jackson
 * @author Jean Bae
 */
public class Student extends Person{

    private String collegeName;
    
    public String toString(){
	String str = super.toString() + " " + "[" + this.collegeName + "]";
	return str;
    }
    
    protected String getCollegeName(){
	return collegeName;
    }
    
    protected void setCollegeName(String collegeName){
	this.collegeName = collegeName;
    }
}
