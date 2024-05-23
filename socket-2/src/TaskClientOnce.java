import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClientOnce {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            ITask task = new TaskObject();
            task.setExecNumber(100); // ここで計算させたい数を設定
            out.writeObject(task);

            ITask resultTask = (ITask) in.readObject();
            System.out.println("The largest prime number less than or equal to 100 is: " + resultTask.getResult());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
