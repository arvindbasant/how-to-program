package dynamicProgramming;

public class GoldMine {
    private static int getMaxGold(int[][] gold) {
        int row = gold.length;
        int col = gold[0].length;
        int[][] goldTable = new int[row][col];

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (j == 0) {
                    goldTable[i][j] = gold[i][j];
                } else {
                    int prev_sum = goldTable[i][j - 1] + gold[i][j];
                    int prev_up_sum = i != 0 ? goldTable[i - 1][j - 1] + gold[i][j] : 0;
                    int prev_down_sum = i != row - 1 ? goldTable[i + 1][j - 1] + gold[i][j] : 0;
                    goldTable[i][j] = Math.max(prev_sum, Math.max(prev_up_sum, prev_down_sum));
                }
            }
        }
        int maxGoldCollected = 0;
        for (int i = 0; i < row; i++) {
            maxGoldCollected = Math.max(maxGoldCollected, goldTable[i][col - 1]);
        }
        return maxGoldCollected;
    }

    public static void main(String[] args) {
        int[][] gold = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2},
        };
        System.out.println(getMaxGold(gold));
    }
}
