/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9 {
    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(567898765));
    }

    public boolean isPalindrome(int x) {
        if(x==0){//0是第一个回文数
            return true;
        }
        if(x<0 || x%10 == 0){//负数和个位数为0的都不是回文数
            return false;
        }

        StringBuilder sb = new StringBuilder();
        while(x>0){
            sb.append(x%10);
            x = x/10;
        }
        byte[] digits = sb.toString().getBytes();

        int n = digits.length;
        for(int i=0;i<n/2;i++){
            if(digits[i] != digits[n-1-i]){
                return false;
            }
        }
        return true;
    }
}
