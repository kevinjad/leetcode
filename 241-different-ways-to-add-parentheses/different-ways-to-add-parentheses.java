class Solution {

    Map<String, List<Integer>> mem = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(mem.get(expression) != null) return mem.get(expression);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c == '*' || c == '+' || c == '-'){
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i+1);

                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);

                for(Integer p1 : part1Res) {
                    for(Integer p2 : part2Res) {
                        int possibleAns = 0;
                        if(c == '-') possibleAns = p1-p2;
                        if(c == '*') possibleAns = p1*p2;
                        if(c == '+') possibleAns = p1+p2;
                        res.add(possibleAns);
                    }
                }
            }
        }
        if(res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        mem.put(expression, res);
        return res;
    }
}