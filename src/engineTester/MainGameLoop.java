package engineTester;

import gameEngine.DisplayManager;

public class MainGameLoop {

    public static void main(String args[]) {
        DisplayManager dm = new DisplayManager();
        dm.createDisplay();
        while (!dm.isCloseRequested()) {

            dm.updateDisplay();
        }
        dm.closeDisplay();
    }

}
