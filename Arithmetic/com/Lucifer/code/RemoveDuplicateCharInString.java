import java.util.HashSet;

/**
 * @author : wangdi
 * @time : creat in 2019/3/21 10:42
 * 如何打印字符串中重复的字符？
 */
public class RemoveDuplicateCharInString {
    public static void main(String[] args) {

        String str = "aaabbbbbccccccdddddddddddeeeeeefgghjjytwerewtjjmo";
        RemoveDuplicateCharInString removeDuplicateCharInString = new RemoveDuplicateCharInString();
        removeDuplicateCharInString.remove(str);
    }

    public void remove(String str) {
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        HashSet<Character> set3 = new HashSet<Character>();
        char[] sr = str.toCharArray();
        for (char string : sr) {
            boolean add = set1.add(string);
            if (!add) {
                set2.add(string);
            }
        }
        set3.addAll(set1);
        set3.removeAll(set2);
        //消除重复后的字符
        System.out.println("消除重复后的字符串");
        for (char c : set1) {
            System.out.println(c);
        }
        //重复的字符
        System.out.println("重复的字符");
        for (char c : set2) {
            System.out.println(c);
        }
        //没有重复的字符
        System.out.println("没有重复的字符");
        for (char c : set3) {
            System.out.println(c);
        }
    }
}
