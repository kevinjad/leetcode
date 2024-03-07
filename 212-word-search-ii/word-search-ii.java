class Solution {
   public List<String> findWords(char[][] board, String[] words) {
        TrieElement trie = buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();
        for(int i = 0;i< board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                findWordsBackTrack(board, trie, visited, result, i, j);
            }
        }
        return result.stream().toList();
    }

    private void findWordsBackTrack(char[][] board, TrieElement trie, boolean[][] visited, Set<String> result, int i, int j) {
        if(i < 0 || j < 0) return;
        if(i>= board.length || j >= board[0].length) return;
        if(visited[i][j]) return;
        
        char c = board[i][j];
        if(trie.child[c-'a'] == null) return;
        visited[i][j] = true;
        if(trie.child[c-'a'].word != null) {
            result.add(trie.child[c-'a'].word);
        }
        findWordsBackTrack(board, trie.child[c-'a'], visited, result, i-1, j);
        findWordsBackTrack(board, trie.child[c-'a'], visited, result, i, j-1);
        findWordsBackTrack(board, trie.child[c-'a'], visited, result, i+1, j);
        findWordsBackTrack(board, trie.child[c-'a'], visited, result, i, j+1);
        visited[i][j] = false;
    }

    private TrieElement buildTrie(String[] words) {
        TrieElement root = new TrieElement();
        for(String word : words){
            TrieElement temp = root;
            for(char c : word.toCharArray()){
                if(temp.child[c-'a'] == null){
                    temp.child[c-'a'] = new TrieElement();
                }
                temp = temp.child[c-'a'];
            }
            temp.word = word;
        }
        return root;
    }
}

class TrieElement {
    String word;
    TrieElement[] child = new TrieElement[26];

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public TrieElement[] getChild() {
        return child;
    }

    public void setChild(TrieElement[] child) {
        this.child = child;
    }
}