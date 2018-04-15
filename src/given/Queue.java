package given;

import java.util.NoSuchElementException;

public class Queue {
	
	private int first;
	private int last;
	private Page[] mainMemoryArray;
	private int[] locationInMainMemory;
	
	
	public int getLocationInMainMemory(int index) {
		return locationInMainMemory[index];
	}

	public void setLocationInMainMemory(int index, int value) {
		locationInMainMemory[index] = value;
	}

	public Queue (int mainMemorySize,int secondaryMemorySize) {
		first = 0;
		last = 0;
		mainMemoryArray = new Page[mainMemorySize];
		locationInMainMemory = new int[secondaryMemorySize];
		for (int x : locationInMainMemory) {
			locationInMainMemory[x] = -1;
		}
	}
	
	public boolean isEmpty() { 
		return first == last;
		
	}
	
    
    public Page enqueue(Page page, int mainMemorySize, int index, boolean toWrite , char c) {
    	if (isEmpty()) {
    		mainMemoryArray[0] = page;
    	}
    	if (isFull(mainMemorySize)) {
    		Page elementToDequeue = mainMemoryArray[first];	
    		dequeue (elementToDequeue, index);
    		mainMemoryArray[first] = page;
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
    		mainMemoryArray[last + 1] = page;
    	}
    	if (toWrite) {
    		page.write(c);
    	}
    	
    	return page;
    		
    }

    public Page dequeue(Page element, int index) {
        if(isEmpty()) 
        	throw new NoSuchElementException();
        locationInMainMemory[first] = -1;
        return element;
    } 
    
    
    public boolean isFull (int mainMemorySize) {
    	return (last + 1 == first | first == 0 & last == mainMemorySize);
    }
    
    //Returns the top element without removing it.
   

}
