package elements;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import core.application.AbstractApplicationState;

public class MyBox extends WorldObject  {
    public MyBox(float x, float y, float z,String TextureFileName,float width, float height, float depth, AbstractApplicationState appState) {
        Box box = new Box(width, height, depth);
        geom = new Geometry("<NAME>", box);
//      geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        this.texture = appState.globalAssetManager.loadTexture(TextureFileName);
        mat = new Material(appState.globalAssetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTexture("ColorMap", texture);
        geom.setMaterial(mat);

        geom.setLocalTranslation(new Vector3f(x, y, z));

        shape = new BoxCollisionShape(new Vector3f(10,2,10));
        //bodyControl = new RigidBodyControl(shape, 0);
        //pivot = new Node("AAAAA!!!!!");
        //spatial = pivot;
        //spatial.addControl(bodyControl);
        //globalRootNode.attachChild(pivot);

        //pivot = new Node("pivot");
        //pivot.attachChild(geom);
        //pivot.setLocalTranslation(new Vector3f(x, y, z));
        appState.globalRootNode.attachChild(geom);
    }

}
