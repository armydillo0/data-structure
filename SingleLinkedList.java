public class SingleLinkedList {

	Node head;
	
	public SingleLinkedList() {
		this.head = null;
	}
	//get head value
	public int getHeadValue() {
		if(this.head == null & this.findSize() == 0) {
			//create new null head node
			Node newHead = new Node(17);
			this.head = newHead;
			return newHead.getValue();
		}
		return this.head.getValue();
	}
	
	//create new head
	public void addNewHead(int value) {
		Node currentHead = this.head;
		if (currentHead == null) {
			Node newHead = new Node(value);
			this.head = newHead;
		}
		Node newHead = new Node(value);
		newHead.setNext(currentHead);
		this.head = newHead;
	}

	//delete head
	public void deleteHead() {
		if(this.head == null & this.findSize() == 0) {
			System.out.println("No existing node.");
		}
		Node currentHead = this.head;
		Node nextHead = currentHead.getNext();
		this.head = nextHead;
		currentHead.setNext(null);
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
	public void addTail(int value) {
		Node currentTail = this.getLastNode(this.head);
		Node newTail = new Node(value);
		currentTail.setNext(newTail); 
	}

	//delete tail
	public void deleteTail() {
		Node temp = this.head;
		while (temp.getNext() != this.getLastNode(this.head))
			temp = temp.getNext();
		Node tail = temp;
		tail.setNext(null);
	}
   
	//create new node at end of link
	public void put(int i) {
		Node n = new Node(i);

		// 1. LinkedList is empty
		if(this.head == null) {
			this.head = n;
		}
		// 2. LinkedList is not empty
		else {
			getLastNode(head).setNext(n);
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
		}else {
			Node p = getNode(index - 1);
			Node c = p.getNext();//kill target
			Node n = c.getNext();

			p.setNext(n);
			c.setNext(null);
		}
	}

	//get list size
	public int findSize() {
		if (head != null) {
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
		
		list.clearList();
		System.out.println();
		System.out.println();
		list.put(707);
		System.out.println(list);
		list.addTail(44);
		System.out.println(list);
		list.deleteTail();
		System.out.println(list);
		list.addNewHead(606);
		System.out.println(list.getHeadValue());
		System.out.println(list);
		list.deleteHead();
		list.deleteHead();
		System.out.println(list.getHeadValue());
		System.out.println(list);
	}
}
