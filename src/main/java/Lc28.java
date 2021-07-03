

public class Lc28 {
    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        int n = needle.length();
        for (int i = 0; i < haystack.length() - n + 1; i++){
            for(int j = 0; j < n; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
                if(j == n - 1) return i;
            }
        }
        return -1;
    }
}
