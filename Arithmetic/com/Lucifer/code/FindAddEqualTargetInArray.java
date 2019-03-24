import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : wangdi
 * @time : creat in 2019/3/20 23:46
 * 给定一个数值，如何搜索整数数组中加和为该数值的成对元素？
 */
public class FindAddEqualTargetInArray {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int tmp = random.nextInt(99) + 1;
            arr[i] = tmp;
        }
        FindAddEqualTargetInArray findAddEqualTargetInArray = new FindAddEqualTargetInArray();
        findAddEqualTargetInArray.findAddEqualTarget(arr, 10);
    }

    public void findAddEqualTarget(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 0);
        }
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = target - arr[i];
            if (map.containsKey(tmp)) {
                result.put(tmp, arr[i]);
            }
        }
        for (Map.Entry entry : result.entrySet()) {
            System.out.println("couple is:" + entry.getKey() + "," + entry.getValue());
        }
    }
}
