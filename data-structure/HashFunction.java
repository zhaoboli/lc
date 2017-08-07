class Solution {
	/**
    * Prob: hash-function No: 128
	* hashcode("abcd") = (ascii(a) * 33 3 + ascii(b) * 33 2 + ascii(c) *33 + ascii(d)) % HASH_SIZE 
    * = (97* 33 3 + 98 * 33 2 + 99 * 33 +100) % HASH_SIZE
    * = 3595978 % HASH_SIZE
    *
	*/
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        int len = key.length;
        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (ans * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)ans;
    }
};
