// DFS
// TC: O(k^n) k > avg block size
// SC: O(n)
class Solution {
    List<List<Character>> blocks;
    List<String> result;

    public String[] expand(String s) {
        if(s == null || s.length() == 0) return null;
        blocks = new ArrayList<>();
        result = new ArrayList<>();
        int i = 0;


        while(i < s.length()){
            char c = s.charAt(i);
            List<Character> block = new ArrayList<>();
            if(c == '{'){
                i++;
                while(s.charAt(i) != '}'){
                    if(s.charAt(i) != ','){
                        block.add(s.charAt(i));
                    }
                    i++;
                } 
            }
            else{
                block.add(c);
            }
            Collections.sort(block);
            blocks.add(block);
            i++;
        }
        // StringBuilder sb = new StringBuilder();
        dfs(0, new String(""));
        String[] ans = new String[result.size()];
        i = 0;
        for(String a : result){
            ans[i] = a;
            i++;
        }
        // Arrays.sort(ans);
        return ans;
    }
    public void dfs(int index, String sb){
        if(index >= blocks.size()){
            result.add(sb);
            return;
        }
        List<Character> block = blocks.get(index);
        for(char c : block){
            String temp = sb + c;
            dfs(index + 1, temp);
            // sb = sb.subString(0, sb.length() - 1);
        }
    }
}



// class Solution {
//     List<String> result;
//     public String[] expand(String s) {
//         if(s == null || s.length() == 0) return null;
//         result = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         dfs(s, 0, sb);
//         String[] ans = new String[result.size()];
//         int i = 0;
//         for(String a : result){
//             ans[i] = a;
//             i++;
//         }
//         Arrays.sort(ans);
//         return ans;
//     }
//     public void dfs(String s, int index, StringBuilder sb){
//         if(index >= s.length()){
//             result.add(sb.toString());
//             return;
//         }
//         char c = s.charAt(index);
//         if(c != '{' && c!= '}' && c != ','){
//             sb.append(c);
//             dfs(s, index + 1, sb);
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         else{
//             Queue<Character> q = new LinkedList<>();
//             while(index < s.length() && s.charAt(index) != '}'){
//                 c = s.charAt(index);
//                 if(c != '{' && c!= '}' && c != ','){
//                     q.add(c);
//                 }
//                 index++;
//             }
//             if(index < s.length()){
//                 index++;
//             }
//             while(!q.isEmpty()){
//                 char a = q.poll();
//                 sb.append(a);
//                 dfs(s, index, sb);
//                 sb.deleteCharAt(sb.length() - 1);
//             }
//         }
//     }
// }
