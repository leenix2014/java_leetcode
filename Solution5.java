public class Solution5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length()==0){
            return "";
        }

        int maxLen = 0;
        String ans = "";
        for(int i=0;i<s.length();i++){
            String oddPalindrome = expandAroundCenter(s, i, i);//以i位置为中心，找到最长回文串
            int len1 = oddPalindrome.length();
            if(len1>maxLen){
                maxLen = len1;
                ans = oddPalindrome;
            }
            if(i+1>=s.length()){
                break;
            }
            String evenPalindrome = expandAroundCenter(s, i, i+1);//以i位置和i+1位置为中心，找到最长回文串
            int len2 = evenPalindrome.length();
            if (len2>maxLen){
                maxLen = len2;
                ans = evenPalindrome;
            }
        }
        return ans;
    }

    //返回i位置(left=right时)为中心的最大回文字符串，0<=i<s.length()
    //或返回i与i+1(right=left+1时)为中心的最大回文字符串，0<=i<i+1<s.length()
    private String expandAroundCenter(String s, int left, int right){
        if(s.charAt(left)!=s.charAt(right)){
            return "";
        }
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //恢复原坐标
        left++;
        right--;
        return s.substring(left, right+1);
    }

}
