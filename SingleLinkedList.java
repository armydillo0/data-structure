
public class SingleLinkedList {

	Node head;
	
	public SingleLinkedList() {
		this.head = null;
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
		list.remove(6);
		
		System.out.println("CURRENT SIZE OF LIST: "+ list.findSize());
		System.out.println(list);
	}
}
