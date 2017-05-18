import java.lang.*;
import java.io.Serializable;
/**
 * This is the SortedDblList class that implements Serializable.  
 * @author Kyle Jackson
 * @author Jean Bae
 */
public class SortedDblList<T extends Comparable> implements Serializable{

    private int size = 0;
    DoublyNode<T> head = null;
    
    /**
     * This is a constructor that sets the size of this list to 0
     */
    protected SortedDblList(){
	this.size = 0;
    }
    /**
     * This is the print list method that will print the length, size, and will print the first name, last name, DOB, ID 
     * of the student
     */
    protected void printList(){
	DoublyNode<T> currentNode = head;
	System.out.println("Length: " + size + "\n");
	while(currentNode != null){
	    System.out.println(currentNode.getData().toString() + "\n");
	    currentNode = currentNode.getNext();
	}
    }
    /**
     * This is the get method for the T element, or node in this case
     * @param index
     * @return the data of the Node is returned
     */
    protected T get(int index){
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	DoublyNode<T> currentNode = head;
	for(int x = 0; x < size; x++){
	    if(x == index) return currentNode.getData();
	    currentNode = currentNode.getNext();
	}
	return null;
    }
    /**
     * This is the add method that adds a node to the list and sorts it within the list while also catching duplicates
     * @param t
     * @return true or false depending on the comparison of the previous and/or next node to sort 
     */
    protected boolean add(T t){
	if(t == null) return false;
	if(size == 0){
	    head = new DoublyNode<T>(t);
	    head.setNext(null);
	    size++;
	    return true;
	}
	DoublyNode<T> currentNode = head;
	DoublyNode<T> newNode = new DoublyNode<T>(t);
	if(t.compareTo(head.getData()) < 0){
	    newNode.setNext(head);
	    head.setPrev(newNode);
	    head = newNode;
	    size++;
	    return true;
	}
	while(currentNode != null && currentNode.getNext() != null){
	    if(t.compareTo(currentNode.getData()) == 0) return false;
	    else if(t.compareTo(currentNode.getData()) < 0){
		newNode.setNext(currentNode);
		newNode.setPrev(currentNode.getPrev());
		currentNode.getPrev().setNext(newNode);
		currentNode.setPrev(newNode);
		size++;
		return true;
	    }
	    else {
		currentNode = currentNode.getNext();
	    }
	}//END WHILE LOOP
	if(t.compareTo(currentNode.getData()) == 0) return false;
	else if(t.compareTo(currentNode.getData()) < 0){
	    newNode.setNext(currentNode);
	    newNode.setPrev(currentNode.getPrev());
	    currentNode.getPrev().setNext(newNode);
	    currentNode.setPrev(newNode);
	    size++;
	    return true;
	}
	else{
	    currentNode.setNext(newNode);
	    newNode.setPrev(currentNode);
	    newNode.setNext(null);
	    size++;
	    return true;
	}
    }//END add()
    /**
     * This method removes a node from the list
     * @param o 
     * @return true or false for whether node is removed or if the list is null
     */
    protected boolean remove(Object o){
	DoublyNode<T> currentNode = head;
	if(currentNode == null) return false;
	while(currentNode != null){
	    if(currentNode.getData().equals(o)){
		if(size == 1){
		    head = null;
		}
		else{
		    if(currentNode.getPrev() != null) currentNode.getPrev().setNext(currentNode.getNext());
		    if(currentNode.getNext() != null) currentNode.getNext().setPrev(currentNode.getPrev());
		}
		size--;
		return true;
	    }
	    currentNode = currentNode.getNext();
	}//END WHILE LOOP
	return false;
    }
    /**
     * This is the method to check if the list is empty
     * @return boolean for size is equal to 0
     */
    protected boolean isEmpty(){
	return size==0;
    }
    /**
     * This is the merge method where this list is combines with otherList to create one, sorted list without duplicates
     * @param otherList is a sorted list that is passed through
     * @return otherList as the product of the combination of both lists
     */
    public SortedDblList<T> merge(SortedDblList<? extends T> otherList){
	SortedDblList mergedList = this;
	for(int x = 0; x < otherList.size; x++){
	    mergedList.add(otherList.get(x));
	}
	return mergedList;
    }
    /**
     * This method checks for whether a list is the prefix for another list
     * @param otherList
     * @return boolean true or false for if this list is the prefix for the otherList
     */
    public boolean isPrefix (SortedDblList<? extends T> otherList){
	if(this.size == 0 || otherList.size == 0 || this.size > otherList.size) return false;
	for(int x = 0; x < this.size; x++){
	    if(this.get(x).compareTo(otherList.get(x)) == 0){
		if(x == this.size - 1) return true;
	    }
	}
	return false;
    }
    /**
     * This
     * @param o
     * @return
     */
    public int indexOf(Object o){
	DoublyNode<T> iterator = head;
	int x = 0;
	while(iterator != null){
	    if(this.get(x).equals(o)){
		return x;
	    }
	    x++;
	    iterator = iterator.getNext();
	}
	return -1;
    }
}