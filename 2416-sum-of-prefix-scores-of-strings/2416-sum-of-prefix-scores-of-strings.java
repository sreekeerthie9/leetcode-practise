class trienode{
    trienode[] next = new trienode[26];
    int cnt = 0;
}
class Solution {
    trienode root = new trienode();
    void insert(String word){
        trienode node = root;
        for(char c : word.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a'] = new trienode();
            }
            node.next[c-'a'].cnt++;
            node = node.next[c-'a'];
        }
    }
    int count(String s){
        int ans = 0;
        trienode n = root;
        for(char c : s.toCharArray()){
            ans+=n.next[c-'a'].cnt;
            n = n.next[c-'a'];
        }
        return ans;
    }
    public int[] sumPrefixScores(String[] words) {
        for(String str : words){
            insert(str);
        }
        int res[] = new int[words.length];
        int i=0;
        for(String str : words){
            res[i++] = count(str);
        }
        return res;
    }
}