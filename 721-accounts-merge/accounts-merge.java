class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for(int i = 0; i< accounts.size(); i++) parent[i] = i;
        Map<String, Integer> emailToAccount = new HashMap<>();
        for(int i = 0; i< accounts.size(); i++){
            for(int j = 1; j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(emailToAccount.containsKey(email)){
                    int accountWhichAlreadyHasEmail = emailToAccount.get(email);
                    accountWhichAlreadyHasEmail = findParent(parent, accountWhichAlreadyHasEmail);
                    int parentOfCurrentAccount = findParent(parent, i);
                    if(parentOfCurrentAccount != accountWhichAlreadyHasEmail){
                        parent[parentOfCurrentAccount] = accountWhichAlreadyHasEmail;
                    }
                } else{
                    emailToAccount.put(email, i);
                }
            }
        }
        
        Map<Integer,TreeSet<String>> accountToEmail = new HashMap<>(); 
        for(int i = 0;i<accounts.size();i++){
            int parentAcc = findParent(parent,i);
            if(accountToEmail.get(parentAcc) == null) accountToEmail.put(parentAcc, new TreeSet<>());
            for(int j = 1;j<accounts.get(i).size();j++){
                accountToEmail.get(parentAcc).add(accounts.get(i).get(j));
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> e : accountToEmail.entrySet()){
            List<String> list = new ArrayList<>();
            list.add(accounts.get(e.getKey()).get(0));
            for(String email : e.getValue()){
                list.add(email);
            }
            answer.add(list);
        }
        return answer;
    }

    public int findParent(int[] parent, int i){
        if(i == parent[i]) return i;
        return findParent(parent, parent[i]);
    }
}