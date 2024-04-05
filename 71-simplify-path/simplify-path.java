class Solution {
   public String simplifyPath(String path) {
        String[] patharray = path.split("/");
        Stack<String> pathStack = new Stack<>();
        for(String s : patharray){
            if("/".equals(s) || ".".equals(s) || s.isEmpty()){
                continue;
            } else if ("..".equals(s)){
                if(!pathStack.isEmpty()) pathStack.pop();
            } else{
                pathStack.add(s);
            }
        }
        String result = "";
        for(String s : pathStack){
            result = result+"/"+s;
        }
        return result.isEmpty() ? "/" : result;
    }
}