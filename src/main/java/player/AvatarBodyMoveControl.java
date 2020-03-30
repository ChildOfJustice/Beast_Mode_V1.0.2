package player;

import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import player.listeners.PlayerInputActionListener;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class AvatarBodyMoveControl extends AbstractControl
{
    private final Camera cam;
    private final PhysicsCharacter physicBody;
    private final PlayerInputActionListener pial;
    /**

     @param pial
     @param physicBody
     @param cam
     */
    public AvatarBodyMoveControl(PlayerInputActionListener pial,
                                 PhysicsCharacter physicBody, Camera cam)
    {
        this.pial = pial;
        this.physicBody = physicBody;
        this.cam = cam;
    }
    private final Vector3f walkDirection = new Vector3f();

    @Override
    protected void controlUpdate(float tpf)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Чтобы изменить тело сгенерированных методов, выберите Сервис | Шаблоны.
        correctDirectionVectors();
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp)
    {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Чтобы изменить тело сгенерированных методов, выберите Сервис | Шаблоны.
    }


    /**

     */
    public void correctDirectionVectors()
    {
//        assert (camDir != null);
//        assert (camLeft != null);
//        assert (walkDirection != null);
        //Влияет на скорость перемещения вперед, назад при 0.6f медленнее - при 1.0f быстрее
        Vector3f camDirVector = cam.getDirection().clone().multLocal(AvatarConstants.FORWARD_MOVE_SPEED);
        //Влияет на скорость перемещения влево, вправо при 0.6f медленнее - при 1.0f быстрее
        Vector3f camLeftVector = cam.getLeft().clone().multLocal(AvatarConstants.SIDEWARD_MOVE_SPEED);

        walkDirection.set(0, 0, 0);//critical
        if (pial.isLeftward())
        {
            walkDirection.addLocal(camLeftVector);
        }
        if (pial.isRightward())
        {
            walkDirection.addLocal(camLeftVector.negate());
        }
        if (pial.isForward())
        {
            walkDirection.addLocal(camDirVector);
        }
        if (pial.isBackward())
        {
            //@TODO Баг если направление камеры (0, -n, 0) - персонаж летит в верх &#x1f609;
            walkDirection.addLocal(camDirVector.negate());
        }
        physicBody.setWalkDirection(walkDirection);//Critical



        //Избегайте вибрации
        spatial.setLocalTranslation(physicBody.getPhysicsLocation());
        //Соответствующие преобразования Узла
        spatial.getControl(BetterCharacterControl.class).warp(physicBody.getPhysicsLocation());
        //Повернём узел в соответствии с камерой
        spatial.getControl(
                BetterCharacterControl.class).setViewDirection(
                cam.getDirection().negate());

    }
}
