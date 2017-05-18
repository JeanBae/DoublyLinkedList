import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {

    public static void main(String[] args) {
	
	//creating person objects and setting first and last name, DOB, and ID
	Person person  = new Person();
	person.setFirstName("Kyle");
	person.setLastName("Jackson");
	person.setdOB("06-22-89");
	person.setID(1000);
	
	Person person2 = new Person();
	person2.setFirstName("Vicki");
	person2.setLastName("Phath");
	person2.setdOB("11/20/87");
	person2.setID(1600);
	
	Person person3 = new Person();
	person3.setFirstName("Holly");
	person3.setLastName("Williams");
	person3.setdOB("02-16-84");
	person3.setID(1025);
	
	Person person4  = new Person();
	person4.setFirstName("Bad");
	person4.setLastName("Grandpa");
	person4.setdOB("06-02-51");
	person4.setID(1000);
	
	Person person5 = new Person();
	person5.setFirstName("The");
	person5.setLastName("Grinch");
	person5.setdOB("01/20/20");
	person5.setID(1025);
	System.out.println("Testing Person class methods.  Below is a list of all person objects: ");
	System.out.println(person + "\n" + person2 + "\n" + person3 + "\n" + person4 + "\n" + person5 + "\n");
	
	//creating student objects and setting first and last name, DOB, and ID
	Student student2 = new Student();
	student2.setFirstName("Gary");
	student2.setLastName("Jackson");
	student2.setdOB("11-23-61");
	student2.setCollegeName("UCLA");
	student2.setID(1050);
	
	Student student3 = new Student();
	student3.setFirstName("Jean");
	student3.setLastName("Bae");
	student3.setdOB("05-28-88");
	student3.setCollegeName("Franklin");
	student3.setID(1300);
	
	//creating list of type person called personList
	SortedDblList<Person> personList = new SortedDblList<>();
	
	//testing isEmpty method on list(should be true)
	System.out.println("Below is testing isEmpty() for personList.  Expected result is true: ");
	System.out.println(personList.isEmpty());
	
	//adding persons to personList
	personList.add(person);
	personList.add(person3);
	personList.add(person2);
	
	//testing isEmpty method on list (should be false)
	System.out.println("Below is testing isEmpty() for personList.  Expected result is false: ");

	System.out.println(personList.isEmpty() + "\n");
	
	//creating studentList of type student
	SortedDblList<Student> studentList = new SortedDblList<>();
	
	//adding students to studentList
	studentList.add(student2);
	studentList.add(student3);
	
	//testing printList for studentList
	System.out.println("Below is the printList test for studentList: ");
	studentList.printList();
	
	//creating list of type person called personList
	SortedDblList<Person> personList2 = new SortedDblList<>();
	
	//adding persons to personList2
	personList2.add(person4);
	personList2.add(person5);

	//testing isPrefix, should return false
	System.out.println("Below is testing if personList is a prefix of studentList.  Expected result is false: ");
	System.out.println(personList.isPrefix(studentList) + "\n");
	
	//testing isPrefix, should return true
	System.out.println("Below is testing if personList2 is a prefix of personList.  Expected result is true: ");
	System.out.println(personList2.isPrefix(personList) + "\n");
	
	//testing get method should print "1000 Kyle Jackson 06-22-89"
	System.out.println("Testing get method.  Expected result below: 1000 Kyle Jackson 06-22-89");
	System.out.println(personList.get(0) + "\n");
	
	//test get method should print "1050 Gary Jackson 11-23-61 UCLA"
	System.out.println("Testing get method.  Expected result below: 1050 Gary Jackson 11-23-61 UCLA");
	System.out.println(studentList.get(0) + "\n");
	
	//testing indexOf, should return 0
	System.out.println("Testing indexOf() on personList.  Expected result is 0: ");
	System.out.println(personList.indexOf(person));
	
	//testing indexOf, should return 2
	System.out.println("Testing indexOf() on personList.  Expected result is 2: ");
	System.out.println(personList.indexOf(person2) + "\n");
	
	//testing merge, should be a combined list of personList and studentList
	System.out.println("Testing merge().  Adding studentList to personList: ");
	personList.merge(studentList);
	personList.printList();
	
	//list2.printList();
	
	/*trying to serialize and deserialize a file, and catching IO exceptions when attempting to write a file
	 * and catching an exception when reading a file
	 */
	try{
	    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("MyList.ser"));
	    out.writeObject(personList);
	    out.close();
	}
	catch(IOException e){
	}
	
	try{
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("MyList.ser"));
	    in.readObject();
	    in.close();
	}
	catch(Exception e){
	}
	
	//testing the remove method
	System.out.println("Testing remove().  Removing person3(1025) from personList: ");
	personList.remove(person3);
	personList.printList();
	System.out.println("Testing remove().  Removing student3(1300) from studentList: ");
	studentList.remove(student3);
	studentList.printList();
    }
}
