class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: Number 11 (Binary: 1011) - Expect 3
        int test1 = 11;
        System.out.println("Binary of " + test1 + ": " + Integer.toBinaryString(test1));
        System.out.println("Hamming Weight: " + solver.hammingWeight(test1));
        
        System.out.println("-------------------");
        
        // Test 2: Number 128 (Binary: 10000000) - Expect 1
        int test2 = 128;
        System.out.println("Binary of " + test2 + ": " + Integer.toBinaryString(test2));
        System.out.println("Hamming Weight: " + solver.hammingWeight(test2));
        
        System.out.println("-------------------");
        
        // Test 3: A negative number (Binary: 11111111111111111111111111111101) - Expect 31
        int test3 = -3;
        System.out.println("Binary of " + test3 + ": " + Integer.toBinaryString(test3));
        System.out.println("Hamming Weight: " + solver.hammingWeight(test3));
    }
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}