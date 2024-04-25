import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("何歳ですか? (終了するには 'q' または 'e' を入力してください)");
                String line = reader.readLine();
                if (line.equals("q") || line.equals("e")) {
                    System.out.println("プログラムを終了します。");
                    break;
                }

                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("有効な年齢を入力してください。");
                    continue;
                }

                int year = 2024; // 現在の年
                int birthYear = year - age;
                String eraName = getJapaneseEraName(birthYear);

                System.out.println("あなたは" + age + "歳ですね。");
                System.out.println("2030年には" + (age + 2030 - year) + "歳になります。");
                System.out.println("あなたは" + eraName + "に生まれました。");

            } catch (IOException e) {
                System.out.println("入出力エラーが発生しました: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("数値を入力してください。");
            }
        }
    }

    private static String getJapaneseEraName(int year) {
        if (year >= 2019) return "令和" + (year - 2019 + 1) + "年";  // 2019年は令和1年
        else if (year >= 1989) return "平成" + (year - 1989 + 1) + "年";  // 1989年は平成1年
        else if (year >= 1926) return "昭和" + (year - 1926 + 1) + "年";  // 1926年は昭和1年
        else if (year >= 1912) return "大正" + (year - 1912 + 1) + "年";  // 1912年は大正1年
        else return "明治" + (year - 1868 + 1) + "年";  // 1868年は明治1年
    }
    
}
