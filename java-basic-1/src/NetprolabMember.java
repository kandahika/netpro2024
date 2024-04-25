import java.util.Random;

public class NetprolabMember {
    public static final int years = 15;
    public static final int columns = 3;

    public static void main(String[] args) {
        int[][] members = new int[years][columns];
        Random random = new Random();
        double totalRatio = 1;

        for (int i = 0; i < years; i++) {
            // 学生の総数：110に対して+-10人でランダム
            members[i][0] = 110 + random.nextInt(21) - 10;  // 100から120まで
            // 女性の割合(%): 20%から毎年1%上昇
            members[i][1] = 20 + i;
            // 岩井研の配属人数：10に対して+-3人でランダム
            members[i][2] = 10 + random.nextInt(7) - 3;  // 7から13まで

            // 女性数を求める
            int women = (int) (members[i][0] * (members[i][1] / 100.0));
            // 男性数を求める
            int men = members[i][0] - women;

            // 総数から岩井研の人数を取り出す組み合わせ
            long cpsRatio = combination(members[i][0], members[i][2]);
            // 男性の中から岩井研のメンバーを取り出す組み合わせ
            long menRatio = combination(men, members[i][2]);
            // 岩井研の人数に男性しか入らない割合
            totalRatio *= (double) menRatio / cpsRatio;
        }

        System.out.println("15年間岩井研に女性の学生が来ない確率: " + totalRatio);
    }

    // 組み合わせ数を計算する関数
    public static long combination(int n, int r) {
        if (r > n) {
            return 0;
        }
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}
