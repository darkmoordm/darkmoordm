package engineTester;

import gameEngine.DisplayManager;
import gameEngine.Loader;
import gameEngine.Renderer;

import gameEngine.RawModel;

public class MainGameLoop {

    public static void main(String args[]) {
        DisplayManager dm = new DisplayManager();
        dm.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
            //left bottom ringle
            -0.5f, 0.5f, 0f,
            -0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f,
            //right top tringle
            0.5f, -0.5f, 0f,
            0.5f, 0.5f, 0f,
            -0.5f, 0.5f, 0f,};

        RawModel model = loader.loadVAO(vertices);

        while (!dm.isCloseRequested()) {
            renderer.prepare();
            renderer.render(model);

            dm.updateDisplay();
        }
        loader.cleanUP();
        dm.closeDisplay();
    }

}
