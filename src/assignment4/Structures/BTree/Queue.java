package assignment4.Structures.BTree;

public class Queue{


		private BTreeNode first;
		private BTreeNode last;
		private int size;

		public Queue() {
			this.size = 0;
		}

		
		public BTreeNode dequeue() {
			BTreeNode tmp = first;
			if (last != first & !isEmpty()) { // there is more then one node in the queue, we delete the first node from the queue
			first.getNext().setPre(null);
			first = first.getNext();
			size--;
			}
			else { // there is only one node in the queue, when we delete it the queue should be empty
				size = 0;
				first = null;
				last = null;
			}
			return tmp; 
				
		}
		
		public void enqueue (BTreeNode n) {
			if (isEmpty()) { //add the first node
				first = n;	
				last = n;
				n.setPre(null);
				n.setNext(null);
			}

			else {
				n.setNext(null); // add to the end of the queue
				n.setPre(last);
				last.setNext(n);
				last = last.getNext(); 

			}
			size = size + 1; 
		}

		public BTreeNode getLast() {
			return last;
		}

		public BTreeNode getFirst() {
			return first;
		}

		public Boolean isEmpty() {
			if (size == 0)
				return true;
			return false;
		}
		
		public int getSize () {
			return size;
		}

	}



