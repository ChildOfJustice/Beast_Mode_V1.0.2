package core.application;

import camera.CameraContext;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import core.Debug;
import scene.SceneBodyManager;
import player.AvatarBodyManager;

public class ApplicationContext extends AbstractAppState {

    private final Node rootNode;
    //
    private final CameraContext sceneCameraContext;
    private final AvatarBodyManager avatarBodyManager;
    private final SceneBodyManager sceneBodyManager;

    public ApplicationContext(AppStateManager stateManager, AssetManager am, AppSettings
            settings, InputManager inputManager, Node rootNode, Camera cam, FlyByCamera flyByCam) {

        this.rootNode = rootNode;
        this.sceneCameraContext = new CameraContext(settings, inputManager, cam, flyByCam);
        this.sceneBodyManager = new SceneBodyManager(stateManager, am, rootNode);
        this.avatarBodyManager = new AvatarBodyManager(am, rootNode, sceneCameraContext);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //super.initialize(stateManager, app);
        //это вызывается в потоке OpenGL после присоединения AppState

        stateManager.attach(this.sceneCameraContext);
        stateManager.attach(this.sceneBodyManager);

        //инициализация конструктора physic spacein
        stateManager.attach(this.avatarBodyManager);

        Debug.showNodeAxes(app.getAssetManager(), this.rootNode, 1024.0f);
        Debug.attachWireFrameDebugGrid(app.getAssetManager(),
                rootNode, Vector3f.ZERO, 2048, ColorRGBA.DarkGray);
    }

    @Override
    public void update(float tpf) {

    }
}
