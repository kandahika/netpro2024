import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class CheckLocalAddress {

    public static void main(String[] args) {
        try {
            // ローカルホストのアドレスを取得
            InetAddress localHost = InetAddress.getLocalHost();

            // すべてのネットワークインターフェースを取得
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            // 各ネットワークインターフェースを調べる
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                // ネットワークインターフェースの各アドレスを調べる
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof java.net.Inet4Address && !inetAddress.isLoopbackAddress()) {
                        System.out.println("ホスト名: " + localHost.getHostName());
                        System.out.println("IPv4アドレス: " + inetAddress.getHostAddress());
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
