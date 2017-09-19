public class Solution {
	//version 1
    public String reverseVowels(String s) {
        int[] position = new int[s.length()];
        int ct = 0;
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');

        for (int i = 0; i < s.length(); i++) {
        	if (vowel.contains(s.charAt(i))) {
        		position[ct++] = i;
        	}
        }

        int[] ans = s.toCharArray();
        for (int i = 0; i < ct; i++) {
        	ans[postion[i]] = s.charAt(position[ct - 1 - i]);
        }
        return String.valueOf(ans);
    }
    //version 2 => 2 pointer
}
