package phisics;

import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;

/*
 Пример камеры от 3 лица
 Основан на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public abstract class AbstractPhysicBodyContext extends AbstractAppState
{

    private AppStateManager stateManager = null;
    //
    private static final BulletAppState bulletAppState;

    static
    {
        bulletAppState = new BulletAppState();
    }

    public AbstractPhysicBodyContext()
    {
    }

    /**
     @return bulletAppState
     */
    public BulletAppState getBulletAppState()
    {
        return bulletAppState;
    }

    /**
     @param stateManager stateManager устанавливает
     Присоединение BulletAppstate к Инициализации PhysicsSpace
     */
    public void attachBulletAppstate(AppStateManager stateManager)
    {
        this.stateManager = stateManager;
        stateManager.attach(bulletAppState);
    }
}
