/**
 * Prob: reverse-integer No: 413
 * 思路：
 * n%10 得到最右的元素　n/10　就除掉最后一位
 * 注意如果只用字符串交换的话，对100这样的数就不好
 */
public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        int reversed = 0;

        while (n != 0) {
            int temp = reversed * 10 + n % 10;
            if (temp / 10 != reversed) {
                reversed = 0;
                break;
            }
            reversed = temp;
            n = n / 10;
        }
        return reversed;
    }
}
