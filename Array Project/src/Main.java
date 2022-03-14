import java.util.*;
class Main{
    // Function to add x in array
    public static int[] add_element(int n, int myArray[], int x)
    {
        int i;

        int newArray[] = new int[n + 1];

        for (i = 0; i < n; i++)
        newArray[i] = myArray[i];

        newArray[n] = x;

        return newArray;
    }

    // Function to delete x in array
    public static int[] delete_element(int myArray[])
    {
        int i;
        int n= myArray.length;

        int newArray[] = new int[n - 1];

        for (i = 0; i < n-1; i++)
            newArray[i] = myArray[i];

        return newArray;
    }

    //Function to insert x in array
    public static int[] insert_element(int n, int myArray[], int y, int p)
    {
        int i;

        int newArray[] = new int[n + 1];

        for (i = 0; i < p; i++)
        newArray[i] = myArray[i];

        newArray[p] = y;

        for (i = p + 1; i < n + 1; i++)
        newArray[i] = myArray[i-1];

        return newArray;
    }

    public static void main(String[] args)
    {
        int n = 5;
        int i;

        //Original array
        int myArray[] = { 1, 3, 4, 5, 6 };

        System.out.println("Original Array: "  + Arrays.toString(myArray));

        int x = 7;

        myArray = add_element(n, myArray, x);

        System.out.println("Array after adding a value: " + Arrays.toString(myArray));

        //delete last element in array
        myArray = delete_element(myArray);

        System.out.println("Array after deleting last value: " + Arrays.toString(myArray));

        int p = 1;
        int y = 2;

        //insert element in array
        myArray = insert_element(n, myArray, y, p);

        System.out.println("Array after inserting " + y + " into position " + p + ": " + Arrays.toString(myArray));
    }
}
