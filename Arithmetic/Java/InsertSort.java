/**
 * @author : wangdi
 * @time : creat in 2019/3/21 20:15
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {12,20,5,16,15,1,30,45,23,9};
        insertSort(a);
        printArray(a);
    }

    public static void insertSort(int[] a){
        int i;
        int j;
        for( i=1;i<a.length;i++){
            int temp=a[i];
            if(a[i-1]>a[i]){
                for(j=i-1;j>=0;j--){
                    if(temp<a[j]){
                        a[j+1]=a[j];
                        // a[j]=temp;
                    }else{
                        break;
                    }
                }
                a[j+1]=temp;
            }

        }
    }

    public static void printArray(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
