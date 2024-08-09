package Apps;

public class Main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> Server.main(new String[0]));
        serverThread.start();

        try {
            Thread.sleep(1000); // ждем секунду, чтобы сервер успел запуститься
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Client.main(new String[0]);
    }
}