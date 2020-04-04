package map;

import com.jme3.scene.Node;
import core.application.AbstractApplicationState;
import map.mapParticle.ParticleSimple;

import static core.game.TheGame.firstScene;

public class Map {
    static int size= 100;
    public static ParticleSimple[][] map = new ParticleSimple[size][size];

    public static int mapY = -5;

    public static AbstractApplicationState currentAppState;

    public static void initMap() {
        currentAppState = firstScene;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j % 2 == 0) {
                    map[i][j] = new ParticleSimple(i * 1.73f, mapY, j*1.5f,"Test\\simpleParticle.png","Test\\simpleParticle.obj" ,currentAppState);
                } else {
                   map[i][j] = new ParticleSimple(i * 1.73f+1.73f/2f, mapY, j * 1.5f,"Test\\simpleParticle.png","Test\\simpleParticle.obj",currentAppState);
                }
            }
        }
    }
    public static void enableVisibleMap(int x, int z) {
        try {
            Map.enable(x,z,2,1);
            Map.enable(x,z,3,1);
            Map.enable(x,z,4,1);
            Map.enable(x,z,1,2);
            Map.enable(x,z,2,2);
            Map.enable(x,z,3,2);
            Map.enable(x,z,4,2);
            Map.enable(x,z,1,3);
            Map.enable(x,z,2,3);
            Map.enable(x,z,3,3);
            Map.enable(x,z,4,3);
            Map.enable(x,z,5,3);
            Map.enable(x,z,1,4);
            Map.enable(x,z,2,4);
            Map.enable(x,z,3,4);
            Map.enable(x,z,4,4);
            Map.enable(x,z,2,5);
            Map.enable(x,z,3,5);
            Map.enable(x,z,4,5);
            Map.switchOff(x,z,1,0);
            Map.switchOff(x,z,2,0);
            Map.switchOff(x,z,3,0);
            Map.switchOff(x,z,4,0);
            Map.switchOff(x,z,5,1);
            Map.switchOff(x,z,5,2);
            Map.switchOff(x,z,6,3);
            Map.switchOff(x,z,5,4);
            Map.switchOff(x,z,5,5);
            Map.switchOff(x,z,4,6);
            Map.switchOff(x,z,3,6);
            Map.switchOff(x,z,2,6);
            Map.switchOff(x,z,1,6);
            Map.switchOff(x,z,1,5);
            Map.switchOff(x,z,0,4);
            Map.switchOff(x,z,0,3);
            Map.switchOff(x,z,0,2);
            Map.switchOff(x,z,1,1);

        }
        catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }
    private static void switchOff(int x1, int z1, int x2, int z2) {
        map[x1+x2][z1+z2+1].isEnabled = false;
        currentAppState.globalRootNode.detachChild(map[x1+x2][z1+z2+1].spatial);

    }
    private static void enable(int x1, int z1, int x2, int z2) {
        map[x1+x2][z1+z2+1].isEnabled = true;
        currentAppState.globalRootNode.attachChild(map[x1+x2][z1+z2+1].spatial);
    }
}




