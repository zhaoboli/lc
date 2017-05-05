class Solution {
	/**
	hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE
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
            ans = (ans * 33 + key[i]) % HASH_SIZE;
        }
        return (int)ans;
    }
};