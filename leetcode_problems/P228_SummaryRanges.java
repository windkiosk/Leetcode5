import java.util.ArrayList;
import java.util.List;

public class P228_SummaryRanges {

    public static void main(String[] args) {
        List<String> strings = summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(strings);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            ret.add("");
            return ret;
        } else if (nums.length == 1) {
            ret.add("" + nums[0]);
            return ret;
        }

        int first = nums[0];
        int last = first;
        StringBuilder builder = new StringBuilder();
        builder.append(first);
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (v == last + 1) {
                last = v;
            } else {
                if (first != last) {
                    builder = builder.append("->" + last);
                }
                ret.add(builder.toString());

                builder = new StringBuilder();
                builder.append(v);
                first = v;
                last = v;
            }
        }

        if (first != last) {
            builder = builder.append("->" + last);
        }
        ret.add(builder.toString());

        return ret;
    }
}
