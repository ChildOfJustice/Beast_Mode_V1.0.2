package managers;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;

/*
 Следящая камера (также известная как камера от 3-его лица) пример
 Основанный на официальном TestQ3.java

 @author Alex Cham также известный как Jcrypto
 */
public class MaterialManager {

    public MaterialManager() {
    }


    //"Common/MatDefs/Misc/Unshaded.j3md"
    public static Material makeMaterial(AssetManager am, String name, ColorRGBA color)
    {
        Material mat = new Material(am, name);
        mat.setColor("Color", color);
        return mat;
    }
}
