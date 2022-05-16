package dataStructures;

public class ArraysTest {

    static int search(int[] arr, int l, int r, int key) {
        if(l > r)
            return -1;
        int mid = (l + r) /2;
        if(arr[mid] == key)
            return mid;
        if(key < arr[mid] && key > arr[l]) {
            
        }



        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(search(arr, 0, arr.length, 1));
    }
}
