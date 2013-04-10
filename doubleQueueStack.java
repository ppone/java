

public class doubleQueueStack
{ 
	Queue front;
	Queue back;
	Queue current;

	doubleQueueStack()
	{
		front = new Queue();
		back = new Queue();
		current = front;
	}

	public void push(Object o)
	{ 
		System.out.println("Pushing " + o.toString() + " onto stack");
		current.enQueue(o);

	}

	public Object pop()
	{  long counter = current.getCount();
	   Queue other;
	   Object tmp;

	   if (counter == 0)
	   	{   System.out.println("Stack is empty");
	   		return null;
	   	}	

	   if (current == front)
	   		other = back;
	   else
	   		other = front;

       while (counter > 1)
       {
       		tmp = current.deQueue();
       		other.enQueue(tmp);
       		counter--;
       }
       
       tmp = current.deQueue();

       current = other;

       System.out.println("Popping " + tmp.toString() + " from stack");
       return tmp;

	}

	public long getCount()
	{	
		return current.getCount();
	}
	protected void printCount()
	{
		System.out.println("Size of stack is " + current.getCount());
	}

	static class Queue
	{
		Node root;
		Node current_node;
		long count;

		Queue()
		{
			count = 0;
		}

		protected void enQueue(Object o)
		{
			Node node;

			if (root == null)
			{
				root = new Node(o);
				current_node = root;
				count++;
			}	
			else
			{	node = new Node(o);
				current_node.setNext(node);
				current_node = node;
				count++;
			}

		}

		protected Object deQueue()
		{
			Node node;

			if (root == null)
				return null;

			node = root;
			root = root.getNext();
			count--;
			return node.getValue();

		}

		protected long getCount()
		{	
			return this.count;
		}


	}

	static class Node
	{
		private Object o;
		private Node next;

		Node(Object o)
		{
			this.o = o;
		}

		protected void setNext(Node node)
		{
			this.next = node;
		}

		protected Node getNext()
		{
			return this.next;
		}

		protected Object getValue()
		{
			return this.o;
		}

	}


	public static void main(String args[])
	{
		doubleQueueStack q = new doubleQueueStack();

		//pushing operations
		q.push("hllo");
		q.push("goodbye");
		q.push("jigi");
		q.push("ass");
		q.push("parag");
		q.push("bmw");
		
		//popping operations
		q.pop();
		q.push("rent");
		q.pop();
		q.pop();
		q.pop();		
		q.pop();
		q.push("liz");
		q.pop();		
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.printCount();
		q.push("Rob");
		q.push("Katie");
		q.printCount();
		q.pop();
		q.pop();
		q.printCount();


	

	}

}