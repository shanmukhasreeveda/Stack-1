// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialize Result and Stack: Create an array result to store the number of days until a warmer temperature and a stack s to track the indices of temperatures.
//Iterate and Compare: For each day, compare the current temperature with the temperature of the day at the top of the stack. If the current temperature is higher, calculate the difference in days and store it in result.
//Update Stack: Push the current day's index onto the stack for future comparisons.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[]{};
        }
        int n = temperatures .length;
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i =0; i< n; i++){
            while(!s.isEmpty()&& temperatures[i] > temperatures[s.peek()]){
                int popped = s.pop();
                result[popped] = i - popped;
            }
            s.push(i);
        }
        return result;
    }
}
