import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc2ScannerFile {

    public static void main(String args[]) {
        File file = new File("targetfile.txt");
        // try-with-resourcesを使用してScannerを自動でクローズ
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\\r\\n|\\n");  // Windows と Unix の両方の改行コードに対応

            int line = 1;

            while(scan.hasNextInt()) {  // ファイルから整数が読み取れるか確認
                if(scan.hasNextInt()) {
                    int firstNumber = scan.nextInt();  // 最初の数値を読み取る
                    if(scan.hasNextInt()) {
                        int secondNumber = scan.nextInt();  // 次の数値を読み取る
                        int sum = firstNumber + secondNumber;  // 二つの数値を足す
                        System.out.println(line + ": " + firstNumber + " + " + secondNumber + " = " + sum);  // 結果を出力
                        line++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません: " + e.getMessage());
        }
    }
}
