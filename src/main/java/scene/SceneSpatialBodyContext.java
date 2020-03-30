package scene;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import player.AbstractSpatialBodyContext;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class SceneSpatialBodyContext extends AbstractSpatialBodyContext
{

    private final Node rootNode;
    //
    private final Node scene;
    private AmbientLight ambient;
    private DirectionalLight sun;
    /**

     @param am
     @param rootNode
     */
    public SceneSpatialBodyContext(AssetManager am, Node rootNode)
    {
        this.rootNode = rootNode;
        //
        am.registerLocator("town.zip", ZipLocator.class);
        this.scene = (Node) am.loadModel("main.scene");
        this.ambient = new AmbientLight();
        this.sun = new DirectionalLight();
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
        //Загрузка главной Сцены

        this.scene.setLocalScale(0.1f);
        this.scene.scale(32.0f);
        //
        this.sun.setDirection(new Vector3f(1.4f, -1.4f, -1.4f));
        this.scene.setLocalTranslation(Vector3f.ZERO);
        //

        rootNode.attachChild(this.scene);
        rootNode.addLight(this.ambient);
        rootNode.addLight(this.sun);
    }

    /**
     @return the scene
     */
    public Node getScene()
    {
        return scene;
    }
}
