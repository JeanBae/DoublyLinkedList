/**
 * This is the DoublyNode class that uses getters and setters to access data inside a node
 * @author Kyle Jackson
 * @author Jean Bae
 */

public class DoublyNode<T> {

    private T data;
    private DoublyNode prev;
    private DoublyNode next;
    
    /**
     * Creates a node using the data parameter
     * @param data element is used to be added to the node 
     */
    
    public DoublyNode(T data){
	this.data = data;
	this.prev = prev;
	this.next = next;
    }
    
    /**
     * Returns the data from the node
     * @return data from the node
     */
    protected T getData(){
	return data;
    }
    /**
     * This is a setter method to set data for a node
     * @param data is element set for the node
     */
    protected void setData(T data){
	this.data = data;
    }
    /**
     * This method is getting the next node
     * @return next node
     */
    protected DoublyNode<T> getNext(){
	return next;
    }
    /**
     * This method is setting the next node
     * @param node is generic element 
     */
    protected void setNext(DoublyNode<T> node){
	this.next = node;
    }
    /**
     * This method is getting the previous node
     * @return prev which is returning the node before the current node
     */
    protected DoublyNode<T> getPrev(){
	return prev;
    }
    protected void setPrev(DoublyNode<T> node){
	this.prev = node;
    }
}