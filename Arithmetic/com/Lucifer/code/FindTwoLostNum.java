import java.util.HashMap;
import java.util.Random;

/**
 * @author : wangdi
 * @time : creat in 2019/3/20 21:10
 * 在一个元素为 1 到 100 的整数数组中，如何搜索缺失元素？
 */
public class FindTwoLostNum {

    public static void main(String[] args) {
        int[] arr = new int[100];
        HashMap map = new HashMap();
        Random random = new Random();
        for (int i = 0; i < 98; i++) {
            int tmp = random.nextInt(99) + 1;
            while (map.containsKey(tmp)) {
                tmp = random.nextInt(99) + 1;
            }
            map.put(tmp, 0);
            arr[i] = tmp;
        }
        arr[98] = 0;
        arr[99] = 0;
        FindTwoLostNum findTwoLostNum = new FindTwoLostNum();
        findTwoLostNum.findTwoNumber(arr);
        findTwoLostNum.findTwo(arr);
    }

    //使用异或运算求解
    public void findTwoNumber(int array[]) {
        int num1 = 0, num2 = 0;
        int temp = 0;
        for (int i = 0; i < 100; i++) {
            temp ^= (i + 1);
            temp ^= array[i];
        }
        int first_not_zero = 1;
        while (temp % 2 == 0) {
            first_not_zero++;
            temp = temp >> 1;
        }
        for (int i = 0; i < 100; i++) {
            if (((1 << (first_not_zero - 1)) & (i + 1)) == 0)
                num1 ^= (i + 1);
            else
                num2 ^= (i + 1);
            if (((1 << (first_not_zero - 1)) & array[i]) == 0)
                num1 ^= array[i];
            else
                num2 ^= array[i];
        }
    }

    public void findTwo(int[] arr) {
        int addArray = 0;
        long squareArray = 1;
        int addCommon = 0;
        long squareCommon = 1;
        for (int i = 0; i < 10; i++) {
            addArray += arr[i];
            if (arr[i] != 0) {
                squareArray = arr[i] * squareArray;
            }

            addCommon += i;
            squareCommon = squareCommon * (i + 1);
        }
        addCommon = addCommon + 98 + 99 + 100;
        squareCommon = squareCommon * 98 * 99 * 100;
        System.out.println(squareArray);
        System.out.println(squareCommon);
        int cha = addCommon - addArray;
        long cheng = squareCommon / squareArray;
        int num1 = 1;
        int num2 = cha - num1;
        while (!(num1 * num2 == cheng)) {
            num1++;
            num2--;
        }
        System.out.println(num1);
        System.out.println(num2);
    }
}
