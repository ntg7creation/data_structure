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
    private Node[] memoryPointer;// this is size M
    private List mainMemory; // this is size N* pagesize
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
	mainMemory = new List(ram);// need to loud items 1 - n
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
	Node temp = findNodeLRU(index);
	

    }

    public void writeFIFO(int index, char c) {
	String element = secondaryMemory[index];
	element = mainMemoryAsQueue.enqueue(element, ram, index, true, c);
    }

    private Node findNodeLRU(int index) {
	Node temp = memoryPointer[index];
	if (temp == null)// this means that we dont have it loaded on the ram
	{
	    if (mainMemory.isFull()) { // remove LRU style
		Page page = mainMemory.getAndRemoveFirst().getData();
		memoryPointer[page.getHome()] = null;
		moveToSecondaryMemory(page);
	    }

	    // creat new node (with a page) and add it to main memory
	    Page page = new Page(readFromSecondaryMemory(index), index);
	    temp = new Node(page);
	    mainMemory.addLast(temp);
	    memoryPointer[index] = temp;

	}
	return temp;
    }

    // the only 2 function the can talk with the secondaryMemory
    private void moveToSecondaryMemory(Page page) {
	secondaryMemory[page.getHome()] = page.read();
    }

    private String readFromSecondaryMemory(int index) {
	return secondaryMemory[index];
    }

    @Override
    public String toString() {
	return "secondaryMemory=" + Arrays.toString(secondaryMemory);
    }

}
