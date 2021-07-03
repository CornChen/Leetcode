/** Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class Lc168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(676));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber >  26){
            if(columnNumber % 26 != 0){
                sb.append((char)('A' + columnNumber%26 - 1));
                columnNumber /= 26;
            // 忽略进位情况，此题虽为26进制，但与10进制有所不同，由于从A开头，所以26时为Z，而不是A@
            } else {
                sb.append('Z');
                columnNumber /= 26;
                columnNumber--;
            }
        }
        sb.append((char)('A' + columnNumber - 1));
        return sb.reverse().toString();
    }
}
