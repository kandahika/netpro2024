import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
        Random random = new Random();
        int[] scores = new int[100];  // 100人の学生の点数を格納する配列
        int total = 0;

        // 100人の学生に対してランダムな点数を生成し、配列に格納
        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(101);  // 0から100までのランダムな点数
            total += scores[i];  // 点数を合計に加える
        }

        // 平均点の計算
        int average = total / scores.length;
        System.out.println("平均点は" + average );

        // 合格者の抽出と昇順ソート
        int[] passingScores = Arrays.stream(scores).filter(score -> score >= 80).toArray();
        Arrays.sort(passingScores);

        // 合格者の点数の表示
        if (passingScores.length > 0) {
            System.out.println("以下合格者の点数です。");
            for (int score : passingScores) {
                System.out.println(score);
            }
        } else {
            System.out.println("合格者はいません。");
        }
    }
}
