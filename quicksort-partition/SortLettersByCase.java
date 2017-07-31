/**
 * Prob: sort-letters-by-case No: 49
 * Given a string which contains only letters. Sort it by lower case first and upper case second
 * It's NOT necessary to keep the original order of lower-case letters and upper case letters.
 */
public class Solution {
    /**
     * @param chars: The letter array you should sort by case
     * @return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int left = 0;
        int right = chars.length; 
        while (left <= right) {
            //Character.isUpperCase
            while (left <= right && chars[left] >= 'a') {
                left++;
            }
            while (left <= right && chars[right] < 'a') {
                right--;
            }
            if (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
    }
}
