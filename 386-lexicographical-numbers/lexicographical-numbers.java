class Solution {
    public List<Integer> lexicalOrder(int n) {
        Child root = new Child();
        for(int i = 1;i<=n;i++){
            Child r = root;
            String temp = Integer.toString(i);
            String cc="";
            for(char c : temp.toCharArray()){
                cc += String.valueOf(c);
                int t = c-'0';
                if(r.children[t] == null) r.children[t] = new Child();
                r.children[t].val = Integer.parseInt(cc);
                r = r.children[t];
            }
            r.isNum = true;
        }
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(Child root, List<Integer> ans){
        if(root == null) return;
        if(root.isNum){
            ans.add(root.val);
        }
        for(Child c : root.children){
            dfs(c, ans);
        }
    }
}

class Child {
    boolean isNum;
    int val;
    Child[] children;

    public Child() {
        children = new Child[10];
    }
}