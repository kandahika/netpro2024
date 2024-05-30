public class XmasTreeKadai {

	public static void main(String[] args) {
		/*int i=0;
        int first,second;
		while(i<10) {
			Scanner scan = new Scanner(System.in);
            
			String str = scan.next();
			System.out.println("最初のトークンは: " + str);
            System.out.println("文字を分割すると・・・");
            String[] word = str.split(",");//splitメソッドの引数に、どこの文字で分割するか指定します。この場合は空白文字。
            for(String w:word) {
                System.out.println(w);
            }
            System.out.println("word[0]"+word[0]);
            System.out.println("word[1]"+word[1]);
            System.out.println("word[2]"+word[2]);
            System.out.println("word[3]"+word[3]);
            //19,3,7,c
            //first = Integer.parseInt(str);
            System.out.println("----次の数字の入力をお願いします ");
		}*/

        
        // 葉の最大半分の横幅を19として設定
        int maxWidthHalf = 19;
        // 幹の幅を3として設定
        int trunkWidth = 3;
        // 幹の長さを7として設定
        int trunkHeight = 7;

        // ツリーの葉の部分を出力
        for (int j = 0; j < maxWidthHalf; j++) {
            // 左側の'+'部分を出力
            for (int i = 0; i < maxWidthHalf - j; i++) {
                System.out.print("+");
            }
            // '*'の部分を出力
            for (int i = 0; i < (j * 2) + 1; i++) {
                System.out.print("*");
            }
            // 右側の'+'部分を出力
            for (int i = 0; i < maxWidthHalf - j; i++) {
                System.out.print("+");
            }
            System.out.println(); // 改行
        }

        // ツリーの幹の部分を出力
        int trunkCenter = maxWidthHalf - trunkWidth / 2;
        for (int j = 0; j < trunkHeight; j++) {
            // 幹の左側の'+'部分を出力
            for (int i = 0; i < trunkCenter; i++) {
                System.out.print("+");
            }
            // 幹の'*'部分を出力
            for (int i = 0; i < trunkWidth; i++) {
                System.out.print("*");
            }
            // 幹の右側の'+'部分を出力
            for (int i = 0; i < trunkCenter; i++) {
                System.out.print("+");
            }
            System.out.println(); // 改行
        }
    }
}
        
          


//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。