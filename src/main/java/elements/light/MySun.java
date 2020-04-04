package elements.light;

import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import core.application.AbstractApplicationState;

public class MySun {

    DirectionalLight sun;

    public MySun (float x, float y, float z, ColorRGBA color, AbstractApplicationState appState){

        sun = new DirectionalLight();
        sun.setColor(color);
        sun.setDirection(new Vector3f(x,y,z).normalizeLocal());
        appState.globalRootNode.addLight(sun);

    }

}
