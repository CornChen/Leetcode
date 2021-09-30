package medium;

/** 字符串相乘
 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"

 示例2:
 输入: num1 = "123", num2 = "456"
 输出: "56088"

 说明：
 num1和num2的长度小于110。
 num1 和num2 只包含数字0-9。
 num1 和num2均不以零开头，除非是数字 0 本身。
 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Lc43 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int sum = res[i+j+1] + n1 * n2;
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if(i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
