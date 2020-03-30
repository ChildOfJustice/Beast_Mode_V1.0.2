package animation;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.scene.Spatial;
import player.listeners.PlayerInputActionListener;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class AvatarAnimationEventListener extends AbstractAppState implements AnimEventListener
{

    private final AnimChannel channel;
    private final AnimControl control;
    private final PlayerInputActionListener pial;
    private final AvatarAnimationHelper animHelper;
    private final PhysicsCharacter physicBody;
    /**

     @param pial
     @param pc
     @param avatarMesh
     */
    public AvatarAnimationEventListener(PlayerInputActionListener pial, PhysicsCharacter pc, Spatial avatarMesh)
    {
        this.pial = pial;
        this.control = avatarMesh.getControl(AnimControl.class);
        assert (this.control != null);
        this.channel = this.control.createChannel();
        this.physicBody = pc;
        this.animHelper = new AvatarAnimationHelper(this.physicBody, this.channel);
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app)
    {
        this.control.addListener(this);
        this.channel.setAnim("Idle1");
        this.channel.setSpeed(0.5f);
    }

    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Чтобы изменить тело сгенерированных методов, выберите Сервис | Шаблоны.
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Чтобы изменить тело сгенерированных методов, выберите Сервис | Шаблоны.

    }

    /**
     @return channel
     */
    protected AnimChannel getChannel()
    {
        return channel;
    }

    /**
     @return control
     */
    protected AnimControl getControl()
    {
        return control;
    }

    /**
     * @return animHelper
     */
    public AvatarAnimationHelper getAnimHelper()
    {
        return animHelper;
    }
}
