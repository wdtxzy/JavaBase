/**
 * @author : wangdi
 * @time : creat in 2019/3/21 19:54
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        int start = 0;
        int end = a.length-1;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a,start,end);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    public void sort(int[] arr,int low,int high){
        int start = low;
        int end = high;
        int key = arr[low];
        while(end>start){
            while(end>start&&arr[end]>=key)
                end--;
            if(arr[end]<=key){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前往后比较
            while(end>start&&arr[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(arr[start]>=key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(start>low) sort(arr,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) sort(arr,end+1,high);//右边序列。从关键值索引+1到最后一个
    }
}
