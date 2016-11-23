

import java.util.NoSuchElementException;

class DoublyLinkedList<T extends Comparable<T>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; 
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic runtime cost: theta(1)
	 *
	 * Justification:
	 * Since we are assuming that every basic operation takes theta(1) time, and we are only accessing the head, the running time will be constant, we don't have to iterate throught all the nodes.
	 *  
	 */
	public boolean isEmpty()
	{

		if(head==null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *  * Worst-case asymptotic runtime cost: Theta(n)
	 *
	 * Justification: Let us assume every basic operation takes theta(1) asymptotic time.
	 * in insertBefore()method we have to iterate through the nodes,starting from the head until the defined position is not reached.
	 * Accessing each node takes theta(1). Suppose in DoublyLinkedList we have n elements, therefore, in the worst case the position defined 
	 * is the last position and thus have to iterate through all the elements.
	 * calling insertFirst() and insertLast() methods from the insertBefore () method also take a constant time to run as we are only doing basic operation(accessing the head or the tail and referencing.)
	 * n* theta(1)
	 *
	 */
	public void insertBefore( int pos, T data ) 
	{

		//DLLNode newNode = new DLLNode(data, null, null);
		if(pos<0){
			//throw new NoSuchElementException();
			insertFirst(data);	

		}

		else if(pos>=(size()-1)){
			//throw new NoSuchElementException();
			insertLast(data);
		}


		else{
			DLLNode newNode = new DLLNode(data, null, null);
			//iterate through the list until pos found
			DLLNode targetNode = head;
			for(int i=0;i<pos;i++){
				//iterate through the list,starting from the head. going through each node until the target node is not found.
				targetNode = targetNode.next;
			}

			//link the new node with the previous node and the next node, and vice versa.
			newNode.next = targetNode;
			//System.out.println("it is"+targetNode.prev);
			newNode.prev = targetNode.prev;
			if(targetNode.prev ==null){

				head = newNode;
			}
			else{
				targetNode.prev.next = newNode;
			}
			targetNode.prev= newNode;

		}


	}

	public void insertLast(T data) {
		//create new node with specified data.
		DLLNode newNode = new DLLNode(data, null, null);
		//new node becomes tail and oldtail.next is new node.
		if(head==null){
			head = newNode;
			tail = newNode;
			newNode.prev = null;
			newNode.next=null;
		}
		else{
			DLLNode oldTail = tail;
			tail = newNode;
			oldTail.next = tail;
			tail.prev = oldTail;
		}	


	}

	public void insertFirst(T data) {

		DLLNode newNode = new DLLNode(data, null, null);
		if(head==null){
			head = newNode;
			tail = head;
			head.next=null;
			tail.next = null;
		}

		else{
			head.prev = newNode;
			newNode.next = head;
			//update head to newNode
			//newNode = head;
			head = newNode;
		}
	}

	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic runtime cost: theta(n)
	 *
	 * Let us assume every basic operation takes theta(1) asymptotic time.
	 * in get()method we have to iterate through the nodes,starting from the head until the defined position is not reached.
	 * Accessing each node takes theta(1). Suppose in DoublyLinkedList we have n elements, therefore, in the worst case the position
	 * defined is the last position and thus have to iterate through all the elements. basic operations take us constant time.
	 * n* theta(1)
	 *
	 */

	public T get(int pos){


		if(pos<0 ){

			return null;
		}
		if(pos>=size()){
			return null;
		}

		else{

			DLLNode targetNode = head;
			for(int i =0;i<pos;i++){

				//iterate through the list,starting from the head. going through each node until the target node is not found.
				targetNode = targetNode.next;			

			}
			//targetNode found
			return targetNode.data;

		}

	}





	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 * Worst-case asymptotic runtime cost: theta(n)
	 *Justification:
	 * Let us assume every basic operation takes theta(1) asymptotic time.
	 * in deleteAt()method we have to iterate through the nodes,starting from the head until the defined position is not reached.
	 * Accessing each node takes theta(1). Suppose in DoublyLinkedList we have n elements, therefore, in the worst case the position
	 * defined is the last position and thus have to iterate through all the elements. accesing the nodes takes us constant time.
	 * if for each node it takes us a constant time, for n nodes it till takes us:
	 * n* theta(1)
	 * theta(n)

	 */



	public boolean deleteAt(int pos){

		if(pos<0 || pos>=size()){return false;}


		else if(size()==1 ){

			head = null;
			tail = null;
			return true;
		}


		else{ //if(size()>1){
			DLLNode targetNode = head;
			for(int i=0;i<pos;i++)
			{
				//iterate through the list,starting from the head. going through each node until the target node is not found.
				targetNode = targetNode.next;
			}

			if(targetNode==head){
				head = targetNode.next;
				head.prev = null;
				targetNode.next = null;
				return true;
			}
			else if(targetNode==tail){
				tail = targetNode.prev;
				tail.next = null;
				targetNode.next = null;
				targetNode.prev = null;
				return true;			
			}

			else{
				targetNode.prev.next = targetNode.next;
				targetNode.next.prev = targetNode.prev;
				//	no loitering;giving null reference to nodes we do not require, to free up space.	
				targetNode.next = null;
				targetNode.prev = null;
				return true;

			}

		}



	}	




	/*----------------------- STACK --------------------------------------------------------*/
	/**
	 * This method should behave like the usual push method of a Stack ADT.
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic runtime cost: theta(1)
	 *
	 * Justification:
	 *  Let us assume every basic operation takes theta(1) asymptotic time.
	 * in push()method we are pushing an element to the top of the stack, we do not have to iterate trough any nodes.
	 * Hence when an element is pushed onto a stack, we are referencing the head and the next node to it, which takes constant time
	 * as they are basic operations.
	 */
	public void push(T item) 
	{
		//LIFO structure.
		if(head==null){
			//if stack empty:
			head = new DLLNode(item,null,null);
			tail=head;
		}
		else{

			DLLNode oldHead = head;
			head = new DLLNode(item,null,null);
			head.next = oldHead;
			oldHead.prev = head;
		}
	}

	/**
	 * This method should behave like the usual pop method of a Stack ADT.
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic runtime cost: theta(1)
	 *
	 * Justification:
	 * Let us assume every basic operation takes theta(1) asymptotic time.
	 * Stack has a LIFO structure, in the pop() method we only have to access the topmost node in the stack, we do not have to 
	 * iterate through other nodes hence it should take constant time,theta(1) 

	 */
	public T pop() 
	{

		if(isEmpty()){
			return null;
			//throw new NoSuchElementException();

		}

		T value = head.data;
		if(head.next!=null){
			head = head.next;		//next one in line becomes the head.
			head.prev = null;
		}
		else {//if(head.next==null){
			head =null;
			tail=null;
		}
		return value;
	}


	/*----------------------- QUEUE */

	/**
	 * This method should behave like the usual enqueue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic runtime cost: theta(1)
	 * Justification:
	 *Let us assume every basic operation takes theta(1) asymptotic time.
	 *the queue ADT has a FIFO structure, hence if we want to enqueue an element we have to add it to the back of the queue,the tail and
	 *do the necessary referencing. This will take us constant time as we do not have to iterate throught the size of the queue.
	 * 

	 */
	public void enqueue(T item) 
	{
		//FIFO strucure.
		//last  = new DLLNode(item,null,null);
		if(isEmpty()){
			tail = new DLLNode(item,null,null);	
			head = tail;
		}
		else{
			DLLNode oldTail = tail;
			tail = new DLLNode(item,null,null);
			tail.prev = oldTail;
			//tail = oldTail.next;
			oldTail.next = tail;

			//oldTail = tail.prev;
		}

	}

	/**
	 * This method should behave like the usual dequeue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @return the earliest item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic runtime cost: Theta(1)
	 *
	 * Justification:
	 *Let us assume every basic operation takes theta(1) asymptotic time.
	 *the queue ADT has a FIFO structure, hence if we want to dequeue and element we will only have to access the head, which takes
	 *constant time--->theta(1)asymptotic runtime.
	 */
	public T dequeue() 
	{
		T data = null;
		if(isEmpty()){
			return null;	
			//throw new NoSuchElementException();
		}
		else {
			data = head.data;
			head = head.next;
			if(head==null){
				//have reached the end,both head and tail point to a null reference.
				tail =head;

			}
		}
		return data;
	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic runtime cost:Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 */
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true; 

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

	public int size() {
		int count = 0;
		//start from head whilst node is not null iterate over nodes and increment count each time.
		for (DLLNode dnode = head; dnode != null; dnode = dnode.next) {
			count++;
		}
		return count;
	}


}
