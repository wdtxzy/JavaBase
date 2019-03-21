/**
 * @author : wangdi
 * @time : creat in 2019/3/21 11:05
 * 使用递归反转字符串
 */
public class RevertString {

    public static void main(String[] args) {
        String str = "asdafagafasfda";
        RevertString revertString = new RevertString();
        String revertStr = revertString.revert(str);
        System.out.println(revertStr);
    }

    public String revert(String str){
        if(str.length() == 1 || str.length() < 1){
            return str;
        }
        return revert(str.substring(1))+str.charAt(0);
    }
}
