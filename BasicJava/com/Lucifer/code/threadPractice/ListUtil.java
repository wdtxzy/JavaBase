package threadPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangdi
 * @time : creat in 2019/3/22 23:42
 * 分页
 */
public class ListUtil {

    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + pageSize - 1) / pageSize;
                if (pageIndex == (j + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == (j + 1) * pageSize) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
