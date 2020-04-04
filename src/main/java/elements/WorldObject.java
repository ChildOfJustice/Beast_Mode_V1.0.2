package elements;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;


public class WorldObject {
    public Geometry geom;
    public Texture texture;
    public Material mat;
    public Node pivot;
    public Spatial spatial;
    public CollisionShape shape;

}
