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

    // natai
    private Node[] memoryPointer;
    private List mainMemory;
    // bar
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
	mainMemoryAsQueue = new Queue(ram, hardrive);

    }

    public String read(int index) {

	if (useLRU) {
	    return readLRU(index);
	} else {
	    return readFIFO(index);
	}
    }

    public String readLRU(int index) {

	return null;
    }

    public String readFIFO(int index) {
	String element = secondaryMemory[index];
	element = (String) mainMemoryAsQueue.enqueue(element, ram, index, false, ' ');
	return element;
    }

    public void write(int index, char c) {

	if (useLRU) {
	    writeLRU(index, c);
	} else {
	    writeFIFO(index, c);
	}
    }

    public void writeLRU(int index, char c) {

    }

    public void writeFIFO(int index, char c) {
	String element = secondaryMemory[index];
	element = mainMemoryAsQueue.enqueue(element, ram, index, true, c);
    }

    @Override
    public String toString() {
	return "secondaryMemory=" + Arrays.toString(secondaryMemory);
    }

}
