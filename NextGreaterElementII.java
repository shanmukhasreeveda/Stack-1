// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialize Result and Stack: Create an array result to store the next greater element for each index, initialize all elements to -1, and use a stack s to keep track of indices.
//Iterate and Compare (Circular Array): Loop through the array twice (to handle the circular nature), and for each element, compare it with the element at the index stored at the top of the stack. If the current element is greater, update result for the index and remove it from the stack.
//Update Stack: Push the current index onto the stack if within the array's length to keep track of indices needing a next greater element.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        int [] result = new int[n];
        Stack<Integer> s = new Stack<>();

        Arrays.fill(result, -1);
        for(int i =0; i< 2*n; i++){ // circular array worst case O(2n)
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]){
                int popped = s.pop();
                result[popped] = nums[i % n];
            }
            if(!s.isEmpty() && (i % n == s.peek())){
                break;
            }
            if(i < n){
                s.push(i);
            }
        }

        return result;
    }
}