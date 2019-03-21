import java.util.Random;

/**
 * @author : wangdi
 * @time : creat in 2019/3/20 23:20
 */
public class FindMaxAndMinInArray {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for(int i=0;i<100;i++){
            int tmp = random.nextInt(99)+1;
            arr[i] = tmp;
        }
        FindMaxAndMinInArray findMaxAndMinInArray = new FindMaxAndMinInArray();
        findMaxAndMinInArray.findMaxAndMin(arr);
    }

    public void findMaxAndMin(int[] arr){
        int length = arr.length;
        int tmp = 0;
        int max = 0;
        int min = 0;
        for(int i =0;i<length/2;i++){
            if(arr[i]<arr[length-i-1]){
                tmp = arr[i];
                arr[i] = arr[length-1-i];
                arr[length-1-i] = tmp;
            }
        }
        if(length%2==0){
            for(int i=0;i<length/2;i++){
                max = (arr[i] > max) ? arr[i] : max;
            }
            for(int i =length/2;i<length;i++){
                min = (arr[i]>min) ? min : arr[i];
            }
        }else{
            max = arr[length/2+1];
            min = arr[length/2+1];
            for(int i=0;i<length/2;i++){
                max = (arr[i] > max) ? arr[i] : max;
            }
            for(int i =length/2;i<length;i++){
                min = (arr[i]>min) ? min : arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
