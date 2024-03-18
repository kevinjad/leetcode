class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<String>();
        Map<String,Integer> distance = new HashMap<>();
        q.add(startGene);
        distance.put(startGene,0);
        while(!q.isEmpty()){
            String gene = q.poll();
            int d = distance.get(gene)+1;
            for(String s : bank){
                if(distance.getOrDefault(s,Integer.MAX_VALUE) > d){
                    if(isMutated(gene,s)){
                        q.add(s);
                        distance.put(s,d);
                    }
                }
            }
        }
        return distance.getOrDefault(endGene,-1);
    }

    public boolean isMutated(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int change = 0;
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i))change++;
            if(change > 1) return false;
        }
        return change == 1;
    }
}