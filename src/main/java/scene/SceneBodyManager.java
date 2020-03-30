package scene;

import com.jme3.app.Application;
import com.jme3.app.state.AppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import phisics.AbstractPhysicBodyContext;
import scene.ScenePhysicBodyContext;
import scene.SceneSpatialBodyContext;

public class SceneBodyManager extends AbstractPhysicBodyContext {

    private final ScenePhysicBodyContext spbc;
    private final SceneSpatialBodyContext ssbc;

    public SceneBodyManager(AppStateManager stateManager, AssetManager am, Node rootNode) {
        this.ssbc = new SceneSpatialBodyContext(am, rootNode);
        this.spbc = new ScenePhysicBodyContext(ssbc.getScene());
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //Инициализация PhysicsSpace
        attachBulletAppstate(stateManager);
//
        stateManager.attach((AppState) this.ssbc);
        stateManager.attach(this.spbc);

    }
}
