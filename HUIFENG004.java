import java.util.Arrays;

public class HUIFENG004 {

    public static int heightPyramid(int[] arr) {
        int answer = 0;
        // Write your code here
        int len = arr.length;// n(n+1)/2=m --> n = [-1 + sqrt(1+8m)]/2
        int maxHeight = (int)(-1 + Math.sqrt(1+8*len))/2;//向下取整

        Arrays.sort(arr);//排序，排序后最小的在最上层，次层2块，一直往下排。最后一层不足n块，则不算此层。

        int levelSize = 1;
        for(int i=0;i<maxHeight;i++){
            len -= levelSize;
            levelSize++;
            answer++;
            if(len < 0){
                answer--;
                break;
            }
        }


//        return Math.min(answer, maxHeight);
        return maxHeight;
    }

    public static void main(String[] args) {
        int result = heightPyramid(new int[]{40,100,20,30,1,1,1,1,1});
        System.out.print(result);
    }
}
