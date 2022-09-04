public class Solution11 {

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int n = height.length;
        if(n<=0){
            return 0;
        }
        int left=0,right=n-1;
        int maxArea = 0;
        while(left<right){
            int currArea = Math.min(height[left], height[right])*(right-left);
            maxArea = Math.max(maxArea, currArea);
            if(height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
