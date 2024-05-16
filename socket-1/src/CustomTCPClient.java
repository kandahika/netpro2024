import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class CustomTCPClient {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");

            try (Socket socket = new Socket("localhost", port);
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                System.out.println("接続されました");

                while (true) {
                    System.out.println("メッセージを入力してください(例:メリークリスマス) ↓ (終了するには 'quit' を入力)");
                    String message = scanner.next();
                    System.out.println("プレゼントの内容を入力してください(例:お菓子) ↓");
                    String content = scanner.next();

                    NewPresent present = new NewPresent();
                    present.setMessage(message);
                    present.setContent(content);

                    oos.writeObject(present);
                    oos.flush();

                    if ("quit".equalsIgnoreCase(message)) {
                        break;
                    }

                    NewPresent response = (NewPresent) ois.readObject();
                    String replayMsg = response.getMessage();
                    System.out.println("サーバからのメッセージは" + replayMsg);
                    String replayContent = response.getContent();
                    System.out.println(replayContent + "をもらいました！");
                }
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
