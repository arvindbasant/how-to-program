package algorithms.sorting;

public class QuickSort {
    final int[] arr;

    QuickSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while(true) {
            while(arr[++leftPtr] < pivot) // find next bigger
                ; // nop
            while(rightPtr > 0 && arr[--rightPtr] > pivot)
                ; // nop

            if(leftPtr >= rightPtr)
                break;

            swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right); // restore pivot
        return leftPtr;
    }

    private void recSort(int left, int right) {
       if(left < right) {
           int pivot = arr[right];
           int partition = partitionIt(left, right, pivot);
           recSort(left, partition - 1);
           recSort(partition + 1, right);
       }
    }

    public void sort() {
        recSort(0, arr.length - 1);
    }

    public static void main(String... args) {
        int[] arr = {1, 12, 8, 5, 19};
        QuickSort qs = new QuickSort(arr);
        qs.sort();

        for(int num : arr)
            System.out.println(num);
    }
}
