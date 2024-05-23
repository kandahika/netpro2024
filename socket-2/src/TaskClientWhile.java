import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                if (number <= 1) {
                    System.out.println("Exiting...");
                    break;
                }

                ITask task = new TaskObject();
                task.setExecNumber(number);
                out.writeObject(task);

                ITask resultTask = (ITask) in.readObject();
                System.out.println("The largest prime number less than or equal to " + number + " is: " + resultTask.getResult());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
