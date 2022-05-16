package codility;

public class BinaryGap {

    public int getBinaryGap(int num) {
        try {
            String binaryStr = Integer.toBinaryString(num);
            System.out.println(binaryStr);
            int max = 0;
            int current = 0;
            for (int i = 0; i < binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    current++;
                } else {
                    max = Math.max(max, current);
                    current = 0;
                }
            }
            return max;
        } catch (Exception ignored) {
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.getBinaryGap(529));
    }
}
