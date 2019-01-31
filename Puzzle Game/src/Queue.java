
public class Queue
{
	public int rear;
	public int front;
	public Object [] elements = new Object[1000];
	
	Queue(int capacity)
	{
	 rear = -1;
	 front = 0;
	}
	
	public void enqueue(Object data)
	{
		if(isFull())
		{
			System.out.println("Queue is overflow");
		}
		else
		{
			rear++;
			elements[rear] = data;
		}
	 }
	
	 Object dequeue()
	 {
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return 0;
		}
		else
		{
			Object retdata = elements[front];
			elements[front] = 0;
			front++;
			return retdata;
		}
	 }
	 
	 Object peek()
	 {
		 if(isEmpty())
		 {
			 System.out.println("Queue is Empty");
			 return null;
		 }
		 else
		 {
			return elements[front];
		 }
	 }
	 
	 boolean isEmpty()
	 {
		 return rear < front;
	 }
	 
	 boolean isFull()
	 {
		 return(rear+1 == elements.length);
	 }
	 
	 int size()
	 {
		 return rear-front+1;
	 }
	
}
