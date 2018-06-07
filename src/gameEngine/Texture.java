package gameEngine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;

public class Texture {

    private int id;
    private int width;
    private int height;

    public Texture(String filename) {
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File(filename));
            width = bi.getWidth();
            height = bi.getHeight();

            int[] pixels_raw = new int[width * height * 4];
            pixels_raw = bi.getRGB(width, width, 0, 0, null, width, 0);

            ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4); // тип имя переменной bytebuffer тип!

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int pixel = pixels_raw[i * width + j];
                    pixels.put((byte) ((pixel >> 16) & 0xFF));//red
                    pixels.put((byte) ((pixel >> 8) & 0xFF));//green
                    pixels.put((byte) ((pixel >> 0) & 0xFF));//blue
                    pixels.put((byte) ((pixel >> 24) & 0xFF));//alpha    
                }
            }
            pixels.flip();

            id = glGenTextures();

            glBindTexture(GL_TEXTURE_2D, id);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_BYTE, pixels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
