import java.util.Set;
import java.util.HashSet; 

class Main{
    public static void main(String[] args){
        Solution solver = new Solution();
        int[] testArray = {100, 4, 200, 1, 3, 2};
        int answer = solver.longestConsecutive(testArray);
        
        System.out.println("The longest consecutive sequence length is " + answer);
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            // Only start counting if 'num' is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}