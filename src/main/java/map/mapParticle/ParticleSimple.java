package map.mapParticle;

import com.jme3.material.Material;
import com.jme3.scene.Spatial;
import core.application.AbstractApplicationState;

import static map.Map.*;

public class ParticleSimple {
    public Spatial spatial;
    public boolean isEnabled;
    public ParticleSimple(float xParticleS, float yParticleS, float zParticleS,String fileTexture,String fileModel, AbstractApplicationState appState) {
        spatial = appState.globalAssetManager.loadModel(fileModel);
        spatial.setName("map");
        Material tex = new Material(appState.globalAssetManager, "Common/MatDefs/Light/Lighting.j3md");
        tex.setTexture("DiffuseMap", appState.globalAssetManager.loadTexture(fileTexture));
        spatial.setMaterial(tex);
        spatial.move(xParticleS, yParticleS, zParticleS);

    }
}
