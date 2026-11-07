class WordDictionary {

    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0,  root);
    }

    private boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child : node.children.values()){
                if(dfs(word, index + 1, child)){
                    return true;
                }
            }
            return false;
        }

        if(!node.children.containsKey(c)){
            return false;
        }
        return dfs(word, index + 1, node.children.get(c));
    }
}
