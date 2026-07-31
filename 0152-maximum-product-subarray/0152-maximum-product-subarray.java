class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // if current number is negative, swap max and min
            if (curr < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(curr, maxEndingHere * curr);
            minEndingHere = Math.min(curr, minEndingHere * curr);

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}