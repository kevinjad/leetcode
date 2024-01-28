class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length-1;
        do{
            digits[i] += carry;
            carry = 0;
            if(digits[i] >= 10){
                carry = digits[i]/10;
                digits[i] = digits[i]%10;
            }
            i--;
        }while(carry != 0 && i >= 0);
        if(carry != 0){
            int[] result = new int[digits.length+1];
            result[0] = carry;
            int j = 1;
            for(int d : digits) {
                result[j] = d;
                j++;
            }
            return result;
        }
        return digits;
    }
}