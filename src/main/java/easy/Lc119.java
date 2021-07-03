package easy;

import java.util.ArrayList;
import java.util.List;

public class Lc119 {
    public static void main(String[] args) {
        System.out.println(getRow(0));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
//        for(int i = 1; i < rowIndex; i++){
        for(int i = 1; i <= rowIndex; i++){
//            row.add(row.get(i-1) * (rowIndex - i + 1) / i);
            row.add((int)((long) row.get(i-1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
