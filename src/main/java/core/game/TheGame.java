package core.game;

import com.jme3.app.SimpleApplication;
import core.application.ApplicationContext;

public class TheGame extends SimpleApplication {

    private ApplicationContext applicationContext;

    public TheGame() {
    }

    //
    public static void main(String[] args) {
        TheGame game = new TheGame();
        game.setShowSettings(false);
        game.start();
    }

    @Override
    public void simpleInitApp() {
        this.applicationContext = new ApplicationContext(stateManager, assetManager, settings,
                inputManager, rootNode, cam, flyCam);
        //
        stateManager.attach(applicationContext);
    }
}
