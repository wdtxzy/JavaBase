/**
 * @author : wangdi
 * @time : creat in 2019/4/14 22:27
 */
public class TestQuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{10,5,4,6,7,2,1,8,9,3};
        a = quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

    public static int[] quickSort(int[] a,int low,int high){
        int key = a[low];
        int start = low;
        int end = high;
        while (start < end){
            while (start<end&&a[end]>=key) {
                end--;
            }

                if (a[end] <= key) {
                    int tmp = a[end];
                    a[end] = a[start];
                    a[start] = tmp;
                }

            while (start<end&&a[start]<=key) {
                start++;
            }

                if (a[start] >= key) {
                    int tmp = a[start];
                    a[start] = a[end];
                    a[end] = tmp;
                }


            if(start>low){
                quickSort(a,low,start-1);
            }
            if(end<high){
                quickSort(a,end+1,high);
            }
        }
        return a;
    }
}
