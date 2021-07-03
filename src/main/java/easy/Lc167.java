package easy;

public class Lc167 {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,2,3,4,5,6,7,8}, 12));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
         /** NullPoint!!!
        while(numbers[i] + numbers[j] != target){
            if(numbers[i] + numbers[j] > target) j--;
            else i++;
        }
        return new int[]{i+1, j+1};
         */
         while (i < j){
             int sum = numbers[i] + numbers[j];
             if(sum == target) return new int[]{i+1,j+1};
             else if(sum < target) i++;
             else j--;
         }
         return null;
    }
}