package core.game;

import com.jme3.app.SimpleApplication;
import core.application.states.FirstSceneAppState;
import elements.Model;

public class TheGame extends SimpleApplication {
//TODO player move(); map with app states and main menu
    public Model map;

    static TheGame game;

    public static FirstSceneAppState firstScene;

    public TheGame() {
    }

    //
    public static void main(String[] args) {
        game = new TheGame();
        game.setShowSettings(false);
        game.start();
    }

    @Override
    public void simpleInitApp() {

//        ApplicationContext applicationContext = new ApplicationContext(stateManager, assetManager, settings,
//                inputManager, rootNode, cam, flyCam);
//
//        stateManager.attach(applicationContext);
//        applicationContext.initialize(stateManager, game);

        firstScene = new FirstSceneAppState(stateManager, assetManager, settings,
                inputManager, rootNode, cam, flyCam);

        stateManager.attach(firstScene);
        //firstScene.initialize(stateManager, game); IT HAS BEEN INITIALIZED ALREADY!!! <---------!

//        MainMenuAppState menu = new MainMenuAppState(stateManager, assetManager, settings,
//                inputManager, rootNode, cam, flyCam);
//
//        stateManager.attach(menu);
//        menu.initialize(stateManager, game);

    }
}
