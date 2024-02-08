class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        if(beginWord.equals(endWord)) return 0;
        if(!words.contains(endWord)) return 0;
        int change = 0;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int n = q.size();
            change++;
            for(int i = 0;i<n;i++){
                String word = q.poll();
                if(word.equals(endWord)) return change;
                for(int j = 0; j < word.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if(words.contains(str) && !visited.contains(str)){
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
        }
        return 0;
    }
}