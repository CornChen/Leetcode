import java.nio.file.attribute.UserPrincipalLookupService;

public class Lc38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
        System.out.println(countAndSay(9));
        System.out.println(countAndSay(10));
    }
    public static String countAndSay(int n) {
        if(n == 0) return "";
        if(n == 1) return "1";
        int count = 1;
        String pre = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < pre.length()-1; i++){
        for(int i = 0; i < pre.length(); i++){
//            if(pre.charAt(i) == pre.charAt(i+1)) count++;
            if(i < pre.length()-1 && pre.charAt(i) == pre.charAt(i+1)) count++;
            else {
                sb.append(count).append(pre.charAt(i));
//              未重置count值
                count = 1;
            }
        }
        return sb.toString();
    }
}
