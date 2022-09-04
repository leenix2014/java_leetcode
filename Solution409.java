import java.util.HashMap;
import java.util.Map;

class Solution409 {

    public static void main(String[] args) {
        System.out.println(new Solution409().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        Map<Character,Integer> count = new HashMap();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            count.put(c, count.getOrDefault(c,0)+1);
        }

        int ans = 0;
        for(Map.Entry<Character, Integer> entry : count.entrySet()){
            int c = entry.getValue();
            if (c%2==0){
                ans += c;
            } else {//数量为奇数
                ans += c/2 *2;
                if(ans%2==0){//ans为偶数
                    ans++;//ans成为奇数后，不会再进此if
                }
            }
        }
        return ans;
    }
}
