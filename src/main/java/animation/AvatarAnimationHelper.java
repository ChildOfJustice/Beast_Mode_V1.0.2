package animation;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.LoopMode;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.math.Vector3f;
import player.AvatarConstants;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class AvatarAnimationHelper
{

    private final AnimChannel animChannel;
    private final PhysicsCharacter physicBody;
    /**

     @param pc
     @param ac
     */
    public AvatarAnimationHelper(PhysicsCharacter pc, AnimChannel ac)
    {
        this.animChannel = ac;
        this.physicBody = pc;
    }

    protected void idle()
    {
        animChannel.setAnim("Idle1");
        animChannel.setSpeed(0.5f);
    }

    public boolean forward(boolean pressed)
    {
        if (pressed)
        {
            if (this.physicBody.onGround())
            {
                animChannel.setAnim("Walk");
                animChannel.setSpeed(AvatarConstants.FORWARD_MOVE_SPEED * 2f);
                animChannel.setLoopMode(LoopMode.Loop);
            }
            return true;
        } else
        {
            idle();
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        //Чтобы изменить тело сгенерированных методов, выберите Сервис | Шаблоны.
    }

    public boolean backward(boolean pressed)
    {
        if (pressed)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public boolean rightward(boolean pressed)
    {
        if (pressed)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public boolean leftward(boolean pressed)
    {
        if (pressed)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public boolean jump(boolean pressed)
    {
        if (pressed)
        {
            if (this.physicBody.onGround())
            {
                animChannel.setAnim("HighJump");
                animChannel.setSpeed(AvatarConstants.FORWARD_MOVE_SPEED / 1.8f);
                animChannel.setLoopMode(LoopMode.DontLoop);
                //
                this.physicBody.jump();
            }
            return true;
        } else
        {
            return false;
        }
    }
}
