package misc;

import java.util.Arrays;
import java.util.List;

public class MaxRides {

    private static int collectMax(List<List<Integer>> mat) {
        int row = mat.size();
        int col = mat.get(0).size();
        int outer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = outer; j < col; j++) {
                if (mat.get(i).get(j) != -1) {
                    int rightSum = j != col - 1 && mat.get(i).get(j + 1) != -1 ? mat.get(i).get(j) + mat.get(i).get(j + 1) : 0;
                    int downSum = i != row - 1 && mat.get(i + 1).get(j) != -1 ? mat.get(i).get(j) + mat.get(i + 1).get(j) : 0;

                    if (rightSum >= downSum) {
                        if (j < col - 1) {
                            mat.get(i).set(j + 1, rightSum);
                            mat.get(i).set(j, 0);
                        }

                    } else {
                        if (i < row - 1) {
                            mat.get(i + 1).set(j, downSum);
                            mat.get(i).set(j, 0);
                            outer = j;
                            break;
                        }

                    }
                }
            }
        }

        if (mat.get(row - 1).get(col - 1) == 0 || mat.get(row - 1).get(col - 1) == -1)
            return 0;

//        for (int.get() ints : mat) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(ints.get(j) + " ");
//            }
//            System.out.println();
//        }

        int inner = col - 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = inner; j >= 0; j--) {
                if (mat.get(i).get(j) != -1) {
                    int upSum = i != 0 && mat.get(i - 1).get(j) != -1 ? mat.get(i).get(j) + mat.get(i - 1).get(j) : 0;
                    int leftSum = j != 0 && mat.get(i).get(j - 1) != -1 ? mat.get(i).get(j - 1) + mat.get(i).get(j) : 0;
                    if (upSum >= leftSum) {
                        if (i > 0) {
                            mat.get(i - 1).set(j, upSum);
                            mat.get(i).set(j, 0);
                            inner = j;
                            break;
                        }

                    } else {
                        if (j > 0) {
                            mat.get(i).set(j - 1, leftSum);
                            mat.get(i).set(j, 0);
                        }

                    }

                }
            }
        }

//        for (int.get() ints : mat) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(ints.get(j) + " ");
//            }
//            System.out.println();
//        }


        return mat.get(0).get(0);
    }

    public static void main(String[] args) {

        System.out.println(collectMax(Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1), Arrays.asList(1, 1, -1))));
    }
}
