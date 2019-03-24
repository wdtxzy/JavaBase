/**
 * @author : wangdi
 * @time : creat in 2019/3/21 14:06
 * 反转句子
 */
public class ReverseASentence {
    public static void main(String[] args) {
        String a = "much so you love I";
        StringBuffer stringBuffer = new StringBuffer();
        int dep = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == ' ') {
                dep = 0;
            }
            stringBuffer.insert(dep, c);
            if (c != ' ') {
                dep++;
            }
        }
        System.out.println(stringBuffer.toString());
    }


}
