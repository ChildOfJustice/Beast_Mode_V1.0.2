package core.application.states;

import camera.CameraContext;
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
import elements.MyBox;
import org.lwjgl.input.Mouse;

public class MainMenuAppState extends AbstractApplicationState {
    InputManager inputManager;

    //ALL OBJECTS

        //BUTTONS
        myButton playButton;



    public MainMenuAppState(AppStateManager stateManager, AssetManager am, AppSettings settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {
        super(stateManager, am, settings, inputManager, rootNode, cam, flyByCam);

        sceneCameraContext.flyByCam.setEnabled(false);
        System.out.println(sceneCameraContext.cam.getLocation());
        //sceneCameraContext.cam.setLocation(new Vector3f(0, 0, 1));
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);


        inputManager = app.getInputManager();

        initKeys();
        initObjects();

        //adding all buttons


    }

    private void  initObjects() {

//        myButton playButton2 = new myButton("PlayButton", new MyBox("PlayButton2", 0, 0, 0, "States\\Main menu\\Start.png", 1, 1, 0, this), 450-190, 308-177, 190, 308) {
//            @Override
//            void onAction() {
//            }
//        };
        allButtons.add(createButton("PlayButton", 320,240,100,50,"States\\Main menu\\Start.png", ()-> {
                    System.out.println("PRESSED");
                }



        ));



        //globalRootNode.attachChild(playButton2.box.pivot);
        //this.globalRootNode.attachChild(this.globalRootNode.getChild(playButtonName));
    }


    private void initKeys() {

        inputManager.addMapping("Pause",  new KeyTrigger(KeyInput.KEY_P));
        inputManager.addMapping("Left",   new KeyTrigger(KeyInput.KEY_J));
        inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_K));
        inputManager.addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));


        inputManager.addListener(actionListener, "Pause", "Click");
        inputManager.addListener(analogListener, "Left", "Right");

    }

    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {

            if (name.equals("Pause") && !keyPressed) {

            }
            if (name.equals("Click")) {
                for (myButton button : allButtons) {
                    if(Mouse.getEventX() >= button.xOnScreen - button.width && Mouse.getEventX() <= button.xOnScreen+button.width && Mouse.getEventY() >= button.yOnScreen - button.height && Mouse.getEventY() <= button.yOnScreen + button.height){
                        button.onAction();
//                        System.out.println(Mouse.getEventX());
//                        System.out.println(Mouse.getEventY());
                    }
                }



            }

        }
    };

    private final AnalogListener analogListener = (name, value, tpf) -> {



    };


    @Override
    public void update(float tpf) {
        super.update(tpf);


    }
}
