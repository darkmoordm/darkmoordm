package gameEngine;

import org.lwjgl.Version;
import org.lwjgl.glfw.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class DisplayManager {

    private long window;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public void createDisplay() {
        System.out.println(" LWJGL: " + Version.getVersion());
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        window = glfwCreateWindow(WIDTH, HEIGHT, "Simple example", 0, 0);
    }

    public void updateDisplay() {
        glfwPollEvents();
    }

    public void closeDisplay() {
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public boolean isCloseRequested() {
        return glfwWindowShouldClose(window);
    }
}
