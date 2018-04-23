package gameEngine;

import org.lwjgl.Version;
import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;

public class DisplayManager {

    private long window;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public void createDisplay() {
        System.out.println(" LWJGL: " + Version.getVersion());
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        window = glfwCreateWindow(WIDTH, HEIGHT, "Simple example", 0, 0);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);

    }

    public void updateDisplay() {
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    public void closeDisplay() {
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public boolean isCloseRequested() {
        return glfwWindowShouldClose(window);
    }
}
