package thread;

public class ExThreadsMainTest {
    public static void main(String[] args) {
        // 3つの異なるタスクを持つRunnableインスタンスを作成
        Runnable task1 = new Task1();
        Runnable task2 = new Task2();
        Runnable task3 = new Task3();

        // 各タスクを実行するスレッドを作成
        Thread thread1 = new Thread(task1, "Task1-Thread");
        Thread thread2 = new Thread(task2, "Task2-Thread");
        Thread thread3 = new Thread(task3, "Task3-Thread");

        // スレッドを開始
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// Task1: 数字をカウントするタスク
class Task1 implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                Thread.sleep(500); // 500ミリ秒ごとにカウント
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}

// Task2: アルファベットをカウントするタスク
class Task2 implements Runnable {
    public void run() {
        try {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println(Thread.currentThread().getName() + " - Alphabet: " + c);
                Thread.sleep(700); // 700ミリ秒ごとにカウント
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}

// Task3: 文字列を表示するタスク
class Task3 implements Runnable {
    public void run() {
        String[] messages = {"Hello", "World", "This", "Is", "Multithreading"};
        try {
            for (String msg : messages) {
                System.out.println(Thread.currentThread().getName() + " - Message: " + msg);
                Thread.sleep(900); // 900ミリ秒ごとにメッセージを表示
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
