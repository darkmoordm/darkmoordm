package engineTester;

import gameEngine.DisplayManager;
import gameEngine.Loader;
import gameEngine.Renderer;

import gameEngine.RawModel;
import shaders.StaticShader;

public class MainGameLoop {

    public static void main(String args[]) {
        DisplayManager dm = new DisplayManager();
        dm.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();
        
        

        float[] vertices = {
            -0.5f, 0.5f, 0f,
            -0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f,            
            0.5f, 0.5f, 0.0f,
            };
        
        int[] indices = {
            0,1,2,
            0,2,3
             
                 
            
        };
        
        RawModel model = loader.loadVAO(vertices, indices);

        while (!dm.isCloseRequested()) {
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();

            dm.updateDisplay();
        }
        shader.cleanUP();
        loader.cleanUP();
        dm.closeDisplay();
    }

}
