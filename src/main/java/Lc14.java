public class Lc14 {
    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"abb","ab","a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            /**
             * for (int j = 0; j < strs[i].length(); j++) {
             * */
            for (; j < lcp.length() && j < strs[i].length(); j++) {
                if (lcp.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            lcp = strs[i].substring(0, j);
            if (lcp.equals("")) return "";
        }
        return lcp;
    }
}
