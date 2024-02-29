public class MergeSort {
    public static void mergeSort (int[] arr)
    {
        int arrayMiddle = arr.length/2; 
        int [] leftSide = new int [arrayMiddle];
        int [] rightSide = new int [arr.length - arrayMiddle]; 

        if (arr.length < 2)
        {
             return; 
        }
        for (int i = 0; i < arrayMiddle; i++)
        {
            leftSide [i] = arr[i]; 
        }
        for (int i = arrayMiddle; i < arr.length; i++)
        {
            rightSide[i-leftSide.length] = arr[i];  
        }
        mergeSort(leftSide);
        mergeSort(rightSide); 
        merge(leftSide,rightSide,arr);
    }

    private static void merge(int[]leftSide, int []rightSide, int [] arr)
    {
        int leftSize = leftSide.length; 
        int rightSize = rightSide.length; 
        int i = 0, j = 0, k=0; 
        while(i<leftSize && j < rightSize)
        {
            if (leftSide[i] <= rightSide[j])
            {
                arr[k] = leftSide[i];
                i++;
            }
            else 
            {
                arr[k] = rightSide[j];
                j++;
            }
            k++; 
        }
        while(i<leftSize)
        {
            arr[k] = leftSide[i]; 
            k++; 
            i++; 
        }
        while(j<rightSize)
        {
            arr[k] = rightSide[j];
            k++;
            j++;  
        }
        
    }
}