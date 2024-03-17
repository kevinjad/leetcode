class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 3 2 1 5 8 2 1 2 5 7
        Stack<Integer> s = new Stack<>();
        s.add(0);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i<nums2.length;i++){
            while(!s.isEmpty() && nums2[s.peek()] < nums2[i]){
                int ind = s.pop();
                map.put(nums2[ind], nums2[i]);
            }
            s.add(i);
        }
        while(!s.isEmpty()){
            map.put(nums2[s.pop()],-1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}