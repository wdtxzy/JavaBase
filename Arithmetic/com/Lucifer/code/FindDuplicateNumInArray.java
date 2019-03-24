import java.util.HashMap;
import java.util.Random;

/**
 * @author : wangdi
 * @time : creat in 2019/3/20 22:10
 * 给定一个数组，如何搜索重复元素？
 */
public class FindDuplicateNumInArray {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int tmp = random.nextInt(99) + 1;
            arr[i] = tmp;
        }
        FindDuplicateNumInArray findDuplicateNumInArray = new FindDuplicateNumInArray();
        findDuplicateNumInArray.findDuplicateNum(arr);
    }

    private void findDuplicateNum(int[] array) {
        HashMap map = new HashMap();
        int i = 0;
        while (!map.containsKey(array[i])) {
            map.put(array[i], 0);
            i++;
        }
        System.out.println(i);
        System.out.println(array[i]);
    }
}
