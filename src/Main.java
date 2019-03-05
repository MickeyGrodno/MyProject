import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, AWTException {
        MyThread thread = new MyThread();
        thread.run();
    }
}
