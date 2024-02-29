// 
//  * if you have 529
//  * 529%10 = 9-  to get the last digit  
//  * 529/10 % 10 = 2 - to get the second last digit 
//  * 
//  

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int [] arr = {132,353,645,324,678,123,879,342,67,453,768,1}; 
        RadixSort rad = new RadixSort(arr);
        rad.radixInnit();
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
        int [][] count = new int [arr.length][10]; 
        //assign each value to a bucket
        for (int values : arr)
        {
            int i = 0; 
            //if theres a value already then go to the next spot
            while(count[i][(values/time)%10] != 0)
            {
                i++; 
            } 
            count[i][(values/time)%10] = values;  
        }
        print2DArray2(count);
        //reput the item in the bucket back to the array
        int a = 0; 
        for (int i = 0; i < count[0].length; i++)
        {
            int j =0; 
            while(count[j][i]!=0)
            {
                arr[a] = count[j][i]; 
                a++; 
                j++; 
            }
        }
        //recurse the method
        radixSort(arr, time*10);
    }

    public static void print2DArray(int[][] array) {
        String s = ""; 

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                s += array[i][j] + " "; 
            }
            s+="\n"; 
        }

        System.out.println(s);
    }

    public static void print2DArray2(int[][] array) {
        int maxLength = 0;
        // Find the maximum length of numbers in the array
        for (int[] row : array) {
            for (int element : row) {
                maxLength = Math.max(Integer.toString(element).length(), maxLength);
            }
        }

        StringBuilder sb = new StringBuilder();
        String formatString = "%-" + maxLength + "d"; // Create a format string for padding

        for (int[] row : array) {
            for (int element : row) {
                // Format each element to have the same width and append it to the StringBuilder
                sb.append(String.format(formatString, element)).append(" ");
            }
            // Replace the last space with a newline character for the next row
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        // Print the final string representation of the 2D array
        System.out.println(sb.toString());
    }

}

