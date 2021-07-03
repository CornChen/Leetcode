public class Lc67 {

    public static void main(String[] args) {
        System.out.println(addBinary("101", "11"));
    }

    public static String  addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0, sum, i = a.length()-1, j = b.length() - 1;
        // for(int i = a.length()-1, j = b.length() - 1; i >= 0, j >= 0; i--, j--){
        for(; i >= 0||j >= 0; i--, j--){
            // 忘记重置
            sum = ca;
            // sum += a.charAt(i)-'0'>0 ?  a.charAt(i)-'0' : 0;
            // sum += b.charAt(i)-'0'>0 ?  b.charAt(i)-'0' : 0;
            sum += i>=0 ?  a.charAt(i)-'0' : 0;
            sum += j>=0 ?  b.charAt(j)-'0' : 0;
            ca = sum/2;
            sb.append(sum%2);
        }
        if(ca != 0) sb.append(ca);
        return sb.reverse().toString();
    }
}
