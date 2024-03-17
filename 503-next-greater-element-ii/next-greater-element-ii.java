class Solution {
    public int[] nextGreaterElements(int[] nums2) {
        // 3 2 1 5 8 2 1 2 5 7
        Stack<Integer> s = new Stack<>();
        s.add(0);
        int[] result = new int[nums2.length];
        Arrays.fill(result,-1);
        for(int i = 1; i<nums2.length;i++){
            while(!s.isEmpty() && nums2[s.peek()] < nums2[i]){
                int ind = s.pop();
                result[ind] = nums2[i];
            }
            s.add(i);
        }
        for(int i = 0; i<nums2.length;i++){
            while(!s.isEmpty() && nums2[s.peek()] < nums2[i]){
                int ind = s.pop();
                result[ind] = nums2[i];
            }
            s.add(i);
        }
        return result;        
    }
}