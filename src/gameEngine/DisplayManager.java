package gameEngine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.Version;
import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.*;

public class DisplayManager {
    private final static Logger LOGGER = Logger.getLogger(DisplayManager.class.getName());

    private long window;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public void createDisplay() {
        LOGGER.log(Level.INFO, " LWJGL: " + Version.getVersion());
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        window = glfwCreateWindow(WIDTH, HEIGHT, "Simple example", 0, 0);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        GL.createCapabilities();
    }

    public void updateDisplay() {
        LOGGER.log(Level.FINEST, "updateDisplay");
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    public void closeDisplay() {
        LOGGER.log(Level.INFO, "closeDisplay");
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public boolean isCloseRequested() {
        return glfwWindowShouldClose(window);
    }
}
