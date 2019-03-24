/**
 * @author : wangdi
 * @time : creat in 2019/3/21 00:06
 * 如何使用 Java 反转一个数组？
 */
public class RevertArray {
    public static void main(String[] args) {

    }

    public int[] revert(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
