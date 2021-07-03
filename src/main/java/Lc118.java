import java.util.ArrayList;
import java.util.List;

public class Lc118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

//    对于List<List<Integer>>的写法不熟，参照法二   https://leetcode-cn.com/problems/pascals-triangle/solution/javadi-gui-dong-tai-gui-hua-by-jeromememory/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
//        res.get(0).add(new ArrayList<Integer>(1);
        res.add(new ArrayList<Integer>());
        res.get(0).add(1);
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i - 1);
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
