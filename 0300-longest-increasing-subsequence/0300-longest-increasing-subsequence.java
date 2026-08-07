class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; // tails[i] = smallest possible tail of an increasing subsequence of length i+1
        int size = 0; // current length of the LIS found so far

        for (int num : nums) {
            int lo = 0, hi = size;
            // binary search: find leftmost index where tails[idx] >= num
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = num; // overwrite (or extend if lo == size)
            if (lo == size) size++;
        }

        return size;
    }
}