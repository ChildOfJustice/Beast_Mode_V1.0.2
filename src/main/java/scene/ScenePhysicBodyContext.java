package scene;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.scene.Node;
import phisics.AbstractPhysicBodyContext;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class ScenePhysicBodyContext extends AbstractPhysicBodyContext
{
    private final RigidBodyControl rigidBodyControl;
    private final Node scene;

    /**

     @param scene
     */
    public ScenePhysicBodyContext(Node scene)
    {
        this.scene = scene;
        this.rigidBodyControl = new RigidBodyControl(.0f);
    }


    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
        //
        //Добавим scene к PhysicsSpace
        System.out.println(this.getClass().getName() + ".getBulletAppState().hashCode() = " + getBulletAppState().hashCode());
        scene.addControl(rigidBodyControl);
        getBulletAppState().getPhysicsSpace().addAll(scene);
    }

}
