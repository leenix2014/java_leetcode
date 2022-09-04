import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = new int[]{3,5,7,9,11,13};
        Arrays.sort(a);

        for(int i=0;i<17;i++){
            System.out.println(Arrays.binarySearch(a, i));
        }
    }
}
