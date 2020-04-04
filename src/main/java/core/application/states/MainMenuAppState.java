package core.application.states;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import core.application.AbstractApplicationState;

public class MainMenuAppState extends AbstractApplicationState {
    InputManager inputManager;

    public MainMenuAppState(AppStateManager stateManager, AssetManager am, AppSettings settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {
        super(stateManager, am, settings, inputManager, rootNode, cam, flyByCam);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        inputManager = app.getInputManager();

        initKeys();


        //adding all buttons


    }


    private void initKeys() {
        inputManager.addMapping("Pause",  new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Left",   new KeyTrigger(KeyInput.KEY_J));
        inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_K));
        inputManager.addMapping("Rotate", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        // Добавить названия к слушателю действий.
        inputManager.addListener(actionListener, "Pause");
        inputManager.addListener(analogListener, "Left", "Right", "Rotate");

    }

    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {

            if (name.equals("Pause") && !keyPressed) {

            }
        }
    };

    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {

            if (name.equals("Rotate")) {

                //System.out.println(inputManager.getCursorPosition());

            }

        }
    };
}
