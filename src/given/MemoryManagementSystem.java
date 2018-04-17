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
	private int ramSize;
	private int hardriveSize;
	// private int[] locationInMainMemory;

	// natai
	private Node[] memoryPointer;// this is size M
	private List mainMemory; // this is size N* pagesize
	// bar
	private Queue mainMemoryAsQueue;

	public MemoryManagementSystem(int mainMemorySize, int secondaryMemorySize, boolean useLRU) {
		secondaryMemory = new String[secondaryMemorySize];
		for (int i = 0; i < secondaryMemorySize; i++)
			secondaryMemory[i] = "";
		ramSize = mainMemorySize;
		hardriveSize = secondaryMemorySize;
		this.useLRU = useLRU;
		if (useLRU) {
			MemoryManagementSystemLRU();
		} else {
			MemoryManagementSystemFifo();
		}
	}

	private void MemoryManagementSystemLRU() {
		memoryPointer = new Node[hardriveSize];
		mainMemory = new List(ramSize);// need to loud items 1 - n
		for (int i = 0; i <= ramSize; i++) {
			findNodeLRU(i); // load 1 - n and add them to list // the function findnode also load it up to
							// the list
		}
	}

	private void MemoryManagementSystemFifo() {
		mainMemoryAsQueue = new Queue(ramSize, hardriveSize);
		for (int i = 0; i < ramSize; i++) {
			findPageFifo(i); // load 1 - n and add them to list 
		}
	}

	public String read(int index) {

		if (useLRU) {
			return readLRU(index);
		} else {
			return readFIFO(index);
		}
	}

	private String readLRU(int index) {
		Node temp = findNodeLRU(index);
		return temp.getData().read();
	}
	// use findPageFifo to check where the page we want (main memory of secondary memory) and returns it.
	private String readFIFO(int index) {
		Page page = findPageFifo(index);
		return page.read();
	}

	public void write(int index, char c) {

		if (useLRU) {
			writeLRU(index, c);
		} else {
			writeFIFO(index, c);
		}
	}

	private void writeLRU(int index, char c) {
		Node temp = findNodeLRU(index);
		temp.getData().write(c);
	}
// use findPageFifo to check where the page we want (main memory of secondary memory) and adds char to it.
	private void writeFIFO(int index, char c) {
		Page page = findPageFifo(index);
		page.write(c);
	}

	private Page findPageFifo(int index) {
		Page page;
		if (mainMemoryAsQueue.getLocationInMainMemory(index) == -1) { // if not already in main memory
			page = new Page(readFromSecondaryMemory(index), index); // create new page and save its info
			if (mainMemoryAsQueue.isFull()) {// if full
				Page temp = mainMemoryAsQueue.enqueue(page);// enqueue returns us the page we dequeue
					moveToSecondaryMemory(temp); // returns the updated page to his place in secondary memory
			} else {// if not full
				mainMemoryAsQueue.enqueue(page);// if main memory still got place to add, we only add the page
			}
		} else { // if in the main memory 
			page = mainMemoryAsQueue.getPageInmainMemoryArray(index);
		}

		return page;
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
		mainMemory.moveToLast(temp);
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
