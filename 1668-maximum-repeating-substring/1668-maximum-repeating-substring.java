class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int cnt = 0;
        while(sequence.contains(sb)){
            cnt++;
            sb.append(word);
        }
        return cnt;
    }
}