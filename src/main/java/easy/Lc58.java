package easy;

public class Lc58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("World"));
        System.out.println(lengthOfLastWord("World "));
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord(""));
    }

    public static int lengthOfLastWord(String s) {
        if(s.isEmpty() || s.equals(" ")) return 0;
        int len = s.length(), count = 0;
        for(int i = len - 1; i >= 0 ; i--){
            if(s.charAt(i) == ' '){
                if(count == 0) continue;
                else return count;
            }else count++;
        }
        return count;
    }
}
