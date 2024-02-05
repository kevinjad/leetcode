class Solution {
    public String multiply(String nums1, String nums2) {
        int n1 = nums1.length();
        int n2 = nums2.length();

        int[] product = new int[n1+n2];
        for(int i = n1-1;i>=0;i--){
            for(int j = n2-1;j>=0;j--){
                int a = nums1.charAt(i) -'0';
                int b = nums2.charAt(j)-'0';
                product[i+j+1] += a*b;
            }
        }

        //calculate carry
        int carry = 0;
        for(int i = product.length-1;i>=0;i--){
            int temp = (product[i]+carry)%10;
            carry = (product[i]+carry)/10;
            product[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int p : product){
            sb.append(p);
        }
        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}