public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i <= j) {
            if (!isvalid(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isvalid(s.charAt(j))) {
                j--;
                continue;
            }
            if(
                Character.toLowerCase(s.charAt(i)) == 
                Character.toLowerCase(s.charAt(j))
                ) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}