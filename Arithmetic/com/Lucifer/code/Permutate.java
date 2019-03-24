/**
 * @author : wangdi
 * @time : creat in 2019/3/21 13:43
 */
public class Permutate {

    public static void main(String[] args) {

        String a = "asdc";
        char[] chars = a.toCharArray();
        Permutate permutate = new Permutate();
        permutate.allPermutate(chars, 0, chars.length - 1);
    }

    public void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public void allPermutate(char[] chars, int from, int to) {
        if (from == to) {
            System.out.println(chars);
        } else {
            for (int i = from; i <= to; i++) {
                swap(chars, i, from);
                allPermutate(chars, from + 1, to);
                swap(chars, from, i);
            }
        }
    }

}
