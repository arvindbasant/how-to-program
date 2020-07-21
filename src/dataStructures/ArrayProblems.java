package dataStructures;

import java.util.Arrays;

public class ArrayProblems {

    public boolean isAnagram(String s1, String s2) {

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        if (s1Arr.length != s2Arr.length)
            return false;

        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i])
                return false;
        }
        return true;
    }

    // TC: O(n), SC: O(1)
    public boolean isAnagram2(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;
        int value = 0;

        for (int i = 0; i < s1.length(); i++) {
            value = value ^ s1.charAt(i);
            value = value ^ s2.charAt(i);
        }

        return value == 0;

        // XOR will be 0 if
    }

    public boolean isPalindrome(String str) {
        int startIndex = 0;
        int lastIndex = str.length() - 1;

        while (lastIndex > startIndex) {
            if (str.charAt(startIndex++) != str.charAt(lastIndex--))
                return false;
        }
        return true;
    }

    public int maxContinuous1s(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 0)
                count = 0;
            else
                count++;
            max = Math.max(count, max);
        }
        return max;
    }

    public void rowWithMax1sInMatrix() {

    }

    // TC: O(m + n)
    public void rowWithMax1sInSortedMatrix(int[][] bMatrix) {

        int rowLength = bMatrix.length;
        int colLength = bMatrix[0].length;

        int row = 0;

        for (int i = colLength - 1; i >= 0; i--) {
            if (bMatrix[row][i] == 0) {
                while (bMatrix[row][i] != 1 && row < rowLength - 1) {
                    row++;
                }
            }
        }

        System.out.println("Row With Max 1s In Sorted Matrix:" + row);

    }

    private int minElemInSortedRotedArray(int[] arr, int low, int high) {
        // [4, 5, 6, 7, 1, 2, 3]
        if (high < low) // no rotation
            return arr[0];

        if (low == high) // only one left
            return arr[low];

        int mid = (low + high) / 2;

        if (mid < high && arr[mid + 1] < arr[mid]) // min next to mid {3, 4, 5, 1, 2}
            return arr[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        if (arr[mid] > arr[mid - 1])
            return minElemInSortedRotedArray(arr, mid + 1, high);
        return minElemInSortedRotedArray(arr, low, mid - 1);
    }

    private void rotateArrayByNElem(int[] arr, int d, int n) {

        if(arr.length == 0)
            return;

        // use temp array for TC:O(1)
        // TC: O(n*d)
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 1; j < n; j++) {
                arr[j - 1] = arr[j];
            }
            arr[n - 1] = temp;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private void rotateArrayByNElemUsingJugglingAlgorithm(int[] arr, int d, int n) {
        // 1, 2, 3 - 4, 5, 6 - 7, 8, 9 - 10, 11, 12
        int gcd = gcd(d, n); // 3
        for (int i = 0; i < gcd; i++) {
            int first = arr[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = first;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    void print3LargestNoOfArray(int[] arr, int size) {

    }


    public static void main(String[] args) {
        ArrayProblems ap = new ArrayProblems();
//        System.out.println(ap.isAnagram("hello", "olelh"));
//        System.out.println(ap.isAnagram2("hello", "olelh"));
//        System.out.println(ap.isPalindrome("madam"));
//        System.out.println(ap.maxContinuous1s(new int[]{1, 0, 1, 1, 1, 0}));
//
//        int[][] bMatrix = {{0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
//        ap.rowWithMax1sInSortedMatrix(bMatrix);
//
//        System.out.println("minElemInSortedRotedArray" + ap.minElemInSortedRotedArray(new int[]{4, 5, 1, 2, 3}, 0, 4));

        ap.rotateArrayByNElem(new int[]{1, 2, 3, 4, 5, 6}, 2, 6);
//        ap.rotateArrayByNElemUsingJugglingAlgorithm(new int[]{1, 2, 3, 4, 5, 6}, 2, 6);

    }
}
