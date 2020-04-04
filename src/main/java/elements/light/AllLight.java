package elements.light;

import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import core.application.AbstractApplicationState;

public class AllLight {
    public AllLight (float power, ColorRGBA color, AbstractApplicationState appState){
        AmbientLight al = new AmbientLight();
        al.setColor(color.mult(power));
        appState.globalRootNode.addLight(al);
    }
}
