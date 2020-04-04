package player;

import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import core.application.AbstractApplicationState;
import core.application.states.FirstSceneAppState;
import core.game.TheGame;
import elements.Model;


public class CurrentPlayer {
    public static AbstractApplicationState currentAppState;

    public boolean left = false, right = false, forward = false, backward = false;
    public boolean jumpState = false;
    public boolean ableToJump = true;

    public float v;

    public Model actualObject;
    public int jumpTimer;
    public float jumpSpeed;
    public int maxJumpTime;
    public float gravity = 1;

    int multiplerX = 1;
    int multiplerZ = 1;


    public int direction = rightDirection;
    public int height = 2;


    ////
    static public int rightDirection = 1;
    static public int leftDirection = 2;
    static public int forwardDirection = 3;
    static public int backwardDirection = 4;

    public CurrentPlayer(Vector3f pos, String textureFilePath, String modelFilePath){
        //currentAppState = appState;
        v = 10f;
        jumpSpeed = 10f;
        maxJumpTime = 100;

        actualObject = new Model(pos.x,pos.y,pos.z,textureFilePath,modelFilePath, TheGame.firstScene);
    }


    public void gravitation(float tpf, Spatial mapObject){
        boolean fall = true;

        CollisionResults results = new CollisionResults();
        //CurrentPlayer.actualObject.pivot.getLocalTranslation(), new Vector3f(0, -1, 0)
        Ray ray = new Ray(new Vector3f(FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().x, FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().y - height*2,FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().z), new Vector3f(0f, -1f, 0f));
        mapObject.collideWith(ray, results);
        if(results.size() > 0) {
            float dist = results.getCollision(0).getDistance();
            Vector3f pt = results.getCollision(0).getContactPoint();
            String hit = results.getCollision(0).getGeometry().getName();
            System.out.println("* Столкновение #" + 0);
            System.out.println(" Shoot in" + hit + " в " + pt + ", на " + dist + " wu.");
            if (dist < 1.0f) {
                fall = false;
            }
        }

        if(fall) moveToLocation(0, -gravity*tpf, 0);
    }

    private void moveToLocation(float x, float y, float z){
        //System.out.println(FirstSceneAppState.currentPlayer.actualObject.spatial.getLocalTranslation().z);
        FirstSceneAppState.currentPlayer.actualObject.pivot.setLocalTranslation(FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().x + x, FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().y + y, FirstSceneAppState.currentPlayer.actualObject.pivot.getLocalTranslation().z + z);
    }

    public void move(float tpf) {
//        if(actualObject.spatial.getLocalTranslation().x < 0) multiplerX = -1;
//        else multiplerX = 1;
//        if(actualObject.spatial.getLocalTranslation().z < 0) multiplerZ = -1;
//        else multiplerZ = 1;
        //forward swipe with backward
        if(backward)moveToLocation(0, 0, v*tpf);
        if(forward)moveToLocation(0, 0, -v*tpf);
        if(right)moveToLocation(v*tpf, 0, 0);
        if(left)moveToLocation(-v*tpf, 0, 0);
    }

//    public static void jump() {
//        Core.globalSpeed = playerShape.getLinearVelocity();
//        Core.globalSpeed.y = CurrentPlayer.jumpSpeed;
//        CurrentPlayer.jumpTimer++;
//        if(CurrentPlayer.jumpTimer >= CurrentPlayer.maxJumpTime){
//            CurrentPlayer.jumpState = false;
//            CurrentPlayer.jumpTimer = 0;
//        }
//    }
}
