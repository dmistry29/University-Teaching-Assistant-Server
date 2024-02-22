package taPayrollManagerSystem;

//This class creates a list that will store objects of any type. Behind this list
//we will use arrays to actually store our elements. The methods in this class
//will make it convenient for a user to add, resize and check the size of our list
public class LarryList {
	
	
	private Object[] list; 
	private int count; 
	private int capacity;
	
	//This initial constructor will create a LarryList object that has an array
	//with size capacity, and the count variable will be used to keep track of
	//the index for any new element to be added.
    public LarryList(int capacity) {
    	
    	count = 0;
    	
    	if (capacity <= 0) {
        	list = new Object[1];
        	this.capacity = 1;
        }
    	
    	else {
    		list = new Object[capacity];
    		this.capacity = capacity;
    	}
    
    }
    
    //If a valid element is provided and the array of TAs isn't full, this 
    //method will add the object newElement, provided in the parameter, to our
    //LarryList array and increment count by 1 for the next element. If the
    //array is full, then the resize method will be used to double the size of
    //the array and the newElement object will be added afterwards.
    public boolean add(Object newElement) {
    	
    	if (newElement != null) {
    	
    		if (count != capacity) {
    			list[count] = newElement;
    			count++;
    			return true;
    		}
    	
    	}
    	
    	return false;
    }
    
    //If a valid element is provided and the position for to add is position not
    //taken by a current element in the array, then this method will add the
    //newElt object to the pos index in our LarryList array. 
    public boolean set(int pos, Object newElt) {
    	
    	if (newElt == null || pos > count) {
    		return false;
    	}
    	
    	list[pos] = newElt;
    	
    	return true;
    }
    
    //This method returns the current capacity, aka the size, of our
    //LarryList array.
    public int getCurrCapacityAmt() {
        return capacity;
    }
    
    //This method checks if our count field is the same as the capacity field.
    //If yes, that would indicate that our LarryList array is full.
    public boolean isFull() {
    	
    	if (count == capacity) {
        	return true;
        }
        
    	return false;
    }
    
    //This method subtracts the count field from the capacity field, which 
    //would return the total number of spaces still empty in our LarryList
    //array.
    public int numCanBeAdded() {
        return capacity - count;
    }
    
    //If the provided pos parameter is valid, that is if it is smaller than
    //the count field, the method will return a reference of the object that
    //is present at the pos index in our LarryList array. 
    public Object get(int pos) {
    	
    	if (pos > count) {
    		return null;
    	}   	
    	
    	return list[pos];
    }

    //As briefly described in the add() method above, when this method is
    //called, our LarryList array's size will be doubled. A new array of
    //double the size of that of the old array will be created, all the
    //elements of the old array will be copied and this new array will now
    //be assigned to the list variable. 
    public void resize() {
        
    	capacity *= 2;
    	Object[] newList = new Object[capacity];
        
    	for (int i = 0; i < count; i++) {
        	newList[i] = list[i];
        }
        
    	list = newList;
    }
    
    //This method iterates through our LarryList array, casts each object to
    //a TA object, and uses the checkName() method from the TA class to see if
    //the provided firstName and lastName in the parameter match the firstName
    //and lastName of the current TA. If yes, that TA object is returned, 
    //otherwise null is returned.
    public TA findName (String firstName, String lastName) {
    	
    	TA temp = null;
    	
    	for(int i = 0; i < count; i++) {
    	
    		temp = (TA)this.get(i);
    		
    		if (temp.checkName(firstName, lastName)) {
    			return temp;
   			}
    	
    	}
    	
    	return null;
    }

}
