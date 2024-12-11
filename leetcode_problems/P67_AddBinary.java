package leetcode_problems;

public class P67_AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int l = Math.max(a.length(), b.length());
        StringBuilder ret = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < l; i++) {
            int ia = a.length() - i - 1;
            int ib = b.length() - i - 1;

            if (ia >= 0 && a.charAt(ia) == '1') {
                carry++;
            }
            if (ib >= 0 && b.charAt(ib) == '1') {
                carry++;
            }
            if (carry % 2 == 1) {
                ret.append('1');
            } else {
                ret.append('0');
            }

            carry /= 2;
        }
        if (carry == 1) {
            ret.append('1');
        }
        ret.reverse();
        return ret.toString();
    }
}
