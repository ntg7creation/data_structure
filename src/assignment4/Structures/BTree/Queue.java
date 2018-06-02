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
			if (last != first & !isEmpty()) {
			first.getNext().setPre(null);
			first = first.getNext();
			size--;
			}
			else {
				size = 0;
				first = null;
				last = null;
			}
			return tmp;
				
		}
		
		public void enqueue (BTreeNode n) {
			if (isEmpty()) {
				first = n;	
				last = n;
				n.setPre(null);
				n.setNext(null);
			}

			else {
				n.setNext(null); // not needed
				n.setPre(last);
				last.setNext(n);
				last = last.getNext(); // last = last.getNext(); same thing

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



