import java.util.Random;

public class test1Review {
    public static void main(String[] args) {
        Random rand = new Random(); 
        int [] numbers = new int [10]; 

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(100); 
        }

        System.out.println("Before");
        printArray(numbers); 
        System.out.println("After");
        insertionSort(numbers);
        printArray(numbers);

    }
    public static void insertionSort(int [] arr)
    {
       for (int i = 1; i<arr.length; i++)
       {
        //store as temp value
        int currValue = arr[i];
        //go backward from the list 
        int j = i-1; 
        while(j >= 0 && arr[j]>currValue)
        {
            //move value to the right if value > than temp value 
            arr[j+1] = arr[j]; 
            j--; 
        }
        //store temp value 1 to the right of the value that isnt bigger than
        //temp value 
        arr[j+1] =currValue; 
       }
    }
    public static void swapArr (int [] arr, int a, int b)
    {
        int temp = arr[a]; 
        arr[a] = b; 
        arr[b] = temp; 

    }

    public static void printArray(int [] Arr)
    {
        for (int i = 0; i < Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
    }   

}
