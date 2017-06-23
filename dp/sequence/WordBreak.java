public class Solution {
  import com.sun.deploy.util.StringUtils;

import java.util.Set;

/**
 * Created by zhaobo on 5/22/17.
 */
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    //DFS Search, will timeout
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s == null || dict == null) {
            return false;
        }
        return search(s, 0, dict);
    }

    private boolean search(String s, int start, Set<String> dict) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start; i <= s.length(); i++) {
            boolean res = false;
            if(s.substring(start, i).isEmpty()) {
                continue;
            }
            if(dict.contains(s.substring(start, i)) ) {
                res = search(s, i, dict);
            }
            if (res) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakDP(String s, Set<String> dict) {
        // write your code here
        if (s == null) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        int max = getWordMaxLen(dict);

        //here dp[0] perfect cut,
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            //here to consider the last word length, verse start counting from left to right, cases
            //like "aaaab", ["a", "b"]
            //as the goal is to ensure that substring new word doesn't go beyond max len
            for(int lastWordLength = 1; lastWordLength <= i && lastWordLength <= max; lastWordLength++)  {
                if (!dp[i - lastWordLength]) {
                    continue;
                }
                String str = s.substring(i - lastWordLength, i);
                if(dict.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    private int getWordMaxLen(Set<String> dict) {
        int max = 0;
        for(String word:dict) {
            if(word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }
}
}
