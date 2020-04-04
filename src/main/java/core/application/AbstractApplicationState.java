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

public class AbstractApplicationState  extends AbstractAppState{
    public AssetManager globalAssetManager = null;
    public Node globalRootNode;
    public InputManager globalInputManager;


    private Node rootNode;
    private CameraContext sceneCameraContext;

    public AbstractApplicationState(AppStateManager stateManager, AssetManager am, AppSettings
            settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {

        this.rootNode = rootNode;
        this.sceneCameraContext = new CameraContext(settings, inputManager, cam, flyByCam);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //super.initialize(stateManager, app);
        //это вызывается в потоке OpenGL после присоединения AppState

        stateManager.attach(this.sceneCameraContext);

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
}