package practice;

class BubbleSort {
    static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{12, 1, 67, 22, 99, 100};
        BubbleSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}


//
//
//import java.util.ArrayList;
//
//class NumRef {
//    NumRef(int n) {
//        num = n;
//    }
//    int num;
//}
//
//public class Test {
//
//    public void callByValue(int n){
//        n = 10;
//    }
//
//    public void callByReference(NumRef n){
//        n.num = 10;
//    }
//
//    public void sort(ArrayList<Integer> arrayList) {
//        ArrayList<Integer> copy = (ArrayList<Integer>)arrayList.clone();
//        copy.sort(Integer::compareTo);
//
//        System.out.println(copy);
//    }
//
//    public static void main(String[] args) {
//
////        String msg = "Hello";
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(12);
//        arrayList.add(1);
//        arrayList.add(200);
//
//        System.out.println(arrayList);
//
//
//        int a = 5; // value type
//        NumRef b = new NumRef(5); // ref type, all class types are ref type, User Define type, or Java class String, Array
//
//        Test obj = new Test();
//
//        obj.callByValue(a); // passes copy of the value
//
//
//        obj.callByReference(b); // passes ref i.e address of parameter
//
//        obj.sort(arrayList);
//
//
//        System.out.println(a);
//        System.out.println(b.num);
//        System.out.println(arrayList);
//
//    }
//}
