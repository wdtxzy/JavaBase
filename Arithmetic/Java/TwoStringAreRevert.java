/**
 * @author : wangdi
 * @time : creat in 2019/3/21 10:54
 * 判断两个字符串是否逆序，判断两个字符串是否为旋词
 */
public class TwoStringAreRevert {
    public static void main(String[] args) {

    }

    //判断两个字符串是否为逆序
    public boolean IsThisAreRevert(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        char[] st1 = str1.toCharArray();
        char[] st2 = str2.toCharArray();
        for(int i=0;i<st1.length;i++){
            if(st1[i] !=st2[st2.length-1-i]){
                return false;
            }
        }
        return true;
    }

    //判断两个字符串是否为旋词
    public boolean IsThisAreXuanCi(String str1,String str2){
        String st1 = str1 + str1;
        String st2 = str2 + str2;
        if(st1.contains(str2) && st2.contains(str1)){
            return true;
        }else {
            return false;
        }
    }
}
