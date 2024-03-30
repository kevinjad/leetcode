class Solution {
   public String intToRoman(int num) {
       LinkedHashMap<Integer,String> m = new LinkedHashMap<>();
       m.put(1000,"M");
       m.put(900,"CM");
        m.put(500,"D");
        m.put(400,"CD");
        m.put(100,"C");
        m.put(90,"XC");
        m.put(50,"L");
        m.put(40,"XL");
        m.put(10,"X");
        m.put(9,"IX");
        m.put(5,"V");
        m.put(4,"IV");
        m.put(1,"I");
        String result = "";
        while(num>0){
            for(int x : m.keySet()){
                if(num >= x){
                    result += m.get(x);
                    num -= x;
                    break;
                }
            }
        }
        return result;
    }
}