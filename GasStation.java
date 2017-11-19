/**
 * Prob: gas-station No: 187
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Notice
 * The solution is guaranteed to be unique.
 * Example
 * Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.
 *
 */

public class Solution {
    /*
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            if (canTravelAround(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean canTravelAround(int startIndex, int[] gas, int[] cost) {
        int size = gas.length;
        int left = 0;
        for (int i = startIndex; i < startIndex + size; i++) {
            left += gas[i%size] - cost[i%size];
            if (left <0) {
                return false;
            }
        }
        return true;
    }
}