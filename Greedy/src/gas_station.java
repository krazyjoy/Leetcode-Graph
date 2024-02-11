/*
    134. https://leetcode.com/problems/gas-station/description/

    brainstorm:
    - can start from any station, requires to travel all n stations without running out of gas
    - use surplus concept to think if it is possible to drive from i to i+1, with surplus = gas[i] - cost[i]
        - if impossible, we should start from the next index, until all starting station has been tried
 */

public class gas_station {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
        int[] gas2 = new int[]{2,3,4};
        int[] cost2 = new int[]{3,4,3};
        System.out.println(canCompleteCircuit(gas2, cost2));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int n = gas.length;
        int total_surplus=0;
        int surplus=0;
        int start=0;

        for(int i=0; i<n; i++){
            total_surplus += gas[i]-cost[i];
            surplus += gas[i]-cost[i];
            if(surplus < 0){
                surplus = 0;
                start =i + 1;
            }
        }
        return (total_surplus < 0)?-1:start;
    }
}
