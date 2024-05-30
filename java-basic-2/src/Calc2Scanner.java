import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		int i=0;
		while(i<10) {

			int str = Integer.parseInt(scan.next());
			System.out.println("最初のトークンは: " + str);

			int str1 = Integer.parseInt(scan.next());
			System.out.println("次のトークンは  : " + str1);
            System.out.println("二つの数の和は: " + (str + str1));
			i++;
        
		}
        scan.close();
	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。