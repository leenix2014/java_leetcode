import java.util.*;

/**
 * @author Leen Li
 */
public class Solution752 {

    public static void main(String[] args) {
        System.out.println(new Solution752().openLock(new String[]{"0201","0101","0102","1212","2002"},"0009"));
    }

    Set<String> visited = new HashSet<>();
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        visited.addAll(Arrays.asList(deadends));

        int step = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                String curr = q.poll();
                if(curr.equals(target)){
                    return step;
                }
                for(int j=0;j<curr.length();j++){
                    String moveUp = operate(curr, j, true);
                    String moveDown = operate(curr, j, false);
                    if(!visited.contains(moveUp)) {
                        q.offer(moveUp);
                        visited.add(moveUp);
                    }
                    if(!visited.contains(moveDown)) {
                        q.offer(moveDown);
                        visited.add(moveDown);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String operate(String src, int index, boolean up){
        char[] chars = new char[src.length()];
        for(int i=0;i<src.length();i++){
            if(i != index){
                chars[i] = src.charAt(i);
                continue;
            }
            char c = src.charAt(index);
            if(up){
                if(c == '9'){
                    chars[i] = '0';
                } else {
                    chars[i] = ++c;
                }
            } else {
                if(c == '0'){
                    chars[i] = '9';
                } else {
                    chars[i] = --c;
                }
            }
        }
        return new String(chars);
    }
}
