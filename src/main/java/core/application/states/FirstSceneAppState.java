package core.application.states;

import camera.CameraContext;
import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import core.Debug;
import core.application.AbstractApplicationState;
import elements.Model;
import elements.light.AllLight;
import elements.light.MySun;
import map.Map;
import player.CurrentPlayer;

import static com.jme3.math.ColorRGBA.White;



public class FirstSceneAppState extends AbstractApplicationState  implements ActionListener {

    public static CurrentPlayer currentPlayer;
    public static Model map;

    float initialX = 5.1f;
    float initialY = 5.6f;

    public FirstSceneAppState(AppStateManager stateManager, AssetManager am, AppSettings settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {
        super(stateManager, am, settings, inputManager, rootNode, cam, flyByCam);

    }


    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        setUpKeys();

        Map.initMap();


        currentPlayer = new CurrentPlayer(new Vector3f(initialX,0,initialY), "Test\\Player.png", "Test\\Player.obj");
        currentPlayer.gravity = 10;




        //map = new Model(0,-30,0, "MapTex.png", "Map.obj", this);

//        DirectionalLight sun = new DirectionalLight();
//        sun.setDirection(new Vector3f(0.1f, 0.7f, 1.0f));
//        globalRootNode.addLight(sun);

        //LIGHT
        MySun san = new MySun(10 , 30 , 10, White, this);
        AllLight globalLight = new AllLight(0.1f, White, this);
//        FlashLight q = new FlashLight(10,-25,10, White,10,2,30,30);
//        MyLamp s = new MyLamp(10,-25,10, White,30);
        //^


    }

    @Override
    public void update(float tpf) {
        super.update(tpf);

        //currentPlayer.gravitation(tpf, map.spatial);
        currentPlayer.move(tpf);

        Map.enableVisibleMap((int)currentPlayer.actualObject.pivot.getLocalTranslation().x - (int)initialX, (int)currentPlayer.actualObject.pivot.getLocalTranslation().z - (int)initialY);
    }





    public void setUpKeys() {
        globalInputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        globalInputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        globalInputManager.addMapping("Forward", new KeyTrigger(KeyInput.KEY_W));
        globalInputManager.addMapping("Backward", new KeyTrigger(KeyInput.KEY_S));
        globalInputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        globalInputManager.addListener(this, "Left");
        globalInputManager.addListener(this, "Right");
        globalInputManager.addListener(this, "Forward");
        globalInputManager.addListener(this, "Backward");
        globalInputManager.addListener(this, "Jump");
    }

    public void analyzeAction(String binding, boolean isPressed) {
        switch (binding) {
            case "Left":
                if (isPressed) {
                    if(currentPlayer.direction == CurrentPlayer.rightDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
                        currentPlayer.direction = CurrentPlayer.leftDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.backwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.leftDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.forwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.leftDirection;
                    }
                }

                currentPlayer.left = isPressed;
                break;
            case "Right":
                if (isPressed) {
                    if(currentPlayer.direction == CurrentPlayer.leftDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI, 0);
                        currentPlayer.direction = CurrentPlayer.rightDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.backwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.rightDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.forwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.rightDirection;
                    }
                }

                currentPlayer.right = isPressed;
                break;
            case "Forward":
                if (isPressed) {
                    if(currentPlayer.direction == CurrentPlayer.leftDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.forwardDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.backwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
                        currentPlayer.direction = CurrentPlayer.forwardDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.rightDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.forwardDirection;
                    }
                }

                currentPlayer.forward = isPressed;
                break;
            case "Backward":
                if (isPressed) {
                    if(currentPlayer.direction == CurrentPlayer.leftDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.backwardDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.forwardDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, FastMath.PI, 0);
                        currentPlayer.direction = CurrentPlayer.backwardDirection;
                    }
                    if(currentPlayer.direction == CurrentPlayer.rightDirection) {
                        currentPlayer.actualObject.spatial.rotate(0, -FastMath.PI/2, 0);
                        currentPlayer.direction = CurrentPlayer.backwardDirection;
                    }
                }

                currentPlayer.backward = isPressed;
                break;
            case "Jump":
                currentPlayer.jumpState = true;
                break;
        }
    }

    @Override
    public void onAction(String binding, boolean isPressed, float v) {
        analyzeAction(binding, isPressed);
    }
}
