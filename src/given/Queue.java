package given;

import java.util.NoSuchElementException;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Queue {

	private int first;
	private int last;
	private Page[] mainMemoryArray;// size n
	private int[] locationInMainMemory;// size m , at first all "-1", when we add a page, from index in the secondery memory, to main memory we save the in the same index in this array the index we put the page in the main memory array.
	private int currentsize;//counter to help us know if the main memory if empty or full. 

	public int getLocationInMainMemory(int index) {
		return locationInMainMemory[index];
	}

	public Queue(int mainMemorySize, int secondaryMemorySize) {
		first = 0;
		last = 0;
		currentsize = 0;
		mainMemoryArray = new Page[mainMemorySize];
		locationInMainMemory = new int[secondaryMemorySize];
		for (int i = 0; i < secondaryMemorySize; i = i + 1) {
			locationInMainMemory[i] = -1;
		}
	}

	public boolean isEmpty() {
		return (currentsize == 0);

	}
// index is from secondary memory
	public Page getPageInmainMemoryArray(int index) {
		int realIndex = getLocationInMainMemory(index);
		return mainMemoryArray[realIndex];
	}

	// index is from secondary memory
	// we use "last" and "first" to say who is the first one we placed in the main memory array, and the same with the last.
	// because it's a queue with a fixed size we first full the array and only when it's full we will use the dequeue function.
	// we replace the first page with the new one, witch now will be the last. and the first will be the next one we placed in the array after the one we deleted.
	public Page enqueue(Page page) {
		if (isEmpty()) {
			mainMemoryArray[last] = page;
			locationInMainMemory[page.getHome()] = last;
			currentsize++;
			return null;
		}

		if (!isFull() & !isEmpty()) {
			last = (last + 1) % mainMemoryArray.length;
			mainMemoryArray[last] = page;
			locationInMainMemory[page.getHome()] = last;
			currentsize++;
			return null;
		}

		Page elementToDequeue = mainMemoryArray[first];
		dequeue(elementToDequeue);

		first = (first + 1) % mainMemoryArray.length;
		last = (last + 1) % mainMemoryArray.length;
		mainMemoryArray[last] = page;
		currentsize++;
		locationInMainMemory[page.getHome()] = last;

		return elementToDequeue;

	}

	public Page dequeue(Page element) {
		if (isEmpty())
			throw new NoSuchElementException();
		locationInMainMemory[element.getHome()] = -1;// when we dequeue page we update it's status in the array that tell us where each page is in the main array to "-1" = not there. 
		currentsize--;
		return element;
	}

	public boolean isFull() {

		return (currentsize == mainMemoryArray.length);
	}

}
