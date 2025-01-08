package leetcode_problems;

public class P322_CoinChange {

    public static void main(String[] args) {
        P322_CoinChange p322CoinChange = new P322_CoinChange();
        System.out.println(p322CoinChange.coinChange(new int[]{1, 2147483647}, 2));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return -1;

        int[] ret = new int[amount + 1];
        for (int i = 1; i < ret.length; i++) {
            ret[i] = -1;
        }

        for (int i = 0; i < ret.length - 1; i++) {
            if (ret[i] == -1) {
                // not reachable
                continue;
            }

            for (int v : coins) {
                if (v > amount || i + v > amount) continue;

                if (ret[i] + 1 < ret[i + v] || ret[i + v] == -1) {
                    ret[i + v] = ret[i] + 1;
                }
            }
        }

        return ret[amount];
    }

}
