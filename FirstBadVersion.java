/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1< end) {
            int mid = start + (end - start) / 2;
            if(SVNRepo.isBadVersion(mid)) { 
                end = mid;
            } else {
                start = mid;
            }
        }
        //result condition can be simplified assume that there is always a bad version
        if (!SVNRepo.isBadVersion(start) && SVNRepo.isBadVersion(end)) {
            return end;
        }
        if (SVNRepo.isBadVersion(start) && SVNRepo.isBadVersion(end)) {
            return start;
        }
        return -1;
    }
  }
