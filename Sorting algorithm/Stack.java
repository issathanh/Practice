import java.util.EmptyStackException;

public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack(); 
        int num = stack.top();

        
    }
    class Node 
    {
        Node next; 
        int data; 

        public Node (int data)
        {
            this.data = data; 
            next= null;

        }
    }
    private Node head; 
    public Stack()
    {
        head = null; 
    }

    public void push(int data)
    {
        Node newData = new Node(data); 
        newData.next= head;
        head = newData;         
    }

    public int pop()
    {
        if(head == null) throw new EmptyStackException(); 
        int item = head.data; 
        head = head.next; 
        return item; 
    }

    public int top()
    {
        if(head == null) throw new EmptyStackException(); 
        int item  = head.data; 
        return item; 
    }

    public boolean isEmpty()
    {
        return head==null; 
    }   
    public void printStack()
    {
        Node curr = head;
        String str = "\""; 
        while(curr!=null)
        {
            str+=curr.data; 
            curr = curr.next; 
        }
        str+= "\""; 
        System.out.println(str);
    }

}

