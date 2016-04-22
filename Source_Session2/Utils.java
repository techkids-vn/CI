import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Utils {
    public static Image loadImage(String url) {
        try {
            Image img = ImageIO.read(new File(url));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
