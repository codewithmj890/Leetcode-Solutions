import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: The classic LeetCode example
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Target " + target1 + " with " + Arrays.toString(candidates1));
        System.out.println("Result: " + solver.combinationSum(candidates1, target1));
        // Expected: [[2, 2, 3], [7]]
        
        System.out.println("-------------------");
        
        // Test 2: The example we traced
        int[] candidates2 = {2, 3};
        int target2 = 5;
        System.out.println("Target " + target2 + " with " + Arrays.toString(candidates2));
        System.out.println("Result: " + solver.combinationSum(candidates2, target2));
        // Expected: [[2, 3]]
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));   
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;    

            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current, result); 
            current.remove(current.size() - 1);       
        }
    }
}