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

    public MemoryManagementSystem(int mainMemorySize, int secondaryMemorySize, boolean useLRU) {
	// ADD YOUR CODE HERE
	secondaryMemory = new String[secondaryMemorySize];
	ram = mainMemorySize;
	hardrive = secondaryMemorySize;
	this.useLRU = useLRU;
	if (useLRU) {
	    MemoryManagementSystemLRU();
	} else {
	}
    }

    private void MemoryManagementSystemLRU() {
	memoryPointer = new Node[hardrive];
	mainMemory = new List();
    }

    @Override
    public String toString() {
	return "secondaryMemory=" + Arrays.toString(secondaryMemory);
    }

    public String read(int index) {
	// ADD YOUR CODE HERE
	return null;
    }

    public void write(int index, char c) {
	// ADD YOUR CODE HERE
    }
}
