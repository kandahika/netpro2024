import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CustomTCPServer {

    private static final int times = 2;

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁");
        for (int i = 0; i < times; i++) {
            sb.append(content);
        }
        sb.append("🎁");
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");

            try (ServerSocket server = new ServerSocket(port)) {
                Socket socket = server.accept();
                System.out.println("接続しました。相手の入力を待っています......");

                try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

                    while (true) {
                        NewPresent present = (NewPresent) ois.readObject();
                        if ("quit".equalsIgnoreCase(present.getMessage())) {
                            System.out.println("終了コマンドが送信されました。サーバーを終了します。");
                            break;
                        }

                        String msgPresent = present.getMessage();
                        System.out.println("メッセージは" + msgPresent);
                        String presentFromClient = present.getContent();
                        System.out.println("プレゼントの内容は" + presentFromClient);

                        NewPresent response = new NewPresent();
                        response.setMessage("サーバーです。メリークリスマス！\n" + presentFromClient + "ありがとう。\nプレゼントのお返しは" + times + "倍" + "です");
                        response.setContent(serverProcess(presentFromClient));

                        oos.writeObject(response);
                        oos.flush();
                    }
                }
                socket.close();
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
