package player;

import camera.CameraContext;
import com.jme3.app.Application;
import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.input.ChaseCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import core.Debug;
import phisics.AbstractPhysicBodyContext;
import phisics.AvatarPhysicBodyContext;
import player.listeners.PlayerInputActionListener;

public class AvatarBodyManager extends AbstractPhysicBodyContext {

    private InputManager inputManager;
    private final Node rootNode;
    //
    private final CameraContext cc;
    private final Camera cam;
    private final ChaseCamera chaseCam;
    //
    private final AvatarPhysicBodyContext apbc;
    private final AvatarSpatialBodyContext asbc;
    //
    private final PhysicsCharacter physicBody;
    private final Node avatar;
    private final BetterCharacterControl bcc;
    //

    private final PlayerInputActionListener playerInputListener;

    public AvatarBodyManager(AssetManager am, Node rootNode, CameraContext cc) {

        //
        this.rootNode = rootNode;
        //
        this.asbc = new AvatarSpatialBodyContext(am, rootNode);
        this.apbc = new AvatarPhysicBodyContext();
        //
        this.physicBody = apbc.getPhysicBody();

        this.avatar = asbc.getAvatar();
        this.bcc = new BetterCharacterControl(AvatarConstants.COLLISION_SHAPE_RADIUS,
                AvatarConstants.COLLISION_SHAPE_RADIUS * 2, AvatarConstants.PHYSIC_BODY_MASS);
        //
        this.playerInputListener = new PlayerInputActionListener(this.physicBody,
                this.asbc.getAvatarMesh());
        //
        this.cc = cc;
        this.cam = cc.getCam();
        this.chaseCam = cc.getChaseCam();
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //TODO: инициализируйте ваш AppState, например. присоедините spatial-ы к rootNode
        //это вызывается в потоке OpenGL после присоединения AppState

        stateManager.attach((AppState) this.asbc);
        stateManager.attach(this.apbc);
        stateManager.attach(this.playerInputListener);


//
        this.avatar.addControl(new AvatarBodyMoveControl(playerInputListener, physicBody, cam));
        this.avatar.addControl(chaseCam);
        this.avatar.addControl(bcc);

        //ОТЛАДКА
        Debug.showNodeAxes(app.getAssetManager(), avatar, 4);
        getBulletAppState().setDebugEnabled(true);
    }



    @Override
    public void update(float tpf) {
        //assert (sceneCameraContext != null);

        //correctDirectionVectors(cam.getDirection(), cam.getLeft());

    }
}