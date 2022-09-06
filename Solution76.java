import java.util.HashMap;
import java.util.Map;

/**
 * @author Leen Li
 */
class Solution76 {

    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        for(int i=0;i<t.length();i++){
            addChar(need, t.charAt(i));
        }

        int left=0,right=0;
        Map<Character,Integer> window = new HashMap<>();
        int match = 0;
        int start=0, len=Integer.MAX_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                addChar(window, c);
                if(window.get(c) == need.get(c)){
                    match++;
                }
            }

            while(match==need.size()){
                if(right-left<len){
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d) == need.get(d)){
                        match--;
                    }
                    subChar(window, d);
                }
            }
        }
        return len==Integer.MAX_VALUE?"": s.substring(start, start+len);
    }

    private void addChar(Map<Character,Integer> map, char c){
        if(!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            int count = map.get(c);
            count++;
            map.put(c, count);
        }
    }

    private void subChar(Map<Character,Integer> map, char c){
        if(map.containsKey(c)) {
            int count = map.get(c);
            count--;
            if (count > 0) {
                map.put(c, count);
            } else {
                map.remove(c);
            }
        }
    }
}
