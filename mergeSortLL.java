public class mergeSortLL {

    public static void main(String[] args) {
        int [] arr = {1,2,5,6,2,3,8,3,24,34,8,231,78,23,31,4,12,534}; 
        mergeSortLL newList = new mergeSortLL(arr);
        newList.mergeSortDriver(); 

    }
    class Node 
    {
        Node next; 
        int data; 
        private Node (int data)
        {
            this.data = data; 
            next = null; 
        }
    }
    Node head; 
    private int [] arr; 
    public mergeSortLL(int [] arr)
    {
        head = null; 
        this.arr = arr; 
        insertArray();;
    }

    public void insert (int data)
    {
        Node newNode = new Node(data); 

        if (head == null)
        {
            head = newNode; 
        }
        else
        {
            Node curr = head ;
            while(curr.next!=null)
            {
                curr = curr.next; 
            }
            curr.next = newNode; 
        }
       
    }
    public void insertArray ()
    {
        for (int i = 0; i < arr.length; i++)
        {
            insert(arr[i]); 
        }
    }   
    public void mergeSortDriver()
    {
        head = mergeSort(head);
        print();

    }
    public void print()
    {
        Node curr = head;
        String s = "";
        while(curr!= null)
        {
            s+= curr.data + " "; 
            curr = curr.next; 
        }
        System.out.println(s);
    }
    public Node mergeSort(Node top)
    {   
        if (top == null || top.next == null)
        {
            return top; 
        }

        Node middle = findMiddle(top); 
        Node nextOfMiddle = middle.next; 
        middle.next = null; 
        Node left = mergeSort(top);
        Node right = mergeSort(nextOfMiddle);
        return merge(left,right); 
    }

    public Node merge(Node left, Node right)
    {
        //if theres no element left in the left list
        //return the right list
        if (left == null )
        {
            return right; 
        }
        //if theres no element left in the right list
        //return the left list
        if (right == null)
        {
            return left; 
        }
        Node result = null;
        if (left.data <= right.data)
        {
            result = left; 
            result.next= merge(left.next, right); 
        }
        else{
            result = right; 
            result.next = merge(left, right.next); 
        }
        return result; 
    }
    public Node findMiddle(Node head)
    {
        
        if (head == null)
        {
            return head; 
        }
        
        Node fast = head;
        Node slow = head; 
        while(fast.next!= null&&fast.next.next != null)
        {
            fast = fast.next.next; 
            slow = slow.next; 
        }
        return slow; 
    }
}
