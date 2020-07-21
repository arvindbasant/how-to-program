package codility;


//class GFG {
//
//    static int printRLE(String s, int k) {
//        StringBuilder str = new StringBuilder();
//        int skipStartIndex = -1;
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) != s.charAt(i + 1)) {
//                if (i + k + 1 < s.length()){
//                    skipStartIndex = i + 1;
//                    if (s.charAt(i) == s.charAt(i + k + 1))
//                        break;;
//
//                }
//
//            }
//        }
//
//        if(skipStartIndex != -1)
//            s = s.substring(0, skipStartIndex) + s.substring(skipStartIndex + k);
//
//
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            // Counting occurrences of s[i]
//            int count = 1;
//            while (i + 1 < s.length()
//                    && s.charAt(i)
//                    == s.charAt(i + 1)) {
//                i++;
//                count++;
//            }
//            if(count > 1)
//                result.append(count).append(s.charAt(i));
//            else
//                result.append(s.charAt(i));
//        }
//
//        return result.length();
//    }
//
//    // Driver code
//    public static void main(String args[]) {
//        System.out.println(printRLE("ABCDDDEFG", 2));
//        System.out.println(printRLE("AAAAAAAAAAABXXAAAAAAAAAA", 3));
//        System.out.println(printRLE("ABBBCCDDCCC", 3));
//
//
//    }
//}

//

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    // Returns the number of we
// can split the string
    static int countWays(String s) {
        int count[] = new int[2];


        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;


        int aMaxArrangements = count[0] / 3;
        int bDistribution = 1;
        for (int i = 1; i <= count[1]; i++) {
            bDistribution *= i;
        }

        if (aMaxArrangements == 0)
            return bDistribution;
        return aMaxArrangements * bDistribution;
    }

    // Driver Code
    public static void main(String ags[]) {
        String s = "babaa";
        System.out.println(countWays(s));
    }
}