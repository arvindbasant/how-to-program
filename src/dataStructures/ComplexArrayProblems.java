package dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComplexArrayProblems {
    // 1. Tapping Rain Water
    static int maxWaterTapped(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int res = 0;

        while (left <= right) {
            if(leftMax < rightMax) {
                res += Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left]);
                left++;

            } else {
                res += Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right]);
                right--;
            }
        }

        return res;
    }

    //  2. MajorityElement
    private int findCandidate(int[] arr, int size) {
        //{ 1, 3, 3, 3, 2 };
        int count = 1, maj_index = 0;
        for(int i = 1; i < size; i++){
            if(arr[i] == arr[maj_index])
                count++;
            else
                count--;

            if(count == 0) {
                maj_index = i;
                count = 1;
            }

        }
        return arr[maj_index];
    }

    private boolean isMajority(int[] arr, int size, int candidate) {
        int count = 0;
        for(int i=0; i<size; i++) {
            if(arr[i] == candidate)
                count++;
        }
        return count > size/2;
    }

    void printMajority(int[] arr, int size) {
        int candidate = findCandidate(arr, size);
        if(isMajority(arr, size, candidate))
            System.out.println("Majority: " + candidate);
        else
            System.out.println("No Majority");
    }

    // 3. search elem in sorted & rotated arr
    int search(int[] arr, int l, int h, int key) {
        if(l > h)
            return -1;
        int mid = (l + h)/2;
        if(key == arr[mid])
            return mid;

        if(arr[l] <= arr[mid]) {
            if(key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid -1, key);
            return search(arr, mid + 1, h, key);
        } else {
            if(key >= arr[mid + 1] && key <= arr[h])
                return search(arr, mid + 1, h, key);
            return search(arr, l, mid -1, key);
        }
    }


    // 4. bitonic point
    static int bitonicPoint(int[] arr, int l, int r) {
        while (l<=r) {
            int m = (l + r) / 2;

            if(l == r + 1 && arr[l] >= arr[r])
                return arr[l];
            if(l == r + 1 && arr[l] < arr[r])
                return arr[r];

            if(arr[m] > arr[m-1] && arr[m] > arr[m + 1])
                return arr[m];

            if(arr[m] > arr[m-1] && arr[m] < arr[m+1])
                l = m + 1;
            else
                r =  m - 1;
        }
        return -1;
    }

    static int findMaxLength(int[] nums) {
        Map< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    static boolean searchSortedMatrix(int[][] mat, int x) {
        int rowLength = mat.length;
        int colLength = mat[0].length;

        int i = 0, j = colLength - 1;

        while (i < rowLength && j >= 0){
            if(mat[i][j] == x)
                return true;

            if(mat[i][j] > x)
                j--;
            else
                i++;
        }
        return false;
    }


    static void segregateZerosAndOnes(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            while (arr[l] == 0 && l < r)
                l++;
            while (arr[r] == 1 && l < r)
                r--;

            if(l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
    }

    static void sort012s(int[] arr) {
        int l = 0, h = arr.length - 1, m = 0, temp = 0;
        while (m <= h) {
            switch (arr[m]) {
                case 0:
                    temp = arr[l];
                    arr[l] = arr[m];
                    arr[m] = temp;
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    temp = arr[m];
                    arr[m] = arr[h];
                    arr[h] = temp;
                    h--;
                    break;
            }
        }
    }

    static class Point {
        int x, y;
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    static int shortestPath(Point p1, Point p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);

        return Math.max(dx, dy);
    }

    static int minSteps(Point[] points) {
        int steps = 0;
        for(int i = 0; i < points.length - 1; i++) {
            steps += shortestPath(points[i], points[i + 1]);
        }
        return steps;
    }

    public static void main(String[] args) {
        ComplexArrayProblems obj = new ComplexArrayProblems();
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Maximum water tapped " + maxWaterTapped(arr));

        int[] a = new int[] { 1, 3, 3, 3, 2 };
        obj.printMajority(a, a.length);

        int[] arr1 = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };

        System.out.println("Search " + obj.search(arr1, 0, arr1.length - 1, 6));

        int[] bitonicArr = { 1, 3, 50, 10 };
        System.out.println("Bitonic Point " + bitonicPoint(bitonicArr, 0, bitonicArr.length - 1));

        int[] arrZerosOnes = { 1, 0, 0, 1, 0, 1, 1 };
        System.out.println("Max " + findMaxLength(arrZerosOnes));

        int[][] mat = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        System.out.println("SearchSortedMatrix " + searchSortedMatrix(mat, 29));

        int[] zeroOnesArr = {1, 0, 1, 1, 1, 0, 0, 1};
        segregateZerosAndOnes(zeroOnesArr);
        System.out.println("Segregate Zero One" + Arrays.toString(zeroOnesArr));

        int[] arr012s = {0, 1, 2, 2, 1, 1, 0, 1, 0};
        sort012s(arr012s);
        System.out.println("Sorted 0, 1, 2s" + Arrays.toString(arr012s));

        Point[] points = new Point[4];
        points[0] = new Point(4, 6);
        points[1] = new Point(1, 2);
        points[2] = new Point(4, 5);
        points[3] = new Point(10, 12);


        System.out.println("Min Steps " + minSteps(points));
    }
}
