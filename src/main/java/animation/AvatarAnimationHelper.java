package animation;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.LoopMode;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.math.Vector3f;
import player.AvatarConstants;

public class AvatarAnimationHelper
{
    String secInline = "import boto3\nimport os\n    \ns3_client   = boto3.client('s3')\nglue_client = boto3.client('glue')\n    \ndef lambda_handler(event, context):\n    \n    dest_bucket_name = os.environ['dest_bucket_name']\n    crawler_name     = os.environ['crawler_name']\n    src_bucket_name  = event['Records'][0]['s3']['bucket']['name']\n    file = event['Records'][0]['s3']['object']['key']\n    \n    copy_source = {\n        'Bucket': src_bucket_name,\n        'Key': file\n    }\n    \n    print('Copying {} file from {} to {}...'.format(file, src_bucket_name, dest_bucket_name))\n    \n    s3_client.copy_object(\n        Bucket = dest_bucket_name,\n        CopySource = copy_source,\n        Key = file\n    )\n    \n    print('Copy completed successfully.')\n    \n    print('Checking if Crawler is running...')\n    \n    response = glue_client.get_crawler(Name = crawler_name)\n    \n    if(response['Crawler']['State'] in ['RUNNING','STOPPING']):\n        print('Crawler is running!')\n    else:\n        print('Starting the crawler...')\n        #glue_client.start_crawler(Name = crawler_name)\n        print('Crawler started successfully.')";
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
