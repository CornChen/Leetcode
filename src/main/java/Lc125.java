

public class Lc125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("rac a car"));
    }

    public static boolean isPalindrome(String s) {
        if(s.length() < 2)  return true;
        int i = 0, j = s.length() - 1;
//        char[] schar = s.toCharArray();
        char[] schar = s.toUpperCase().toCharArray();
        while(i < j){
            while(i < schar.length && !Character.isLetterOrDigit(schar[i])) i++;
            while(j > 0 && !Character.isLetterOrDigit(schar[j])) j--;
            if(i >= schar.length || j < 0 || i > j) return true;
//            else if(schar[i] == schar[j] ||
//                (char)((int)schar[i] - 32) == schar[j] ||
//                (char)((int)schar[i] + 32) == schar[j]){    //数字0和字母P刚好满足此条件，未考虑此特殊情况
            else if(schar[i] == schar[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
