import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Fractal {
    public static void main(String[] args) {
        int width = 2048/2;
        int height = 1536/2;
        int min = 9999999;
        int max = 999999999;
        Random random = new Random();
        
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            int wild1 = random.nextInt(max - min + 1) + min;
            for (int y = 0; y < height; y++) {
                int wild2 = random.nextInt(max - min + 1) + min;
                image.setRGB(x, y, (x-y-wild1+wild2)*(x+y+wild2-wild1)&(wild1|wild2)); 
            }
        }
        int name = random.nextInt(max - min + 1) + min;
        File img = new File("generated_art/iteration_" + name + ".png");
        try {
            ImageIO.write(image, "png", img);
        } catch (IOException e) {}
    }
}
