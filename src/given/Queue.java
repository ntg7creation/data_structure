package given;

import java.util.NoSuchElementException;

public class Queue {

	private int first;
	private int last;
	private Page[] mainMemoryArray;// size n
	private int[] locationInMainMemory;// size m
	private int currentsize;

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

	public Page getPageInmainMemoryArray(int index) {
		int realIndex = getLocationInMainMemory(index);
		return mainMemoryArray[realIndex];
	}

	// index is place in secandry memory
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
		locationInMainMemory[element.getHome()] = -1;
		currentsize--;
		return element;
	}

	public boolean isFull() {

		return (currentsize == mainMemoryArray.length);
	}

}
