package misc;

public class StrRotation {

    boolean isRotatedString(String s1, String s2) {

        String concatedStr = s1.concat(s1);
        return concatedStr.contains(s2);

        
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2= "deabc";
    }

    // abcde + abcde

    // hashtable -> O(1)
    // Arvind -> hashIndex //
    // array ->
    //a2b2
    // compression
    //
}
