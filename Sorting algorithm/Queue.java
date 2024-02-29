import java.util.EmptyStackException;

public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue(); 
        queue.enque(5);
        queue.enque(6);
        queue.enque(7);
        queue.enque(8);
        queue.enque(9);
        queue.enque(10);
        queue.enque(1);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enque(999);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        int num = queue.front();
        System.out.println(num);

    }   
    class Node {
        Node next, prev; 
        int data; 

        public Node (int data)
        {
            this.data = data; 
            next = null;
            prev = null; 
        }
    }

    private Node HEAD = new Node(-99999999); 
    private Node TAIL = new Node(99999999);
    
    public Queue ()
    {
        HEAD.next = TAIL; 
        TAIL.prev= HEAD; 
    }


    public void enque(int data)
    {
        Node newNode = new Node (data); 
        Node prevNode = TAIL.prev; 
        prevNode.next= newNode; 
        newNode.prev = prevNode; 
        
        newNode.next= TAIL; 
        TAIL.prev = newNode; 
        
    }

    public int dequeue()
    {
        Node front = HEAD.next; 
        int item = front.data; 

        HEAD.next = front.next; 
        front.next.prev= HEAD; 

        return item; 
    }

    public int front ()
    {
        if (HEAD.next==TAIL) throw new EmptyStackException(); 
        return HEAD.next.data; 
    }
    public void printQueue()
    {
        Node curr = HEAD.next;
        String str = "\""; 
        while(curr!=TAIL)
        {
            str+=curr.data; 
            curr = curr.next; 
        }
        str+= "\""; 
        System.out.println(str);
    }
    class QueueArray{
        private int [] arr; 
        int end; 
        int front; 
        int size; 
        int capacity; 
        public QueueArray(int capacity)
        {
            this.capacity = capacity; 
            arr = new int [capacity]; 
            end = 0; 
            front = 0; 
            size =0; 
        }   

        public void enqueueArray (int data)
        {
            if(size == capacity)
            {
                System.out.println("Queue is full");
                return; 
            }
            end = (end+1) % capacity; 
            arr[end] = data; 
            size++; 
        }

        public int dequeueArray()
        {
            if(size==0)
            {
                System.out.println("Queue is Empty");
                return Integer.MIN_VALUE;  
            }
            int data = arr[front()]; 
            front = (front+1) %capacity; 
            size--; 
            return data; 
        }

        public int front()
        {
            if (size ==0 )
            {
                System.out.println("queue is empty");
                return Integer.MIN_VALUE; 
            }
            return arr[front]; 
        }
        public int size()
        {
            return size;
        }
        public boolean isEmpty()
        {
            return size ==0 ; 
        }
    }
}
