public class InClass_12_8_LeetCode {
    public static void main(String[] args) {
        String[] str1 = {"flower","flow","flight"};
        String[] str2 = {"dog","racecar","car"};

        Solution sol = new Solution();

        System.out.printf("\nstr1: %s", sol.longestCommonPrefix(str1));
        System.out.printf("\nstr2: %s", sol.longestCommonPrefix(str2));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int e = 1;
        StringBuilder out = new StringBuilder(strs[0].charAt(0));
        for(int i=1; i<strs.length; i++) {
            System.out.printf("\nout: %s", out);
            if(out.charAt(e)==strs[i].charAt(e)) {
                out.append(strs[0].charAt(e));
                e++;
            } else {
                return out.toString();
            }
        }
        return "none";
    }
}