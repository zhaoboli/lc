/**
 * Prob: product-of-array-exclude-itself No: 50
 * Given an integers array A.
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 * For A = [1, 2, 3], return [6, 3, 2].
 *
 */
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     * O(n**2)
     * 思路：
     * 暴力解法算某个位置exlude product, 复杂度O(n**2)
     * 明显看出来有重复计算， 因此可把它分成左右两部分来计算
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        for (int i = 0; i < A.size(); i++) {
            result.add(product(A, i));
        }
        return result;
    }

    private long product(ArrayList<Integer> A, int i) {
        int index = 0;
        long out = 1;
        while (index < A.size()) {
            if (index != i) {
                out = out * A[index];                
            }
            index++;
        }
        return out;
    }

    //O(n) more precise 2n; basically devide each product into left and right.
    public ArrayList<Long> produtExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        long product = 1;
        result.add(product);
        for (int i = 1; i < A.size(); i++) {
            product = product * A.get(i - 1);
            result.add(product);
        }

        product = 1;
        for (int j = A.size() - 2; j >= 0; j--) {
            product = product * A.get(j + 1); 
            result.set(j, product * result.get(j));
        }
        return result;
    }

}
