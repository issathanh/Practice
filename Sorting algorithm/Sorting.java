import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        Random rand = new Random();
        int [] num = new int [10]; 
        //get random array
        for (int i = 0; i< num.length; i++)
        {
            num[i] = rand.nextInt(100000);
        }

        //print before 
        System.out.println("Before: ");
        printArray(num);     
        
        quickSort(num, 0, num.length-1);
        //print after 
        System.out.println("After");
        printArray(num);
    }


    public static void printArray(int [] Arr)
    {
        for (int i = 0; i < Arr.length; i++)
        {
            System.out.println(Arr[i]);
        }
    }   

    public static void quickSort(int []arr, int lowIndex, int highIndex)
    {   
        
        if(lowIndex >= highIndex)
        {
            return; 
        }
        choosePivot(arr,lowIndex,highIndex);
        int pivot = lowIndex; 
        int small = lowIndex; 
        int big = lowIndex+1; 
        while (big <= highIndex)
        {   
            if (arr[big] < arr[pivot])
            {
                small++; 
                swap(arr,big,small);
                big++; 
            }
            else
            { 
                big++;
            }
        }
        swap(arr, pivot, small); 
        quickSort(arr, lowIndex, small-1);
        quickSort(arr,small+1, highIndex); 

    }
    
    public static void swap(int []arr, int a, int b)
    {
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    }
    public static void choosePivot(int[] arr, int low, int high)
    {
        int i =low; 
        int j = (low+high)/2 ; 
        int k = high; 
        int pivot = 0; 
        if (arr[i]<=arr[j]&&arr[j]<=arr[k])
        {
            pivot = j;
        }
        else if (arr[j]<=arr[i]&&arr[i]<=arr[k])
        {
            pivot = i; 
        }
        else
        {
            pivot = k;
        }
        swap(arr,pivot,low); 
    }   


}


