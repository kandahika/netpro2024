public class XmasTreeKadai {
    public static void main(String[] args) {
        System.out.println("----step6.3-----");
        int N=19;
        int A=3;
        int B=7;
        for (int j = 0; j < N; j++) {

            for (int i = 0; i <= N-j; i++) {
                System.out.print("+");
            }

            for (int i = 0; i <= j*2; i++) {
                System.out.print("*");
            }
            for (int i = 0; i <= N-j; i++) {
                System.out.print("+");
            }
            


            System.out.print("\n");
        }
         // 幹の部分の描画
for (int j = 0; j < B; j++) {
            for (int i = 0; i <= N - A / 2; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < A; i++) {
                System.out.print("*");
            }
            for (int i = 0; i <= N - A / 2; i++) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        System.out.println("---------");
    }
}
