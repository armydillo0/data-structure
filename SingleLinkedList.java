
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
	
	public int get(int index) {
		Node n = head;
		for(int i=0; i < index; i++)
			n = n.getNext();
		return n.getValue();
	}
	
	// Remove
	
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
		
		System.out.println(list);;
	}

}
