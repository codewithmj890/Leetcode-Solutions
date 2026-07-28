class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Let's test the number 43261596 from the LeetCode example
        int testInput = 43261596;
        
        // Java's toBinaryString doesn't print leading zeros, so we format it beautifully:
        String originalBinary = String.format("%32s", Integer.toBinaryString(testInput)).replace(' ', '0');
        System.out.println("Original Binary: " + originalBinary);
        
        // Run the algorithm
        int result = solver.reverseBits(testInput);
        
        // Print the result
        String reversedBinary = String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0');
        System.out.println("Reversed Binary: " + reversedBinary);
        
        System.out.println("\nResulting Integer: " + result);
    }
}

class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
}