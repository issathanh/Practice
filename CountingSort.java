
import java.util.Arrays;

public class CountingSort {
    // use the number as an index to another array
    //the number of occurance an index have
    //will be the value of that index in the new array
    // and to sort it just print out the the index x amount of time
    //where x is its value 
    // if theres a negative number , get the min and max of that array
    // calculate how many spaces between those indexs 
    //and to get the position of any index, you use
    //value - min = index
    // and array of -2 to 7 = {5,2,7,4,-2,2}
    // we will use a new array of size 10, max - min + 1 = 7-(-2) + 1 = 9 + 1 (for the 0) = 10
    // the new array obviously has an index from 0 to 9 
    // to find that index 5 is in the new array,  we do 5- (-2) = 7

    private final int[] arr; 
    public CountingSort(int [] arr)
    {
        this.arr = arr; 
    }

    public void sort()
    {
        //get the min value
        int min = Arrays.stream(arr).min().orElse(0); 
        
        //get the max value
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE); 

        //7 - (-2)+ 1 = 10 
        int [] countArray = new int [max -min + 1]; 

        //this loops count the number of occurences each value has
        for (int value : arr)
        {
            //the for loops iterate through the array, for each iteration
            //assign the current element from the array or collectionar to value
            // the type of value much match the type of element store in arr 

            countArray[value-min]++; //add one to that index
            //(5,2,7,4,-2,2)
            // -2 - (-2) = 0;
            //5 - (-2 ) = 7 
            // 2 - (-2 ) =4 
            // 7 - (-2) = 9 
        }
        //ascending order
        int arrayIndex = 0; 
        for (int i = 0; i < max- min +1; i++)
        {
            //if there value in the count array and while it bigger than 0
            while(countArray[i] > 0)
            {
                //countArray[0]  = 0 + -2 = -2 
                // count[4] = 4 + -2 = 2 
                // count[7] = 7 + -2 = 5
                arr[arrayIndex] = i + min ; 
                countArray[i]--; 
                arrayIndex++; 
            }
        }

        //descending order
        // for (int i = max-min; i >= 0; i--)
        // {
        //     //if there value in the count array and while it bigger than 0
        //     while(countArray[i] > 0)
        //     {
        //         //countArray[0]  = 0 + -2 = -2 
        //         // count[4] = 4 + -2 = 2 
        //         // count[7] = 7 + -2 = 5
        //         arr[arrayIndex] = i + min ; 
        //         countArray[i]--; 
        //         arrayIndex++; 
        //     }
        // }
    }
}
