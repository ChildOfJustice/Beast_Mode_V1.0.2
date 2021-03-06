package core.application;

import camera.CameraContext;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import core.Debug;
import elements.MyBox;

import java.util.ArrayList;

public class AbstractApplicationState  extends AbstractAppState{
    public AssetManager globalAssetManager = null;
    public Node globalRootNode;
    public InputManager globalInputManager;

    public ArrayList<myButton> allButtons = new ArrayList<>();

    private Node rootNode;
    protected CameraContext sceneCameraContext;

    public AbstractApplicationState(AppStateManager stateManager, AssetManager am, AppSettings
            settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {

        this.rootNode = rootNode;
        this.sceneCameraContext = new CameraContext(settings, inputManager, cam, flyByCam);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //super.initialize(stateManager, app);
        //это вызывается в потоке OpenGL после присоединения AppState


//        stateManager.attach(this.sceneCameraContext);

        globalAssetManager = app.getAssetManager();
        globalInputManager = app.getInputManager();
        globalAssetManager.registerLocator("assets", FileLocator.class);

        globalRootNode = rootNode;

//        Debug.showNodeAxes(app.getAssetManager(), this.rootNode, 1024.0f);
//        Debug.attachWireFrameDebugGrid(app.getAssetManager(),
//                rootNode, Vector3f.ZERO, 2048, ColorRGBA.DarkGray);
    }

    @Override
    public void update(float tpf) {

    }

    public static abstract class myButton{
        public String playButtonName;
        public MyBox box;
        public int xOnScreen;
        public int yOnScreen;
        public int width;
        public int height;

        public myButton(String playButtonName_, MyBox box_, int xOnScreen_, int yOnScreen_, int width_, int height_){
            xOnScreen = xOnScreen_;
            yOnScreen = yOnScreen_;
            width = width_;
            height = height_;
            playButtonName = playButtonName_;
            box = box_;
        }

        public abstract void onAction();
    }

    public myButton createButton(String playButtonName_, int xOnScreen_, int yOnScreen_, int width_, int height_,  String textureFileName_, Clickable method){
        float pixelsInOneMeter = 60f;

        myButton newButton = new myButton(playButtonName_, new MyBox(playButtonName_,(xOnScreen_-320)/pixelsInOneMeter, (yOnScreen_-240)/pixelsInOneMeter, 0, textureFileName_, width_/pixelsInOneMeter, height_/pixelsInOneMeter, 0, this),xOnScreen_,yOnScreen_,width_,height_) {
            @Override
            public void onAction() {
                method.onAction();
            }
        };
        globalRootNode.attachChild(newButton.box.pivot);
        return newButton;
    }
}