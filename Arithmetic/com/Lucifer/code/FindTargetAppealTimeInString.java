/**
 * @author : wangdi
 * @time : creat in 2019/3/21 11:15
 * 给定一个字符，如同计算它在字符串中出现的次数？
 */
public class FindTargetAppealTimeInString {

    public static void main(String[] args) {

        String string = "asdasfqwrwqfsafarwqfsrwqt";
        FindTargetAppealTimeInString findTargetAppealTimeInString = new FindTargetAppealTimeInString();
        int time1 = findTargetAppealTimeInString.findByAll(string, "a");
        int time2 = findTargetAppealTimeInString.replace(string, "a");
        System.out.println(time1);
        System.out.println(time2);
    }

    //用遍历的方式
    public int findByAll(String string, String target) {
        int time = 0;
        while (string.lastIndexOf(target) > 0) {
            time++;
            int index = string.lastIndexOf(target);
            string = string.substring(0, index);
        }
        return time;
    }

    //用replace的方法
    public int replace(String string, String target) {
        string = string.replaceAll(target, " ");
        String[] arr = string.split(" ");
        return arr.length - 1;
    }
}
