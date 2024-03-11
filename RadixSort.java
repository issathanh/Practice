// 
//  * if you have 529
//  * 529%10 = 9-  to get the last digit  
//  * 529/10 % 10 = 2 - to get the second last digit 
//  * 
//  

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int [] arr = {132,353,645,324,678,123,879,342,67,453,768,1,0}; 
        RadixSort rad = new RadixSort(arr);
        rad.radixInnit();
    }
    class Node {
        int data; 
        Node next; 
        
        public Node (int data)
        {
            this.data = data; 
            next = null; 
        }
    }
    class Bucket
    {
        private final Node HEAD = new Node (-500000);
        private final Node TAIL = new Node (5000000);  
        public Bucket()
        {
            HEAD.next = TAIL;
        }
        
        public void insert (int data)
        {
            Node newNode = new Node (data);
            Node currNode = HEAD.next; 
            HEAD.next = newNode; 
            newNode.next = currNode; 

        }
        public int delete()
        {
            
            Node currNode = HEAD.next; 
            Node prevNode = HEAD; 
            while(currNode.next!= TAIL)
            {
                prevNode = currNode; 
                currNode = currNode.next; 
            }
            int item = currNode.data; 
            prevNode.next = TAIL; 
            return item; 
        }
        
    }
    private int [] arr; 
    
    
    public RadixSort(int[] arr)
    {
        this.arr =arr; 
    }
    public void radixInnit()
    {
        radixSort(arr,1); 
        printArray(arr);
    }
    public void printArray(int[]arr)
    {
        String s = ""; 
        for (int i =0; i < arr.length; i++)
        {
            s+= arr[i] + " "; 
        }
        System.out.println(s);
    }
    public boolean isSorted(int []arr)
    {
        for (int i =0 ;i < arr.length-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }
        return true; 
    }
    public void radixSort(int [] arr,int time)
    {
        if(isSorted(arr))
        {
            return; 
        }
        //create the 10 buckets
        //int [][] count = new int [arr.length][10]; 
        Bucket [] buckets = new Bucket [10]; 
        for (int i =0; i < buckets.length; i++)
        {
            buckets[i] = new Bucket(); 
        }

        //assign each value to a bucket
        for (int values : arr)
        {
            // int i = 0; 
            // //if theres a value already then go to the next spot
            // while(count[i][(values/time)%10] != 0)
            // {
            //     i++; 
            // } 
            // count[i][(values/time)%10] = values;
             
           buckets[(values/time)%10].insert(values);
        }
        //reput the item in the bucket back to the array
        int a = 0; 
        // for (int i = 0; i < count[0].length; i++)
        // {
        //     int j =0; 
        //     while(count[j][i]!=0)
        //     {
        //         arr[a] = count[j][i]; 
        //         a++; 
        //         j++; 
        //     }
        // }
        for (int i = 0; i < buckets.length; i++)
        {
            while(buckets[i].HEAD.next != buckets[i].TAIL)
            {
                arr[a] = buckets[i].delete(); 
                a++; 
            }

        }
        //recurse the method
        radixSort(arr, time*10);
    }

    

}

