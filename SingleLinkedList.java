
public class SingleLinkedList {

	Node head;
	int size;
	
	public SingleLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public Boolean checkEmpty() {
		if (size > 0)
			return false;
		return true;
	}
	
	//get head value
	public int getHeadValue() {
		if(this.checkEmpty()) {
			//create new null head node
			Node newHead = new Node(404);
			head = newHead;
			return newHead.getValue();
		} else {
		return head.getValue();
		}
	}
	
	//create new head
	public void addNewHead(int value) {
		if(this.checkEmpty()) {
			Node newHead = new Node(value);
			head = newHead;
			size++;
		} else {
		Node newHead = new Node(value);
		Node currentHead = head;
		newHead.setNext(currentHead);
		head = newHead;
		size++;
		}
	}

	//delete head
	public void deleteHead() {
		if(this.checkEmpty()) {
			System.out.println("No existing node.");
		} else {
		Node currentHead = this.head;
		Node nextHead = currentHead.getNext();
		head = nextHead;
		currentHead.setNext(null);
		size--;
		}
	}
	
	// Recursive
	private Node getLastNode(Node n) {
		// Base condtion
		if(n.getNext() == null){
			return n;
		}
		// Recursion
		return getLastNode(n.getNext());
	}

	//add tail
	public void addNewTail(int value) {
		Node currentTail = getLastNode(this.head);
		Node newTail = new Node(value);
		currentTail.setNext(newTail);
		size++;
	}

	//delete tail
	public void deleteTail() {
		Node temp = head;
		while (temp.getNext() != getLastNode(head))
			temp = temp.getNext();
		Node tail = temp;
		tail.setNext(null);
		size--;
	}
   
	//create new node at end of link
	public void put(int i) {
		Node n = new Node(i);
		// 1. LinkedList is empty
		if(head == null) {
			head = n;
			size++;
		}
		// 2. LinkedList is not empty
		else {
			getLastNode(head).setNext(n);
			this.size++;
		}
	}
	
	//find the node value
	public int get(int index) {
		Node n = head;
		for(int i=0; i < index; i++)
			n = n.getNext();
		return n.getValue();
	}

	//find the node via its index
	public Node getNode(int inputIndex) {
		Node n = head; //useless
		for (n = head; n.getNext() != null; n = n.getNext()) {
			if (findIndex(n) == inputIndex) return n;
		}return n; //useless
	}

	//find the node index
	public int findIndex(Node nodey) {
		int num = 0;
		for (Node n = head; n.getNext() != nodey.getNext(); n = n.getNext()) {
			num++;
		}return num;
	}

	// Remove at given index
	public void remove(int index) {
		if (index < 0 || index > findSize()) {
			throw new IllegalArgumentException("Index out of bound.");
		}else if (index == 0) {
			head = head.getNext();
			size--;
		}else {
			Node p = getNode(index - 1);
			Node c = p.getNext();//kill target
			Node n = c.getNext();

			p.setNext(n);
			c.setNext(null);
			size--;
		}
	}

	//get list size
	public int findSize() {
		if (!this.checkEmpty()) {
			int num = 1;
			for (Node n = head; n.getNext() != null; n = n.getNext())
				num++;
			return num;
		}else return 0;
	}


	@Override
	public String toString() {
		StringBuffer sb= new StringBuffer();
		sb.append("[");
		Node n = head;
		while(n != null){
			sb.append(n);
			n = n.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	
	//clear list's content, but list still exists as an object
	public void clearList() {
		Node head = this.head;
		while (head != null){
			Node temp = head.getNext();
			head = null;
			this.head = temp;
			head = this.head;
		}
		this.size = 0;
	}
	
	public static void main(String[] args) {
		
		SingleLinkedList list = new SingleLinkedList();
		list.put(1);
		list.put(2);
		list.put(3);
		list.put(4);
		list.put(5);
		list.put(6);
		list.put(7);
		list.put(8);
		list.put(9);
		list.put(10);
		list.put(11);
		list.put(12);  

		System.out.println("ORIGINAL SIZE OF LIST:"+ list.findSize());
		System.out.println(list);
		
		System.out.println();
		//list.remove(index);
		list.remove(0);
		list.remove(7);
		list.remove(3); 
		
		System.out.println("CURRENT SIZE OF LIST: "+ list.findSize());
		System.out.println(list);
		System.out.println(list.size);
		
		list.clearList();
		list.getHeadValue();
		System.out.println(list);
		System.out.println();
		list.put(707);
		System.out.println(list);
		list.addNewTail(44);
		System.out.println(list);
		list.deleteTail();
		System.out.println(list);
		list.addNewHead(606);
		System.out.println(list.getHeadValue());
	}
}
