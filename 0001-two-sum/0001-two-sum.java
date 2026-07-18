import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Main{
    public static void main(String[] args){
        Solution solver = new Solution();
        int[] testArray = {2, 7, 11, 15};
        int target = 9;
        int[] answer = solver.twoSum(testArray, target);
        System.out.println("The indices are " + Arrays.toString(answer));
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if (seen.containsKey(complement)){
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);

        }
        return new int[]{}; 
    }
}