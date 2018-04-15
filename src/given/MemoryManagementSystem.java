package given;

/**
 * 
 * @author natai & 208768150

 * @author bar & 205817521
 */
import java.util.Arrays;


public class MemoryManagementSystem {
    public String[] secondaryMemory;
    private boolean useLRU;
    // YOU CAN ADD MORE FIELDS HERE
    private int ram;
    private int hardrive;
    private Node[] memoryPointer;
    private List mainMemory;
    private Queue mainMemoryAsQueue;
    
    

    public MemoryManagementSystem(int mainMemorySize, int secondaryMemorySize, boolean useLRU) {
	secondaryMemory = new String[secondaryMemorySize];
	ram = mainMemorySize;
	hardrive = secondaryMemorySize;
	this.useLRU = useLRU;
	if (useLRU) {
	    MemoryManagementSystemLRU();
	} else {
		MemoryManagementSystemFifo();
	}
    }

    private void MemoryManagementSystemLRU() {
	memoryPointer = new Node[hardrive];
	mainMemory = new List();
    }
    
    private void MemoryManagementSystemFifo() {
    	mainMemoryAsQueue = new Queue ( ram ,hardrive );
    	
    }

    

    @Override
    public String toString() {
	return "secondaryMemory=" + Arrays.toString(secondaryMemory);
    }

    public String read(int index) {
    	String element = secondaryMemory[index];
    	if (useLRU) {
    		
    	}
    	else {
    		element = (String) mainMemoryAsQueue.enqueue(element, ram, index , false , ' ');
    	}
	return element;
    }

    public void write(int index, char c) {
    	String element = secondaryMemory[index];
    	if (useLRU) {
    		
    	}
    	else {
    		element = mainMemoryAsQueue.enqueue(element, ram, index , true , c);
    	}
    }
}
