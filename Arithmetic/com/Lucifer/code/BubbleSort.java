/**
 * @author : wangdi
 * @time : creat in 2019/3/21 19:29
 * 快速排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 5;
        array[2] = 4;
        array[3] = 123;
        array[4] = 14;
        array[5] = 15;
        array[6] = 17;
        array[7] = 1234;
        array[8] = 34;
        array[9] = 235;
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (int a : array) {
            System.out.println(a);
        }
    }
}
