package given;

import java.util.NoSuchElementException;

public class Queue {
	
	private int first;
	private int last;
	private String[] mainMemoryArray;
	private int[] locationInMainMemory;
	
	
	public Queue (int mainMemorySize,int secondaryMemorySize) {
		first = 0;
		last = 0;
		mainMemoryArray = new String[mainMemorySize];
		locationInMainMemory = new int[secondaryMemorySize];
		for (int x : locationInMainMemory) {
			locationInMainMemory[x] = -1;
		}
	}
	
	public boolean isEmpty() { 
		return first == last;
		
	}
	
    
    public String enqueue(String element, int mainMemorySize, int index, boolean toWrite , char c) {
    	if (isEmpty()) {
    		mainMemoryArray[0] = element;
    	}
    	if (isFull(mainMemorySize)) {
    		String elementToDequeue = mainMemoryArray[first];	
    		dequeue (elementToDequeue, index);
    		mainMemoryArray[first] = element;
    		if (first == mainMemorySize) {
    			last =  mainMemorySize;
    			first = 0;
    		}
    		if (last == mainMemorySize) {
    			last = 0;
    			first = first + 1;
    		}
    		else {
    			last = last +1;
    			first = first + 1;
    		}
    		locationInMainMemory[index] = last;
    	}
    	if (!isFull(mainMemorySize)) {
    		mainMemoryArray[last + 1] = element;
    	}
    	if (toWrite) {
    		element = element + c;
    	}
    	
    	return element;
    		
    }

    public String dequeue(String element, int index) {
        if(isEmpty()) 
        	throw new NoSuchElementException();
        locationInMainMemory[first] = -1;
        return element;
    } 
    
    
    public boolean isFull (int mainMemorySize) {
    	int counter = 0;
    	for (int x : locationInMainMemory) {
			if ( x != -1) {
				counter = counter + 1;
			}
		}
    	return (counter == mainMemorySize);
    }
    //Returns the top element without removing it.
   

}
